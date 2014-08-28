package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.ide.validation.AbstractTargetValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class HttpServiceValidator<T extends EObject> extends AbstractTargetValidator<T>
{
    private final EStructuralFeature feature;

    public HttpServiceValidator ( final Class<T> clazz, final EStructuralFeature feature )
    {
        super ( clazz );
        this.feature = feature;
    }

    @Override
    protected void performValidation ( final EObject target, final ValidationContext ctx )
    {
        final Object service = target.eGet ( this.feature );
        if ( service == null )
        {
            return;
        }

        if ( ! ( service instanceof HttpServiceModule ) )
        {
            throw new IllegalStateException ( String.format ( "Validator can only handle %s", HttpServiceModule.class.getName () ) );
        }

        if ( HttpServices.isValid ( target, (HttpServiceModule)service ) )
        {
            ctx.add ( this.feature, "Selected HTTP Service is not present in the target application setup. The selected service must be either a module in the same application or in the selected configuration of the application." );
        }
    }

}
