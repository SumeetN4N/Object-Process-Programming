/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonWriter;

public class OPPWriteOPMObjectInstanceToJSON extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPJsonWriter writer = new OPPJsonWriter();
    OPPObjectInstance opmObjectInstance = getArgument("object");
    JsonObject jsonObject = writer.write(opmObjectInstance);
    setArgument("json", OPPObjectInstance.createFromValue(jsonObject.toString()));
  }

  @Override
  public String getName() {
    return "Write JSON";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("json"));
  }

}