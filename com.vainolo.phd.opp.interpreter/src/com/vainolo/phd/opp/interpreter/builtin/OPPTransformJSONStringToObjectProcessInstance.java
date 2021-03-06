/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.List;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonReader;

public class OPPTransformJSONStringToObjectProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPJsonReader reader = new OPPJsonReader();
    try {
      String json = getArgument("json").getStringValue();
      if (json.startsWith("{")) {
        JsonObject jsonObject = JsonObject.readFrom(json);
        OPPObjectInstance opmObjectInstance = reader.read(jsonObject);
        setArgument("object", opmObjectInstance);
      } else if (json.startsWith("[")) {
        JsonArray jsonArray = JsonArray.readFrom(json);
        OPPObjectInstance opmObjectInstance = reader.read(jsonArray);
        setArgument("object", opmObjectInstance);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logSevere(e.getLocalizedMessage());
    }
  }

  @Override
  public String getName() {
    return "Read JSON";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("json"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

}
