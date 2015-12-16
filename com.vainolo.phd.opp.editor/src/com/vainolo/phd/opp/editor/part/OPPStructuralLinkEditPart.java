package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;

import com.vainolo.phd.opp.editor.figure.OPPStructuralLinkFigure;
import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPStructuralLinkEditPart extends OPPLinkEditPart {

  public OPPStructuralLinkEditPart() {
    super();
  }

  @Override
  protected PolylineConnection createFigure() {
    OPPStructuralLinkFigure figure = new OPPStructuralLinkFigure();
    return figure;
  }

  @Override
  public OPPStructuralLinkFigure getFigure() {
    return (OPPStructuralLinkFigure) super.getFigure();
  }

  @Override
  public OPPStructuralLinkPart getModel() {
    return (OPPStructuralLinkPart) super.getModel();
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
    Connection connection = getConnectionFigure();
    List<OPPPoint> modelConstraint = getModel().getBendpoints();
    List<AbsoluteBendpoint> figureConstraint = new ArrayList<AbsoluteBendpoint>();
    for (OPPPoint p : modelConstraint) {
      figureConstraint.add(new AbsoluteBendpoint(p.getX(), p.getY()));
    }
    connection.setRoutingConstraint(figureConstraint);
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPPStructuralLinkBendpointEditPolicy());
  }

}