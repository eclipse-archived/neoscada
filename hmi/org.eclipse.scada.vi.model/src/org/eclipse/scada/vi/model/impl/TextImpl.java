/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.vi.model.Alignment;
import org.eclipse.scada.vi.model.Orientation;
import org.eclipse.scada.vi.model.Text;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getLabelAlignment <em>Label Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getIconAlignment <em>Icon Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getTextAlignment <em>Text Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getTextPlacement <em>Text Placement</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getFontName <em>Font Name</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#isFontBold <em>Font Bold</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#isFontItalic <em>Font Italic</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TextImpl#getAlpha <em>Alpha</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextImpl extends FigureImpl implements Text
{
    /**
     * The default value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
    protected static final String TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
    protected String text = TEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getLabelAlignment() <em>Label Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment LABEL_ALIGNMENT_EDEFAULT = Alignment.CENTER;

    /**
     * The cached value of the '{@link #getLabelAlignment() <em>Label Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelAlignment()
     * @generated
     * @ordered
     */
    protected Alignment labelAlignment = LABEL_ALIGNMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getIconAlignment() <em>Icon Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment ICON_ALIGNMENT_EDEFAULT = Alignment.CENTER;

    /**
     * The cached value of the '{@link #getIconAlignment() <em>Icon Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconAlignment()
     * @generated
     * @ordered
     */
    protected Alignment iconAlignment = ICON_ALIGNMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getTextAlignment() <em>Text Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextAlignment()
     * @generated
     * @ordered
     */
    protected static final Alignment TEXT_ALIGNMENT_EDEFAULT = Alignment.CENTER;

    /**
     * The cached value of the '{@link #getTextAlignment() <em>Text Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextAlignment()
     * @generated
     * @ordered
     */
    protected Alignment textAlignment = TEXT_ALIGNMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getTextPlacement() <em>Text Placement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextPlacement()
     * @generated
     * @ordered
     */
    protected static final Orientation TEXT_PLACEMENT_EDEFAULT = Orientation.EAST;

    /**
     * The cached value of the '{@link #getTextPlacement() <em>Text Placement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextPlacement()
     * @generated
     * @ordered
     */
    protected Orientation textPlacement = TEXT_PLACEMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getFontName() <em>Font Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontName()
     * @generated
     * @ordered
     */
    protected static final String FONT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFontName() <em>Font Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontName()
     * @generated
     * @ordered
     */
    protected String fontName = FONT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontSize()
     * @generated
     * @ordered
     */
    protected static final int FONT_SIZE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontSize()
     * @generated
     * @ordered
     */
    protected int fontSize = FONT_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #isFontBold() <em>Font Bold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontBold()
     * @generated
     * @ordered
     */
    protected static final boolean FONT_BOLD_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFontBold() <em>Font Bold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontBold()
     * @generated
     * @ordered
     */
    protected boolean fontBold = FONT_BOLD_EDEFAULT;

    /**
     * The default value of the '{@link #isFontItalic() <em>Font Italic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontItalic()
     * @generated
     * @ordered
     */
    protected static final boolean FONT_ITALIC_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFontItalic() <em>Font Italic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontItalic()
     * @generated
     * @ordered
     */
    protected boolean fontItalic = FONT_ITALIC_EDEFAULT;

    /**
     * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlpha()
     * @generated
     * @ordered
     */
    protected static final Double ALPHA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlpha()
     * @generated
     * @ordered
     */
    protected Double alpha = ALPHA_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return VisualInterfacePackage.Literals.TEXT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getText ()
    {
        return text;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setText ( String newText )
    {
        String oldText = text;
        text = newText;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__TEXT, oldText, text ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getLabelAlignment ()
    {
        return labelAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelAlignment ( Alignment newLabelAlignment )
    {
        Alignment oldLabelAlignment = labelAlignment;
        labelAlignment = newLabelAlignment == null ? LABEL_ALIGNMENT_EDEFAULT : newLabelAlignment;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__LABEL_ALIGNMENT, oldLabelAlignment, labelAlignment ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getIconAlignment ()
    {
        return iconAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIconAlignment ( Alignment newIconAlignment )
    {
        Alignment oldIconAlignment = iconAlignment;
        iconAlignment = newIconAlignment == null ? ICON_ALIGNMENT_EDEFAULT : newIconAlignment;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__ICON_ALIGNMENT, oldIconAlignment, iconAlignment ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment getTextAlignment ()
    {
        return textAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextAlignment ( Alignment newTextAlignment )
    {
        Alignment oldTextAlignment = textAlignment;
        textAlignment = newTextAlignment == null ? TEXT_ALIGNMENT_EDEFAULT : newTextAlignment;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__TEXT_ALIGNMENT, oldTextAlignment, textAlignment ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orientation getTextPlacement ()
    {
        return textPlacement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextPlacement ( Orientation newTextPlacement )
    {
        Orientation oldTextPlacement = textPlacement;
        textPlacement = newTextPlacement == null ? TEXT_PLACEMENT_EDEFAULT : newTextPlacement;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__TEXT_PLACEMENT, oldTextPlacement, textPlacement ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFontName ()
    {
        return fontName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontName ( String newFontName )
    {
        String oldFontName = fontName;
        fontName = newFontName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__FONT_NAME, oldFontName, fontName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getFontSize ()
    {
        return fontSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontSize ( int newFontSize )
    {
        int oldFontSize = fontSize;
        fontSize = newFontSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__FONT_SIZE, oldFontSize, fontSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFontBold ()
    {
        return fontBold;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontBold ( boolean newFontBold )
    {
        boolean oldFontBold = fontBold;
        fontBold = newFontBold;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__FONT_BOLD, oldFontBold, fontBold ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFontItalic ()
    {
        return fontItalic;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontItalic ( boolean newFontItalic )
    {
        boolean oldFontItalic = fontItalic;
        fontItalic = newFontItalic;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__FONT_ITALIC, oldFontItalic, fontItalic ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getAlpha ()
    {
        return alpha;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlpha ( Double newAlpha )
    {
        Double oldAlpha = alpha;
        alpha = newAlpha;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TEXT__ALPHA, oldAlpha, alpha ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.TEXT__TEXT:
                return getText ();
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                return getLabelAlignment ();
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                return getIconAlignment ();
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                return getTextAlignment ();
            case VisualInterfacePackage.TEXT__TEXT_PLACEMENT:
                return getTextPlacement ();
            case VisualInterfacePackage.TEXT__FONT_NAME:
                return getFontName ();
            case VisualInterfacePackage.TEXT__FONT_SIZE:
                return getFontSize ();
            case VisualInterfacePackage.TEXT__FONT_BOLD:
                return isFontBold ();
            case VisualInterfacePackage.TEXT__FONT_ITALIC:
                return isFontItalic ();
            case VisualInterfacePackage.TEXT__ALPHA:
                return getAlpha ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.TEXT__TEXT:
                setText ( (String)newValue );
                return;
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                setLabelAlignment ( (Alignment)newValue );
                return;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                setIconAlignment ( (Alignment)newValue );
                return;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                setTextAlignment ( (Alignment)newValue );
                return;
            case VisualInterfacePackage.TEXT__TEXT_PLACEMENT:
                setTextPlacement ( (Orientation)newValue );
                return;
            case VisualInterfacePackage.TEXT__FONT_NAME:
                setFontName ( (String)newValue );
                return;
            case VisualInterfacePackage.TEXT__FONT_SIZE:
                setFontSize ( (Integer)newValue );
                return;
            case VisualInterfacePackage.TEXT__FONT_BOLD:
                setFontBold ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.TEXT__FONT_ITALIC:
                setFontItalic ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.TEXT__ALPHA:
                setAlpha ( (Double)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.TEXT__TEXT:
                setText ( TEXT_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                setLabelAlignment ( LABEL_ALIGNMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                setIconAlignment ( ICON_ALIGNMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                setTextAlignment ( TEXT_ALIGNMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__TEXT_PLACEMENT:
                setTextPlacement ( TEXT_PLACEMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__FONT_NAME:
                setFontName ( FONT_NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__FONT_SIZE:
                setFontSize ( FONT_SIZE_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__FONT_BOLD:
                setFontBold ( FONT_BOLD_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__FONT_ITALIC:
                setFontItalic ( FONT_ITALIC_EDEFAULT );
                return;
            case VisualInterfacePackage.TEXT__ALPHA:
                setAlpha ( ALPHA_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.TEXT__TEXT:
                return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals ( text );
            case VisualInterfacePackage.TEXT__LABEL_ALIGNMENT:
                return labelAlignment != LABEL_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__ICON_ALIGNMENT:
                return iconAlignment != ICON_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__TEXT_ALIGNMENT:
                return textAlignment != TEXT_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__TEXT_PLACEMENT:
                return textPlacement != TEXT_PLACEMENT_EDEFAULT;
            case VisualInterfacePackage.TEXT__FONT_NAME:
                return FONT_NAME_EDEFAULT == null ? fontName != null : !FONT_NAME_EDEFAULT.equals ( fontName );
            case VisualInterfacePackage.TEXT__FONT_SIZE:
                return fontSize != FONT_SIZE_EDEFAULT;
            case VisualInterfacePackage.TEXT__FONT_BOLD:
                return fontBold != FONT_BOLD_EDEFAULT;
            case VisualInterfacePackage.TEXT__FONT_ITALIC:
                return fontItalic != FONT_ITALIC_EDEFAULT;
            case VisualInterfacePackage.TEXT__ALPHA:
                return ALPHA_EDEFAULT == null ? alpha != null : !ALPHA_EDEFAULT.equals ( alpha );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (text: " ); //$NON-NLS-1$
        result.append ( text );
        result.append ( ", labelAlignment: " ); //$NON-NLS-1$
        result.append ( labelAlignment );
        result.append ( ", iconAlignment: " ); //$NON-NLS-1$
        result.append ( iconAlignment );
        result.append ( ", textAlignment: " ); //$NON-NLS-1$
        result.append ( textAlignment );
        result.append ( ", textPlacement: " ); //$NON-NLS-1$
        result.append ( textPlacement );
        result.append ( ", fontName: " ); //$NON-NLS-1$
        result.append ( fontName );
        result.append ( ", fontSize: " ); //$NON-NLS-1$
        result.append ( fontSize );
        result.append ( ", fontBold: " ); //$NON-NLS-1$
        result.append ( fontBold );
        result.append ( ", fontItalic: " ); //$NON-NLS-1$
        result.append ( fontItalic );
        result.append ( ", alpha: " ); //$NON-NLS-1$
        result.append ( alpha );
        result.append ( ')' );
        return result.toString ();
    }

} //TextImpl
