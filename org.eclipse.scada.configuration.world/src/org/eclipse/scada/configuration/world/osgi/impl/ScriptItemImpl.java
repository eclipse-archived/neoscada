/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getInitScript <em>Init Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getUpdateScript <em>Update Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getTimer <em>Timer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl#getWriteCommandScript <em>Write Command Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptItemImpl extends ItemImpl implements ScriptItem {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ItemReference> inputs;

	/**
	 * The cached value of the '{@link #getInitScript() <em>Init Script</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitScript()
	 * @generated
	 * @ordered
	 */
	protected CodeFragment initScript;

	/**
	 * The cached value of the '{@link #getUpdateScript() <em>Update Script</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdateScript()
	 * @generated
	 * @ordered
	 */
	protected CodeFragment updateScript;

	/**
	 * The cached value of the '{@link #getTimer() <em>Timer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimer()
	 * @generated
	 * @ordered
	 */
	protected ScriptTimer timer;

	/**
	 * The default value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptEngine()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_ENGINE_EDEFAULT = "JavaScript"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptEngine()
	 * @generated
	 * @ordered
	 */
	protected String scriptEngine = SCRIPT_ENGINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<ItemReference> commands;

	/**
	 * The cached value of the '{@link #getWriteCommandScript() <em>Write Command Script</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteCommandScript()
	 * @generated
	 * @ordered
	 */
	protected CodeFragment writeCommandScript;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.SCRIPT_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItemReference> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<ItemReference>(
					ItemReference.class, this, OsgiPackage.SCRIPT_ITEM__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment getInitScript() {
		if (initScript != null && initScript.eIsProxy()) {
			InternalEObject oldInitScript = (InternalEObject) initScript;
			initScript = (CodeFragment) eResolveProxy(oldInitScript);
			if (initScript != oldInitScript) {
				InternalEObject newInitScript = (InternalEObject) initScript;
				NotificationChain msgs = oldInitScript.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT, null,
						null);
				if (newInitScript.eInternalContainer() == null) {
					msgs = newInitScript.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT,
							oldInitScript, initScript));
			}
		}
		return initScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment basicGetInitScript() {
		return initScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitScript(CodeFragment newInitScript,
			NotificationChain msgs) {
		CodeFragment oldInitScript = initScript;
		initScript = newInitScript;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT,
					oldInitScript, newInitScript);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitScript(CodeFragment newInitScript) {
		if (newInitScript != initScript) {
			NotificationChain msgs = null;
			if (initScript != null)
				msgs = ((InternalEObject) initScript).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT, null,
						msgs);
			if (newInitScript != null)
				msgs = ((InternalEObject) newInitScript).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT, null,
						msgs);
			msgs = basicSetInitScript(newInitScript, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT, newInitScript,
					newInitScript));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment getUpdateScript() {
		if (updateScript != null && updateScript.eIsProxy()) {
			InternalEObject oldUpdateScript = (InternalEObject) updateScript;
			updateScript = (CodeFragment) eResolveProxy(oldUpdateScript);
			if (updateScript != oldUpdateScript) {
				InternalEObject newUpdateScript = (InternalEObject) updateScript;
				NotificationChain msgs = oldUpdateScript.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT, null,
						null);
				if (newUpdateScript.eInternalContainer() == null) {
					msgs = newUpdateScript.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT,
							oldUpdateScript, updateScript));
			}
		}
		return updateScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment basicGetUpdateScript() {
		return updateScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdateScript(CodeFragment newUpdateScript,
			NotificationChain msgs) {
		CodeFragment oldUpdateScript = updateScript;
		updateScript = newUpdateScript;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT,
					oldUpdateScript, newUpdateScript);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateScript(CodeFragment newUpdateScript) {
		if (newUpdateScript != updateScript) {
			NotificationChain msgs = null;
			if (updateScript != null)
				msgs = ((InternalEObject) updateScript).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT, null,
						msgs);
			if (newUpdateScript != null)
				msgs = ((InternalEObject) newUpdateScript).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT, null,
						msgs);
			msgs = basicSetUpdateScript(newUpdateScript, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT, newUpdateScript,
					newUpdateScript));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptTimer getTimer() {
		if (timer != null && timer.eIsProxy()) {
			InternalEObject oldTimer = (InternalEObject) timer;
			timer = (ScriptTimer) eResolveProxy(oldTimer);
			if (timer != oldTimer) {
				InternalEObject newTimer = (InternalEObject) timer;
				NotificationChain msgs = oldTimer
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__TIMER, null, null);
				if (newTimer.eInternalContainer() == null) {
					msgs = newTimer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
							- OsgiPackage.SCRIPT_ITEM__TIMER, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.SCRIPT_ITEM__TIMER, oldTimer, timer));
			}
		}
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptTimer basicGetTimer() {
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimer(ScriptTimer newTimer,
			NotificationChain msgs) {
		ScriptTimer oldTimer = timer;
		timer = newTimer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, OsgiPackage.SCRIPT_ITEM__TIMER, oldTimer,
					newTimer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimer(ScriptTimer newTimer) {
		if (newTimer != timer) {
			NotificationChain msgs = null;
			if (timer != null)
				msgs = ((InternalEObject) timer)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__TIMER, null, msgs);
			if (newTimer != null)
				msgs = ((InternalEObject) newTimer)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- OsgiPackage.SCRIPT_ITEM__TIMER, null, msgs);
			msgs = basicSetTimer(newTimer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SCRIPT_ITEM__TIMER, newTimer, newTimer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptEngine() {
		return scriptEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptEngine(String newScriptEngine) {
		String oldScriptEngine = scriptEngine;
		scriptEngine = newScriptEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE, oldScriptEngine,
					scriptEngine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItemReference> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList.Resolving<ItemReference>(
					ItemReference.class, this,
					OsgiPackage.SCRIPT_ITEM__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment getWriteCommandScript() {
		if (writeCommandScript != null && writeCommandScript.eIsProxy()) {
			InternalEObject oldWriteCommandScript = (InternalEObject) writeCommandScript;
			writeCommandScript = (CodeFragment) eResolveProxy(oldWriteCommandScript);
			if (writeCommandScript != oldWriteCommandScript) {
				InternalEObject newWriteCommandScript = (InternalEObject) writeCommandScript;
				NotificationChain msgs = oldWriteCommandScript
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
								null, null);
				if (newWriteCommandScript.eInternalContainer() == null) {
					msgs = newWriteCommandScript
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
							oldWriteCommandScript, writeCommandScript));
			}
		}
		return writeCommandScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeFragment basicGetWriteCommandScript() {
		return writeCommandScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWriteCommandScript(
			CodeFragment newWriteCommandScript, NotificationChain msgs) {
		CodeFragment oldWriteCommandScript = writeCommandScript;
		writeCommandScript = newWriteCommandScript;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
					oldWriteCommandScript, newWriteCommandScript);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteCommandScript(CodeFragment newWriteCommandScript) {
		if (newWriteCommandScript != writeCommandScript) {
			NotificationChain msgs = null;
			if (writeCommandScript != null)
				msgs = ((InternalEObject) writeCommandScript)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
								null, msgs);
			if (newWriteCommandScript != null)
				msgs = ((InternalEObject) newWriteCommandScript)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
								null, msgs);
			msgs = basicSetWriteCommandScript(newWriteCommandScript, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT,
					newWriteCommandScript, newWriteCommandScript));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OsgiPackage.SCRIPT_ITEM__INPUTS:
			return ((InternalEList<?>) getInputs()).basicRemove(otherEnd, msgs);
		case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
			return basicSetInitScript(null, msgs);
		case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
			return basicSetUpdateScript(null, msgs);
		case OsgiPackage.SCRIPT_ITEM__TIMER:
			return basicSetTimer(null, msgs);
		case OsgiPackage.SCRIPT_ITEM__COMMANDS:
			return ((InternalEList<?>) getCommands()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
			return basicSetWriteCommandScript(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.SCRIPT_ITEM__INPUTS:
			return getInputs();
		case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
			if (resolve)
				return getInitScript();
			return basicGetInitScript();
		case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
			if (resolve)
				return getUpdateScript();
			return basicGetUpdateScript();
		case OsgiPackage.SCRIPT_ITEM__TIMER:
			if (resolve)
				return getTimer();
			return basicGetTimer();
		case OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE:
			return getScriptEngine();
		case OsgiPackage.SCRIPT_ITEM__COMMANDS:
			return getCommands();
		case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
			if (resolve)
				return getWriteCommandScript();
			return basicGetWriteCommandScript();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OsgiPackage.SCRIPT_ITEM__INPUTS:
			getInputs().clear();
			getInputs().addAll((Collection<? extends ItemReference>) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
			setInitScript((CodeFragment) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
			setUpdateScript((CodeFragment) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__TIMER:
			setTimer((ScriptTimer) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE:
			setScriptEngine((String) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__COMMANDS:
			getCommands().clear();
			getCommands()
					.addAll((Collection<? extends ItemReference>) newValue);
			return;
		case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
			setWriteCommandScript((CodeFragment) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OsgiPackage.SCRIPT_ITEM__INPUTS:
			getInputs().clear();
			return;
		case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
			setInitScript((CodeFragment) null);
			return;
		case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
			setUpdateScript((CodeFragment) null);
			return;
		case OsgiPackage.SCRIPT_ITEM__TIMER:
			setTimer((ScriptTimer) null);
			return;
		case OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE:
			setScriptEngine(SCRIPT_ENGINE_EDEFAULT);
			return;
		case OsgiPackage.SCRIPT_ITEM__COMMANDS:
			getCommands().clear();
			return;
		case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
			setWriteCommandScript((CodeFragment) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OsgiPackage.SCRIPT_ITEM__INPUTS:
			return inputs != null && !inputs.isEmpty();
		case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
			return initScript != null;
		case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
			return updateScript != null;
		case OsgiPackage.SCRIPT_ITEM__TIMER:
			return timer != null;
		case OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE:
			return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null
					: !SCRIPT_ENGINE_EDEFAULT.equals(scriptEngine);
		case OsgiPackage.SCRIPT_ITEM__COMMANDS:
			return commands != null && !commands.isEmpty();
		case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
			return writeCommandScript != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (scriptEngine: "); //$NON-NLS-1$
		result.append(scriptEngine);
		result.append(')');
		return result.toString();
	}

} //ScriptItemImpl
