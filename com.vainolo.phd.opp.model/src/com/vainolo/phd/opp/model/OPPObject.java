/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPObject#isGlobal <em>Global</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPObject#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObject()
 * @model
 * @generated
 */
public interface OPPObject extends OPPThing {
  /**
   * Returns the value of the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global</em>' attribute.
   * @see #setGlobal(boolean)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObject_Global()
   * @model
   * @generated
   */
  boolean isGlobal();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPObject#isGlobal <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global</em>' attribute.
   * @see #isGlobal()
   * @generated
   */
  void setGlobal(boolean value);

  /**
   * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Value</em>' attribute.
   * @see #setInitialValue(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObject_InitialValue()
   * @model default=""
   * @generated
   */
  String getInitialValue();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPObject#getInitialValue <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Value</em>' attribute.
   * @see #getInitialValue()
   * @generated
   */
  void setInitialValue(String value);

} // OPPObject
