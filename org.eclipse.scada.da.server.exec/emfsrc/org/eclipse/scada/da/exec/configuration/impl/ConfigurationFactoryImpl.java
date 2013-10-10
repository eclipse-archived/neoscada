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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.da.exec.configuration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory
{
    //$NON-NLS-1$

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ConfigurationFactory init ()
    {
        try
        {
            ConfigurationFactory theConfigurationFactory = (ConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory ( ConfigurationPackage.eNS_URI );
            if ( theConfigurationFactory != null )
            {
                return theConfigurationFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ConfigurationFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE:
                return createContinuousCommandType ();
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE:
                return createCustomExtractorType ();
            case ConfigurationPackage.DOCUMENT_ROOT:
                return createDocumentRoot ();
            case ConfigurationPackage.ENV_ENTRY_TYPE:
                return createEnvEntryType ();
            case ConfigurationPackage.FIELD_TYPE:
                return createFieldType ();
            case ConfigurationPackage.HIVE_PROCESS_COMMAND_TYPE:
                return createHiveProcessCommandType ();
            case ConfigurationPackage.NAGIOS_RETURN_CODE_EXTRACTOR_TYPE:
                return createNagiosReturnCodeExtractorType ();
            case ConfigurationPackage.PLAIN_STREAM_EXTRACTOR_TYPE:
                return createPlainStreamExtractorType ();
            case ConfigurationPackage.PROCESS_TYPE:
                return createProcessType ();
            case ConfigurationPackage.QUEUE_TYPE:
                return createQueueType ();
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE:
                return createRegExExtractorType ();
            case ConfigurationPackage.RETURN_CODE_EXTRACTOR_TYPE:
                return createReturnCodeExtractorType ();
            case ConfigurationPackage.ROOT_TYPE:
                return createRootType ();
            case ConfigurationPackage.SINGLE_COMMAND_TYPE:
                return createSingleCommandType ();
            case ConfigurationPackage.SPLIT_CONTINUOUS_COMMAND_TYPE:
                return createSplitContinuousCommandType ();
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE:
                return createSplitterExtractorType ();
            case ConfigurationPackage.SPLITTER_TYPE:
                return createSplitterType ();
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE:
                return createTriggerCommandType ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ConfigurationPackage.VARIANT_TYPE_TYPE:
                return createVariantTypeTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.CLASS_TYPE:
                return createClassTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.NAME_TYPE:
                return createNameTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.NAME_TYPE1:
                return createNameType1FromString ( eDataType, initialValue );
            case ConfigurationPackage.PERIOD_TYPE:
                return createPeriodTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.PERIOD_TYPE_OBJECT:
                return createPeriodTypeObjectFromString ( eDataType, initialValue );
            case ConfigurationPackage.RESTART_DELAY_TYPE:
                return createRestartDelayTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.RESTART_DELAY_TYPE_OBJECT:
                return createRestartDelayTypeObjectFromString ( eDataType, initialValue );
            case ConfigurationPackage.TYPE_TYPE:
                return createTypeTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.VARIANT_TYPE_TYPE_OBJECT:
                return createVariantTypeTypeObjectFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ConfigurationPackage.VARIANT_TYPE_TYPE:
                return convertVariantTypeTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.CLASS_TYPE:
                return convertClassTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.NAME_TYPE:
                return convertNameTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.NAME_TYPE1:
                return convertNameType1ToString ( eDataType, instanceValue );
            case ConfigurationPackage.PERIOD_TYPE:
                return convertPeriodTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.PERIOD_TYPE_OBJECT:
                return convertPeriodTypeObjectToString ( eDataType, instanceValue );
            case ConfigurationPackage.RESTART_DELAY_TYPE:
                return convertRestartDelayTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.RESTART_DELAY_TYPE_OBJECT:
                return convertRestartDelayTypeObjectToString ( eDataType, instanceValue );
            case ConfigurationPackage.TYPE_TYPE:
                return convertTypeTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.VARIANT_TYPE_TYPE_OBJECT:
                return convertVariantTypeTypeObjectToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContinuousCommandType createContinuousCommandType ()
    {
        ContinuousCommandTypeImpl continuousCommandType = new ContinuousCommandTypeImpl ();
        return continuousCommandType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomExtractorType createCustomExtractorType ()
    {
        CustomExtractorTypeImpl customExtractorType = new CustomExtractorTypeImpl ();
        return customExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentRoot createDocumentRoot ()
    {
        DocumentRootImpl documentRoot = new DocumentRootImpl ();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnvEntryType createEnvEntryType ()
    {
        EnvEntryTypeImpl envEntryType = new EnvEntryTypeImpl ();
        return envEntryType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FieldType createFieldType ()
    {
        FieldTypeImpl fieldType = new FieldTypeImpl ();
        return fieldType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiveProcessCommandType createHiveProcessCommandType ()
    {
        HiveProcessCommandTypeImpl hiveProcessCommandType = new HiveProcessCommandTypeImpl ();
        return hiveProcessCommandType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NagiosReturnCodeExtractorType createNagiosReturnCodeExtractorType ()
    {
        NagiosReturnCodeExtractorTypeImpl nagiosReturnCodeExtractorType = new NagiosReturnCodeExtractorTypeImpl ();
        return nagiosReturnCodeExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlainStreamExtractorType createPlainStreamExtractorType ()
    {
        PlainStreamExtractorTypeImpl plainStreamExtractorType = new PlainStreamExtractorTypeImpl ();
        return plainStreamExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessType createProcessType ()
    {
        ProcessTypeImpl processType = new ProcessTypeImpl ();
        return processType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QueueType createQueueType ()
    {
        QueueTypeImpl queueType = new QueueTypeImpl ();
        return queueType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RegExExtractorType createRegExExtractorType ()
    {
        RegExExtractorTypeImpl regExExtractorType = new RegExExtractorTypeImpl ();
        return regExExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReturnCodeExtractorType createReturnCodeExtractorType ()
    {
        ReturnCodeExtractorTypeImpl returnCodeExtractorType = new ReturnCodeExtractorTypeImpl ();
        return returnCodeExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RootType createRootType ()
    {
        RootTypeImpl rootType = new RootTypeImpl ();
        return rootType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SingleCommandType createSingleCommandType ()
    {
        SingleCommandTypeImpl singleCommandType = new SingleCommandTypeImpl ();
        return singleCommandType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SplitContinuousCommandType createSplitContinuousCommandType ()
    {
        SplitContinuousCommandTypeImpl splitContinuousCommandType = new SplitContinuousCommandTypeImpl ();
        return splitContinuousCommandType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SplitterExtractorType createSplitterExtractorType ()
    {
        SplitterExtractorTypeImpl splitterExtractorType = new SplitterExtractorTypeImpl ();
        return splitterExtractorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SplitterType createSplitterType ()
    {
        SplitterTypeImpl splitterType = new SplitterTypeImpl ();
        return splitterType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerCommandType createTriggerCommandType ()
    {
        TriggerCommandTypeImpl triggerCommandType = new TriggerCommandTypeImpl ();
        return triggerCommandType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantTypeType createVariantTypeTypeFromString ( EDataType eDataType, String initialValue )
    {
        VariantTypeType result = VariantTypeType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertVariantTypeTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createClassTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertClassTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createNameTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertNameTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createNameType1FromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertNameType1ToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createPeriodTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (Integer)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.INT, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPeriodTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.INT, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createPeriodTypeObjectFromString ( EDataType eDataType, String initialValue )
    {
        return createPeriodTypeFromString ( ConfigurationPackage.Literals.PERIOD_TYPE, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPeriodTypeObjectToString ( EDataType eDataType, Object instanceValue )
    {
        return convertPeriodTypeToString ( ConfigurationPackage.Literals.PERIOD_TYPE, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createRestartDelayTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (Integer)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.INT, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertRestartDelayTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.INT, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createRestartDelayTypeObjectFromString ( EDataType eDataType, String initialValue )
    {
        return createRestartDelayTypeFromString ( ConfigurationPackage.Literals.RESTART_DELAY_TYPE, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertRestartDelayTypeObjectToString ( EDataType eDataType, Object instanceValue )
    {
        return convertRestartDelayTypeToString ( ConfigurationPackage.Literals.RESTART_DELAY_TYPE, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createTypeTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertTypeTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantTypeType createVariantTypeTypeObjectFromString ( EDataType eDataType, String initialValue )
    {
        return createVariantTypeTypeFromString ( ConfigurationPackage.Literals.VARIANT_TYPE_TYPE, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertVariantTypeTypeObjectToString ( EDataType eDataType, Object instanceValue )
    {
        return convertVariantTypeTypeToString ( ConfigurationPackage.Literals.VARIANT_TYPE_TYPE, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationPackage getConfigurationPackage ()
    {
        return (ConfigurationPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ConfigurationPackage getPackage ()
    {
        return ConfigurationPackage.eINSTANCE;
    }

} //ConfigurationFactoryImpl
