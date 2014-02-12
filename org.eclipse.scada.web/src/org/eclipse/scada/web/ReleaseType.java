/**
 */
package org.eclipse.scada.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Release Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.web.WebPackage#getReleaseType()
 * @model
 * @generated
 */
public enum ReleaseType implements Enumerator {
	/**
	 * The '<em><b>Nightly</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NIGHTLY_VALUE
	 * @generated
	 * @ordered
	 */
	NIGHTLY(0, "nightly", "nightly"),

	/**
	 * The '<em><b>Milestone</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILESTONE_VALUE
	 * @generated
	 * @ordered
	 */
	MILESTONE(1, "milestone", "milestone"),

	/**
	 * The '<em><b>Release</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELEASE_VALUE
	 * @generated
	 * @ordered
	 */
	RELEASE(2, "release", "release");

	/**
	 * The '<em><b>Nightly</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nightly</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NIGHTLY
	 * @model name="nightly"
	 * @generated
	 * @ordered
	 */
	public static final int NIGHTLY_VALUE = 0;

	/**
	 * The '<em><b>Milestone</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Milestone</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILESTONE
	 * @model name="milestone"
	 * @generated
	 * @ordered
	 */
	public static final int MILESTONE_VALUE = 1;

	/**
	 * The '<em><b>Release</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Release</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELEASE
	 * @model name="release"
	 * @generated
	 * @ordered
	 */
	public static final int RELEASE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Release Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReleaseType[] VALUES_ARRAY =
		new ReleaseType[] {
			NIGHTLY,
			MILESTONE,
			RELEASE,
		};

	/**
	 * A public read-only list of all the '<em><b>Release Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReleaseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Release Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReleaseType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReleaseType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Release Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReleaseType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReleaseType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Release Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReleaseType get(int value) {
		switch (value) {
			case NIGHTLY_VALUE: return NIGHTLY;
			case MILESTONE_VALUE: return MILESTONE;
			case RELEASE_VALUE: return RELEASE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ReleaseType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ReleaseType
