package org.eclipse.scada.configuration.component.tools.wizard;

import javax.script.Compilable;
import javax.script.CompiledScript;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.configuration.component.tools.Activator;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.script.Scripts;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ScriptPage extends WizardPage
{

    private static final int SCRIPTS_HISTORY_LIMIT = 10;

    private final WritableValue scriptValue = new WritableValue ();

    private Compilable engine;

    private CompiledScript script;

    private Text text;

    private CCombo combo;

    private Button load;

    private Button delete;

    protected ScriptPage ()
    {
        super ( "script" );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        setTitle ( "Enter name script" );

        final DataBindingContext dbc = new DataBindingContext ();

        WizardPageSupport.create ( this, dbc );

        parent.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                dbc.dispose ();
            }
        } );

        final int buttons = 3;

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );
        wrapper.setLayout ( new GridLayout ( buttons + 1, false ) );
        this.combo = new CCombo ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        final GridData gd = new GridData ( SWT.FILL, SWT.CENTER, true, false );
        gd.widthHint = 100;
        this.combo.setLayoutData ( gd );

        final Button store = new Button ( wrapper, SWT.PUSH );
        store.setText ( "Store" );
        store.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                addScript ();
            }
        } );
        this.load = new Button ( wrapper, SWT.PUSH );
        this.load.setText ( "Load" );
        this.delete = new Button ( wrapper, SWT.PUSH );
        this.delete.setText ( "Delete" );
        this.delete.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                deleteScript ();
            };
        } );

        this.text = new Text ( wrapper, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true, buttons + 1, 1 ) );
        dbc.bindValue ( SWTObservables.observeText ( this.text, SWT.Modify ), this.scriptValue, new UpdateValueStrategy ().setAfterConvertValidator ( new IValidator () {

            @Override
            public IStatus validate ( final Object value )
            {
                return validateScript ( value );
            }
        } ), null );

        fillScripts ();
        setControl ( wrapper );

        this.load.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                ScriptPage.this.text.setText ( ScriptPage.this.combo.getText () );
            }
        } );

        this.combo.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                update ();
            };
        } );
    }

    protected void deleteScript ()
    {
        this.combo.remove ( this.combo.getSelectionIndex () );
        this.combo.setText ( "" );
        getDialogSettings ().put ( "scripts", this.combo.getItems () );
        update ();
    }

    private void update ()
    {
        this.delete.setEnabled ( this.combo.getSelectionIndex () >= 0 );
        this.load.setEnabled ( this.combo.getSelectionIndex () >= 0 );
    }

    private void fillScripts ()
    {
        final String[] scripts = getDialogSettings ().getArray ( "scripts" );
        if ( scripts == null || scripts.length <= 0 )
        {
            return;
        }

        this.combo.setItems ( scripts );
        update ();
    }

    public void addScript ()
    {
        this.combo.add ( this.text.getText () );
        this.combo.select ( this.combo.getItemCount () - 1 );
        getDialogSettings ().put ( "scripts", this.combo.getItems () );
    }

    protected IStatus validateScript ( final Object value )
    {
        this.script = null;

        try
        {
            this.script = makeScript ( value );
        }
        catch ( final Exception e )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, ExceptionHelper.getMessage ( e ) );
        }

        return new Status ( IStatus.INFO, Activator.PLUGIN_ID, "Enter a Java script fragment which returns the new name of each item" );
    }

    public CompiledScript getScript ()
    {
        return this.script;
    }

    private CompiledScript makeScript ( final Object value ) throws Exception
    {
        if ( value == null )
        {
            return null;
        }

        if ( this.engine == null )
        {
            this.engine = (Compilable)Scripts.createEngine ( "JavaScript", Activator.class.getClassLoader () ); //$NON-NLS-1$
        }

        return this.engine.compile ( (String)value );
    }

}
