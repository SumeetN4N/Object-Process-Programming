package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPRemoveLastPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance composite = getArgument("object");
    if (composite.getAllPartIndexes().size() > 0) {
      OPPObjectInstance part = composite.removeLastPart();
      setArgument("part", part);
    }
    setArgument("new object", composite);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("part"), new OPPParameter("new object"));
  }

  @Override
  public String getName() {
    return "Remove Last Part";
  }
}