/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.script;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.script.ScriptFactory
 * @model kind="package"
 * @generated
 */
public interface ScriptPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "script"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Script"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "script"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ScriptPackage eINSTANCE = org.eclipse.scada.configuration.script.impl.ScriptPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.script.Script <em>Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.script.Script
     * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getScript()
     * @generated
     */
    int SCRIPT = 0;

    /**
     * The number of structural features of the '<em>Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Get Language</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT___GET_LANGUAGE = 0;

    /**
     * The operation id for the '<em>Get Source</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT___GET_SOURCE = 1;

    /**
     * The number of operations of the '<em>Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_OPERATION_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.script.impl.AbstractScriptImpl <em>Abstract Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.script.impl.AbstractScriptImpl
     * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getAbstractScript()
     * @generated
     */
    int ABSTRACT_SCRIPT = 4;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_SCRIPT__SOURCE = SCRIPT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_SCRIPT_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Language</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_SCRIPT___GET_LANGUAGE = SCRIPT___GET_LANGUAGE;

    /**
     * The operation id for the '<em>Get Source</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_SCRIPT___GET_SOURCE = SCRIPT___GET_SOURCE;

    /**
     * The number of operations of the '<em>Abstract Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_SCRIPT_OPERATION_COUNT = SCRIPT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.script.impl.GenericScriptImpl <em>Generic Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.script.impl.GenericScriptImpl
     * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getGenericScript()
     * @generated
     */
    int GENERIC_SCRIPT = 1;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT__SOURCE = ABSTRACT_SCRIPT__SOURCE;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT__LANGUAGE = ABSTRACT_SCRIPT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT_FEATURE_COUNT = ABSTRACT_SCRIPT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Language</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT___GET_LANGUAGE = ABSTRACT_SCRIPT___GET_LANGUAGE;

    /**
     * The operation id for the '<em>Get Source</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT___GET_SOURCE = ABSTRACT_SCRIPT___GET_SOURCE;

    /**
     * The number of operations of the '<em>Generic Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT_OPERATION_COUNT = ABSTRACT_SCRIPT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.script.impl.JavaScriptImpl <em>Java Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.script.impl.JavaScriptImpl
     * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getJavaScript()
     * @generated
     */
    int JAVA_SCRIPT = 2;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT__SOURCE = ABSTRACT_SCRIPT__SOURCE;

    /**
     * The number of structural features of the '<em>Java Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_FEATURE_COUNT = ABSTRACT_SCRIPT_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Language</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT___GET_LANGUAGE = ABSTRACT_SCRIPT___GET_LANGUAGE;

    /**
     * The operation id for the '<em>Get Source</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT___GET_SOURCE = ABSTRACT_SCRIPT___GET_SOURCE;

    /**
     * The number of operations of the '<em>Java Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_OPERATION_COUNT = ABSTRACT_SCRIPT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.script.impl.ScriptReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.script.impl.ScriptReferenceImpl
     * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getScriptReference()
     * @generated
     */
    int SCRIPT_REFERENCE = 3;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_REFERENCE__REFERENCE = SCRIPT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_REFERENCE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Language</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_REFERENCE___GET_LANGUAGE = SCRIPT___GET_LANGUAGE;

    /**
     * The operation id for the '<em>Get Source</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_REFERENCE___GET_SOURCE = SCRIPT___GET_SOURCE;

    /**
     * The number of operations of the '<em>Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_REFERENCE_OPERATION_COUNT = SCRIPT_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.script.Script <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script</em>'.
     * @see org.eclipse.scada.configuration.script.Script
     * @generated
     */
    EClass getScript ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.script.Script#getLanguage() <em>Get Language</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Language</em>' operation.
     * @see org.eclipse.scada.configuration.script.Script#getLanguage()
     * @generated
     */
    EOperation getScript__GetLanguage ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.script.Script#getSource() <em>Get Source</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Source</em>' operation.
     * @see org.eclipse.scada.configuration.script.Script#getSource()
     * @generated
     */
    EOperation getScript__GetSource ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.script.GenericScript <em>Generic Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Script</em>'.
     * @see org.eclipse.scada.configuration.script.GenericScript
     * @generated
     */
    EClass getGenericScript ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.script.GenericScript#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.eclipse.scada.configuration.script.GenericScript#getLanguage()
     * @see #getGenericScript()
     * @generated
     */
    EAttribute getGenericScript_Language ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.script.JavaScript <em>Java Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Script</em>'.
     * @see org.eclipse.scada.configuration.script.JavaScript
     * @generated
     */
    EClass getJavaScript ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.script.ScriptReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference</em>'.
     * @see org.eclipse.scada.configuration.script.ScriptReference
     * @generated
     */
    EClass getScriptReference ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.script.ScriptReference#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see org.eclipse.scada.configuration.script.ScriptReference#getReference()
     * @see #getScriptReference()
     * @generated
     */
    EReference getScriptReference_Reference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.script.AbstractScript <em>Abstract Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Script</em>'.
     * @see org.eclipse.scada.configuration.script.AbstractScript
     * @generated
     */
    EClass getAbstractScript ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.script.AbstractScript#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.script.AbstractScript#getSource()
     * @see #getAbstractScript()
     * @generated
     */
    EAttribute getAbstractScript_Source ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ScriptFactory getScriptFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.script.Script <em>Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.script.Script
         * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getScript()
         * @generated
         */
        EClass SCRIPT = eINSTANCE.getScript ();

        /**
         * The meta object literal for the '<em><b>Get Language</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT___GET_LANGUAGE = eINSTANCE.getScript__GetLanguage ();

        /**
         * The meta object literal for the '<em><b>Get Source</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT___GET_SOURCE = eINSTANCE.getScript__GetSource ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.script.impl.GenericScriptImpl <em>Generic Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.script.impl.GenericScriptImpl
         * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getGenericScript()
         * @generated
         */
        EClass GENERIC_SCRIPT = eINSTANCE.getGenericScript ();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_SCRIPT__LANGUAGE = eINSTANCE.getGenericScript_Language ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.script.impl.JavaScriptImpl <em>Java Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.script.impl.JavaScriptImpl
         * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getJavaScript()
         * @generated
         */
        EClass JAVA_SCRIPT = eINSTANCE.getJavaScript ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.script.impl.ScriptReferenceImpl <em>Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.script.impl.ScriptReferenceImpl
         * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getScriptReference()
         * @generated
         */
        EClass SCRIPT_REFERENCE = eINSTANCE.getScriptReference ();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_REFERENCE__REFERENCE = eINSTANCE.getScriptReference_Reference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.script.impl.AbstractScriptImpl <em>Abstract Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.script.impl.AbstractScriptImpl
         * @see org.eclipse.scada.configuration.script.impl.ScriptPackageImpl#getAbstractScript()
         * @generated
         */
        EClass ABSTRACT_SCRIPT = eINSTANCE.getAbstractScript ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_SCRIPT__SOURCE = eINSTANCE.getAbstractScript_Source ();

    }

} //ScriptPackage
