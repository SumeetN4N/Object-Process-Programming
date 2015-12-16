/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPDialogInputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  public OPPDialogInputProcessInstance() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  @Override
  protected void executing() {
    OPPObjectInstance prompt = getArgument("prompt");
    if (prompt == null)
      prompt = OPPObjectInstance.createFromValue("Enter a value");

    javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 25));
    javax.swing.UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 25));
    String input = JOptionPane.showInputDialog(prompt.getStringValue());

    OPPObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
    setArgument("input", instance);
  }

  @Override
  public String getName() {
    return "Dialog Input";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("prompt"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("input"));
  }
}