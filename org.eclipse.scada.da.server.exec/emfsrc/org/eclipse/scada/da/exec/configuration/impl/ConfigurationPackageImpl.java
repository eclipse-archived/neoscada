/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.common.CommonPackage;
import org.eclipse.scada.da.exec.configuration.CommandType;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.ContinuousCommandType;
import org.eclipse.scada.da.exec.configuration.CustomExtractorType;
import org.eclipse.scada.da.exec.configuration.DocumentRoot;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.ExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldType;
import org.eclipse.scada.da.exec.configuration.HiveProcessCommandType;
import org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType;
import org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType;
import org.eclipse.scada.da.exec.configuration.ProcessType;
import org.eclipse.scada.da.exec.configuration.QueueType;
import org.eclipse.scada.da.exec.configuration.RegExExtractorType;
import org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType;
import org.eclipse.scada.da.exec.configuration.RootType;
import org.eclipse.scada.da.exec.configuration.SimpleExtractorType;
import org.eclipse.scada.da.exec.configuration.SingleCommandType;
import org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType;
import org.eclipse.scada.da.exec.configuration.SplitterExtractorType;
import org.eclipse.scada.da.exec.configuration.SplitterType;
import org.eclipse.scada.da.exec.configuration.TriggerCommandType;
import org.eclipse.scada.da.exec.configuration.VariantTypeType;
import org.eclipse.scada.da.exec.configuration.util.ConfigurationValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationPackageImpl extends EPackageImpl implements ConfigurationPackage
{
    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass commandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass continuousCommandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass envEntryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass extractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fieldExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fieldTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hiveProcessCommandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nagiosReturnCodeExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass plainStreamExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass processTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass queueTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass regExExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass returnCodeExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rootTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singleCommandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass splitContinuousCommandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass splitterExtractorTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass splitterTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerCommandTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum variantTypeTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType classTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType nameTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType nameType1EDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType periodTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType periodTypeObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType restartDelayTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType restartDelayTypeObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType typeTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType variantTypeTypeObjectEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ConfigurationPackageImpl ()
    {
        super ( eNS_URI, ConfigurationFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ConfigurationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ConfigurationPackage init ()
    {
        if ( isInited )
            return (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage ( ConfigurationPackage.eNS_URI );

        // Obtain or create and register package
        ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ConfigurationPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        CommonPackage.eINSTANCE.eClass ();
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theConfigurationPackage.createPackageContents ();

        // Initialize created meta-data
        theConfigurationPackage.initializePackageContents ();

        // Register package validator
        EValidator.Registry.INSTANCE.put ( theConfigurationPackage, new EValidator.Descriptor () {
            public EValidator getEValidator ()
            {
                return ConfigurationValidator.INSTANCE;
            }
        } );

        // Mark meta-data to indicate it can't be changed
        theConfigurationPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ConfigurationPackage.eNS_URI, theConfigurationPackage );
        return theConfigurationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCommandType ()
    {
        return commandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCommandType_Process ()
    {
        return (EReference)commandTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCommandType_Extractor ()
    {
        return (EReference)commandTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCommandType_Id ()
    {
        return (EAttribute)commandTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContinuousCommandType ()
    {
        return continuousCommandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getContinuousCommandType_MaxInputBuffer ()
    {
        return (EAttribute)continuousCommandTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getContinuousCommandType_RestartDelay ()
    {
        return (EAttribute)continuousCommandTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomExtractorType ()
    {
        return customExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCustomExtractorType_Any ()
    {
        return (EAttribute)customExtractorTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCustomExtractorType_Class ()
    {
        return (EAttribute)customExtractorTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentRoot ()
    {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed ()
    {
        return (EAttribute)documentRootEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Root ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEnvEntryType ()
    {
        return envEntryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEnvEntryType_Name ()
    {
        return (EAttribute)envEntryTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEnvEntryType_Value ()
    {
        return (EAttribute)envEntryTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExtractorType ()
    {
        return extractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExtractorType_Name ()
    {
        return (EAttribute)extractorTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFieldExtractorType ()
    {
        return fieldExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFieldExtractorType_Field ()
    {
        return (EReference)fieldExtractorTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFieldType ()
    {
        return fieldTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFieldType_Name ()
    {
        return (EAttribute)fieldTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFieldType_VariantType ()
    {
        return (EAttribute)fieldTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHiveProcessCommandType ()
    {
        return hiveProcessCommandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNagiosReturnCodeExtractorType ()
    {
        return nagiosReturnCodeExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPlainStreamExtractorType ()
    {
        return plainStreamExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProcessType ()
    {
        return processTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProcessType_Argument ()
    {
        return (EAttribute)processTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProcessType_Env ()
    {
        return (EReference)processTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProcessType_Exec ()
    {
        return (EAttribute)processTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQueueType ()
    {
        return queueTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getQueueType_Command ()
    {
        return (EReference)queueTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueueType_Name ()
    {
        return (EAttribute)queueTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegExExtractorType ()
    {
        return regExExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegExExtractorType_Expression ()
    {
        return (EAttribute)regExExtractorTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegExExtractorType_RequireFullMatch ()
    {
        return (EAttribute)regExExtractorTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReturnCodeExtractorType ()
    {
        return returnCodeExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRootType ()
    {
        return rootTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRootType_Group ()
    {
        return (EAttribute)rootTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_Queue ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_Command ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_HiveProcess ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_Trigger ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRootType_AdditionalConfigurationDirectory ()
    {
        return (EAttribute)rootTypeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleExtractorType ()
    {
        return simpleExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSingleCommandType ()
    {
        return singleCommandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSingleCommandType_Period ()
    {
        return (EAttribute)singleCommandTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSplitContinuousCommandType ()
    {
        return splitContinuousCommandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSplitContinuousCommandType_Splitter ()
    {
        return (EReference)splitContinuousCommandTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitContinuousCommandType_IgnoreStartLines ()
    {
        return (EAttribute)splitContinuousCommandTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSplitterExtractorType ()
    {
        return splitterExtractorTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitterExtractorType_SplitExpression ()
    {
        return (EAttribute)splitterExtractorTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSplitterType ()
    {
        return splitterTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitterType_Parameter ()
    {
        return (EAttribute)splitterTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitterType_Type ()
    {
        return (EAttribute)splitterTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTriggerCommandType ()
    {
        return triggerCommandTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTriggerCommandType_ArgumentPlaceholder ()
    {
        return (EAttribute)triggerCommandTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTriggerCommandType_Fork ()
    {
        return (EAttribute)triggerCommandTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTriggerCommandType_SkipIfNull ()
    {
        return (EAttribute)triggerCommandTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getVariantTypeType ()
    {
        return variantTypeTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getClassType ()
    {
        return classTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getNameType ()
    {
        return nameTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getNameType1 ()
    {
        return nameType1EDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPeriodType ()
    {
        return periodTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPeriodTypeObject ()
    {
        return periodTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRestartDelayType ()
    {
        return restartDelayTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRestartDelayTypeObject ()
    {
        return restartDelayTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getTypeType ()
    {
        return typeTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getVariantTypeTypeObject ()
    {
        return variantTypeTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationFactory getConfigurationFactory ()
    {
        return (ConfigurationFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        commandTypeEClass = createEClass ( COMMAND_TYPE );
        createEReference ( commandTypeEClass, COMMAND_TYPE__PROCESS );
        createEReference ( commandTypeEClass, COMMAND_TYPE__EXTRACTOR );
        createEAttribute ( commandTypeEClass, COMMAND_TYPE__ID );

        continuousCommandTypeEClass = createEClass ( CONTINUOUS_COMMAND_TYPE );
        createEAttribute ( continuousCommandTypeEClass, CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER );
        createEAttribute ( continuousCommandTypeEClass, CONTINUOUS_COMMAND_TYPE__RESTART_DELAY );

        customExtractorTypeEClass = createEClass ( CUSTOM_EXTRACTOR_TYPE );
        createEAttribute ( customExtractorTypeEClass, CUSTOM_EXTRACTOR_TYPE__ANY );
        createEAttribute ( customExtractorTypeEClass, CUSTOM_EXTRACTOR_TYPE__CLASS );

        documentRootEClass = createEClass ( DOCUMENT_ROOT );
        createEAttribute ( documentRootEClass, DOCUMENT_ROOT__MIXED );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__ROOT );

        envEntryTypeEClass = createEClass ( ENV_ENTRY_TYPE );
        createEAttribute ( envEntryTypeEClass, ENV_ENTRY_TYPE__NAME );
        createEAttribute ( envEntryTypeEClass, ENV_ENTRY_TYPE__VALUE );

        extractorTypeEClass = createEClass ( EXTRACTOR_TYPE );
        createEAttribute ( extractorTypeEClass, EXTRACTOR_TYPE__NAME );

        fieldExtractorTypeEClass = createEClass ( FIELD_EXTRACTOR_TYPE );
        createEReference ( fieldExtractorTypeEClass, FIELD_EXTRACTOR_TYPE__FIELD );

        fieldTypeEClass = createEClass ( FIELD_TYPE );
        createEAttribute ( fieldTypeEClass, FIELD_TYPE__NAME );
        createEAttribute ( fieldTypeEClass, FIELD_TYPE__VARIANT_TYPE );

        hiveProcessCommandTypeEClass = createEClass ( HIVE_PROCESS_COMMAND_TYPE );

        nagiosReturnCodeExtractorTypeEClass = createEClass ( NAGIOS_RETURN_CODE_EXTRACTOR_TYPE );

        plainStreamExtractorTypeEClass = createEClass ( PLAIN_STREAM_EXTRACTOR_TYPE );

        processTypeEClass = createEClass ( PROCESS_TYPE );
        createEAttribute ( processTypeEClass, PROCESS_TYPE__ARGUMENT );
        createEReference ( processTypeEClass, PROCESS_TYPE__ENV );
        createEAttribute ( processTypeEClass, PROCESS_TYPE__EXEC );

        queueTypeEClass = createEClass ( QUEUE_TYPE );
        createEReference ( queueTypeEClass, QUEUE_TYPE__COMMAND );
        createEAttribute ( queueTypeEClass, QUEUE_TYPE__NAME );

        regExExtractorTypeEClass = createEClass ( REG_EX_EXTRACTOR_TYPE );
        createEAttribute ( regExExtractorTypeEClass, REG_EX_EXTRACTOR_TYPE__EXPRESSION );
        createEAttribute ( regExExtractorTypeEClass, REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH );

        returnCodeExtractorTypeEClass = createEClass ( RETURN_CODE_EXTRACTOR_TYPE );

        rootTypeEClass = createEClass ( ROOT_TYPE );
        createEAttribute ( rootTypeEClass, ROOT_TYPE__GROUP );
        createEReference ( rootTypeEClass, ROOT_TYPE__QUEUE );
        createEReference ( rootTypeEClass, ROOT_TYPE__COMMAND );
        createEReference ( rootTypeEClass, ROOT_TYPE__HIVE_PROCESS );
        createEReference ( rootTypeEClass, ROOT_TYPE__TRIGGER );
        createEAttribute ( rootTypeEClass, ROOT_TYPE__ADDITIONAL_CONFIGURATION_DIRECTORY );

        simpleExtractorTypeEClass = createEClass ( SIMPLE_EXTRACTOR_TYPE );

        singleCommandTypeEClass = createEClass ( SINGLE_COMMAND_TYPE );
        createEAttribute ( singleCommandTypeEClass, SINGLE_COMMAND_TYPE__PERIOD );

        splitContinuousCommandTypeEClass = createEClass ( SPLIT_CONTINUOUS_COMMAND_TYPE );
        createEReference ( splitContinuousCommandTypeEClass, SPLIT_CONTINUOUS_COMMAND_TYPE__SPLITTER );
        createEAttribute ( splitContinuousCommandTypeEClass, SPLIT_CONTINUOUS_COMMAND_TYPE__IGNORE_START_LINES );

        splitterExtractorTypeEClass = createEClass ( SPLITTER_EXTRACTOR_TYPE );
        createEAttribute ( splitterExtractorTypeEClass, SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION );

        splitterTypeEClass = createEClass ( SPLITTER_TYPE );
        createEAttribute ( splitterTypeEClass, SPLITTER_TYPE__PARAMETER );
        createEAttribute ( splitterTypeEClass, SPLITTER_TYPE__TYPE );

        triggerCommandTypeEClass = createEClass ( TRIGGER_COMMAND_TYPE );
        createEAttribute ( triggerCommandTypeEClass, TRIGGER_COMMAND_TYPE__ARGUMENT_PLACEHOLDER );
        createEAttribute ( triggerCommandTypeEClass, TRIGGER_COMMAND_TYPE__FORK );
        createEAttribute ( triggerCommandTypeEClass, TRIGGER_COMMAND_TYPE__SKIP_IF_NULL );

        // Create enums
        variantTypeTypeEEnum = createEEnum ( VARIANT_TYPE_TYPE );

        // Create data types
        classTypeEDataType = createEDataType ( CLASS_TYPE );
        nameTypeEDataType = createEDataType ( NAME_TYPE );
        nameType1EDataType = createEDataType ( NAME_TYPE1 );
        periodTypeEDataType = createEDataType ( PERIOD_TYPE );
        periodTypeObjectEDataType = createEDataType ( PERIOD_TYPE_OBJECT );
        restartDelayTypeEDataType = createEDataType ( RESTART_DELAY_TYPE );
        restartDelayTypeObjectEDataType = createEDataType ( RESTART_DELAY_TYPE_OBJECT );
        typeTypeEDataType = createEDataType ( TYPE_TYPE );
        variantTypeTypeObjectEDataType = createEDataType ( VARIANT_TYPE_TYPE_OBJECT );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        continuousCommandTypeEClass.getESuperTypes ().add ( this.getCommandType () );
        customExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        fieldExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        hiveProcessCommandTypeEClass.getESuperTypes ().add ( this.getContinuousCommandType () );
        nagiosReturnCodeExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        plainStreamExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        regExExtractorTypeEClass.getESuperTypes ().add ( this.getFieldExtractorType () );
        returnCodeExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        simpleExtractorTypeEClass.getESuperTypes ().add ( this.getExtractorType () );
        singleCommandTypeEClass.getESuperTypes ().add ( this.getCommandType () );
        splitContinuousCommandTypeEClass.getESuperTypes ().add ( this.getContinuousCommandType () );
        splitterExtractorTypeEClass.getESuperTypes ().add ( this.getFieldExtractorType () );
        triggerCommandTypeEClass.getESuperTypes ().add ( this.getCommandType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( commandTypeEClass, CommandType.class, "CommandType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommandType_Process (), this.getProcessType (), null, "process", null, 1, 1, CommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCommandType_Extractor (), this.getExtractorType (), null, "extractor", null, 0, -1, CommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCommandType_Id (), theXMLTypePackage.getID (), "id", null, 1, 1, CommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( continuousCommandTypeEClass, ContinuousCommandType.class, "ContinuousCommandType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getContinuousCommandType_MaxInputBuffer (), theXMLTypePackage.getInt (), "maxInputBuffer", "4000", 0, 1, ContinuousCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getContinuousCommandType_RestartDelay (), this.getRestartDelayType (), "restartDelay", null, 1, 1, ContinuousCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( customExtractorTypeEClass, CustomExtractorType.class, "CustomExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCustomExtractorType_Any (), ecorePackage.getEFeatureMapEntry (), "any", null, 0, 1, CustomExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCustomExtractorType_Class (), this.getClassType (), "class", null, 0, 1, CustomExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDocumentRoot_Mixed (), ecorePackage.getEFeatureMapEntry (), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XMLNSPrefixMap (), ecorePackage.getEStringToStringMapEntry (), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XSISchemaLocation (), ecorePackage.getEStringToStringMapEntry (), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_Root (), this.getRootType (), null, "root", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( envEntryTypeEClass, EnvEntryType.class, "EnvEntryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEnvEntryType_Name (), theXMLTypePackage.getString (), "name", null, 1, 1, EnvEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEnvEntryType_Value (), theXMLTypePackage.getString (), "value", null, 0, 1, EnvEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( extractorTypeEClass, ExtractorType.class, "ExtractorType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExtractorType_Name (), theXMLTypePackage.getString (), "name", null, 1, 1, ExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fieldExtractorTypeEClass, FieldExtractorType.class, "FieldExtractorType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFieldExtractorType_Field (), this.getFieldType (), null, "field", null, 0, -1, FieldExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fieldTypeEClass, FieldType.class, "FieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFieldType_Name (), this.getNameType (), "name", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFieldType_VariantType (), this.getVariantTypeType (), "variantType", "STRING", 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( hiveProcessCommandTypeEClass, HiveProcessCommandType.class, "HiveProcessCommandType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( nagiosReturnCodeExtractorTypeEClass, NagiosReturnCodeExtractorType.class, "NagiosReturnCodeExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( plainStreamExtractorTypeEClass, PlainStreamExtractorType.class, "PlainStreamExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( processTypeEClass, ProcessType.class, "ProcessType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getProcessType_Argument (), theXMLTypePackage.getString (), "argument", null, 0, -1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProcessType_Env (), this.getEnvEntryType (), null, "env", null, 0, -1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProcessType_Exec (), theXMLTypePackage.getString (), "exec", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( queueTypeEClass, QueueType.class, "QueueType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getQueueType_Command (), this.getSingleCommandType (), null, "command", null, 0, -1, QueueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getQueueType_Name (), this.getNameType1 (), "name", null, 0, 1, QueueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( regExExtractorTypeEClass, RegExExtractorType.class, "RegExExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRegExExtractorType_Expression (), theXMLTypePackage.getString (), "expression", null, 1, 1, RegExExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRegExExtractorType_RequireFullMatch (), theXMLTypePackage.getBoolean (), "requireFullMatch", null, 1, 1, RegExExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( returnCodeExtractorTypeEClass, ReturnCodeExtractorType.class, "ReturnCodeExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( rootTypeEClass, RootType.class, "RootType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRootType_Group (), ecorePackage.getEFeatureMapEntry (), "group", null, 0, -1, RootType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRootType_Queue (), this.getQueueType (), null, "queue", null, 0, -1, RootType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRootType_Command (), this.getSplitContinuousCommandType (), null, "command", null, 0, -1, RootType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRootType_HiveProcess (), this.getHiveProcessCommandType (), null, "hiveProcess", null, 0, -1, RootType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRootType_Trigger (), this.getTriggerCommandType (), null, "trigger", null, 0, -1, RootType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRootType_AdditionalConfigurationDirectory (), theXMLTypePackage.getString (), "additionalConfigurationDirectory", null, 0, -1, RootType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( simpleExtractorTypeEClass, SimpleExtractorType.class, "SimpleExtractorType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( singleCommandTypeEClass, SingleCommandType.class, "SingleCommandType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSingleCommandType_Period (), this.getPeriodType (), "period", null, 0, 1, SingleCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( splitContinuousCommandTypeEClass, SplitContinuousCommandType.class, "SplitContinuousCommandType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSplitContinuousCommandType_Splitter (), this.getSplitterType (), null, "splitter", null, 1, 1, SplitContinuousCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSplitContinuousCommandType_IgnoreStartLines (), theXMLTypePackage.getInt (), "ignoreStartLines", "0", 0, 1, SplitContinuousCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( splitterExtractorTypeEClass, SplitterExtractorType.class, "SplitterExtractorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSplitterExtractorType_SplitExpression (), theXMLTypePackage.getString (), "splitExpression", null, 1, 1, SplitterExtractorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( splitterTypeEClass, SplitterType.class, "SplitterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSplitterType_Parameter (), theXMLTypePackage.getString (), "parameter", null, 0, 1, SplitterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSplitterType_Type (), this.getTypeType (), "type", null, 1, 1, SplitterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( triggerCommandTypeEClass, TriggerCommandType.class, "TriggerCommandType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTriggerCommandType_ArgumentPlaceholder (), theXMLTypePackage.getString (), "argumentPlaceholder", null, 0, 1, TriggerCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTriggerCommandType_Fork (), theXMLTypePackage.getBoolean (), "fork", "true", 0, 1, TriggerCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getTriggerCommandType_SkipIfNull (), theXMLTypePackage.getBoolean (), "skipIfNull", null, 0, 1, TriggerCommandType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( variantTypeTypeEEnum, VariantTypeType.class, "VariantTypeType" ); //$NON-NLS-1$
        addEEnumLiteral ( variantTypeTypeEEnum, VariantTypeType.BOOLEAN );
        addEEnumLiteral ( variantTypeTypeEEnum, VariantTypeType.INTEGER );
        addEEnumLiteral ( variantTypeTypeEEnum, VariantTypeType.LONG );
        addEEnumLiteral ( variantTypeTypeEEnum, VariantTypeType.DOUBLE );
        addEEnumLiteral ( variantTypeTypeEEnum, VariantTypeType.STRING );

        // Initialize data types
        initEDataType ( classTypeEDataType, String.class, "ClassType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( nameTypeEDataType, String.class, "NameType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( nameType1EDataType, String.class, "NameType1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( periodTypeEDataType, int.class, "PeriodType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( periodTypeObjectEDataType, Integer.class, "PeriodTypeObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( restartDelayTypeEDataType, int.class, "RestartDelayType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( restartDelayTypeObjectEDataType, Integer.class, "RestartDelayTypeObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( typeTypeEDataType, String.class, "TypeType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( variantTypeTypeObjectEDataType, VariantTypeType.class, "VariantTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation ( classTypeEDataType, source, new String[] { "name", "class_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
        "pattern", "\\w+(\\.\\w+)*" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( commandTypeEClass, source, new String[] { "name", "CommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandType_Process (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "process", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandType_Extractor (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "extractor", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandType_Id (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( continuousCommandTypeEClass, source, new String[] { "name", "ContinuousCommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getContinuousCommandType_MaxInputBuffer (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "maxInputBuffer" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getContinuousCommandType_RestartDelay (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "restartDelay" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( customExtractorTypeEClass, source, new String[] { "name", "CustomExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCustomExtractorType_Any (), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
        "wildcards", "##any", //$NON-NLS-1$ //$NON-NLS-2$
        "name", ":1", //$NON-NLS-1$ //$NON-NLS-2$
        "processing", "lax" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCustomExtractorType_Class (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "class" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( documentRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Mixed (), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
        "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XMLNSPrefixMap (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XSISchemaLocation (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Root (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "root", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( envEntryTypeEClass, source, new String[] { "name", "EnvEntryType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getEnvEntryType_Name (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getEnvEntryType_Value (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "value" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( extractorTypeEClass, source, new String[] { "name", "ExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getExtractorType_Name (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( fieldExtractorTypeEClass, source, new String[] { "name", "FieldExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getFieldExtractorType_Field (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "field", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( fieldTypeEClass, source, new String[] { "name", "FieldType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getFieldType_Name (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getFieldType_VariantType (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "variantType" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( hiveProcessCommandTypeEClass, source, new String[] { "name", "HiveProcessCommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( nagiosReturnCodeExtractorTypeEClass, source, new String[] { "name", "NagiosReturnCodeExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( nameTypeEDataType, source, new String[] { "name", "name_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
        "whiteSpace", "collapse" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( nameType1EDataType, source, new String[] { "name", "name_._1_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
        "whiteSpace", "collapse", //$NON-NLS-1$ //$NON-NLS-2$
        "pattern", "\\w+" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( periodTypeEDataType, source, new String[] { "name", "period_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#int", //$NON-NLS-1$ //$NON-NLS-2$
        "minExclusive", "0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( periodTypeObjectEDataType, source, new String[] { "name", "period_._type:Object", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "period_._type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( plainStreamExtractorTypeEClass, source, new String[] { "name", "PlainStreamExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( processTypeEClass, source, new String[] { "name", "ProcessType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProcessType_Argument (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "argument", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProcessType_Env (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "env", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProcessType_Exec (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "exec" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( queueTypeEClass, source, new String[] { "name", "QueueType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getQueueType_Command (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "command", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getQueueType_Name (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( regExExtractorTypeEClass, source, new String[] { "name", "RegExExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRegExExtractorType_Expression (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "expression", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRegExExtractorType_RequireFullMatch (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "requireFullMatch" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( restartDelayTypeEDataType, source, new String[] { "name", "restartDelay_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#int" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( restartDelayTypeObjectEDataType, source, new String[] { "name", "restartDelay_._type:Object", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "restartDelay_._type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( returnCodeExtractorTypeEClass, source, new String[] { "name", "ReturnCodeExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( rootTypeEClass, source, new String[] { "name", "RootType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Group (), source, new String[] { "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Queue (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "queue", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Command (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "command", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_HiveProcess (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "hiveProcess", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Trigger (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "trigger", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_AdditionalConfigurationDirectory (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "additionalConfigurationDirectory", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( simpleExtractorTypeEClass, source, new String[] { "name", "SimpleExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( singleCommandTypeEClass, source, new String[] { "name", "SingleCommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSingleCommandType_Period (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "period" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( splitContinuousCommandTypeEClass, source, new String[] { "name", "SplitContinuousCommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSplitContinuousCommandType_Splitter (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "splitter", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSplitContinuousCommandType_IgnoreStartLines (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "ignoreStartLines" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( splitterExtractorTypeEClass, source, new String[] { "name", "SplitterExtractorType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSplitterExtractorType_SplitExpression (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "splitExpression" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( splitterTypeEClass, source, new String[] { "name", "SplitterType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSplitterType_Parameter (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "parameter" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSplitterType_Type (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( triggerCommandTypeEClass, source, new String[] { "name", "TriggerCommandType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTriggerCommandType_ArgumentPlaceholder (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "argumentPlaceholder" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTriggerCommandType_Fork (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "fork" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTriggerCommandType_SkipIfNull (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "skipIfNull" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( typeTypeEDataType, source, new String[] { "name", "type_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
        "pattern", "(newline|regexpMatch|regexpSplit|split|class#.*)" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( variantTypeTypeEEnum, source, new String[] { "name", "variantType_._type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( variantTypeTypeObjectEDataType, source, new String[] { "name", "variantType_._type:Object", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "variantType_._type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //ConfigurationPackageImpl
