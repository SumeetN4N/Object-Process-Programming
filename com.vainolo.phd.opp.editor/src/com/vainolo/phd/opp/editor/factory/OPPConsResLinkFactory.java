/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;

public class OPPConsResLinkFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPConsResLinkFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setKind(OPPProceduralLinkKind.CONS_RES);
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPPProceduralLink.class;
  }

}