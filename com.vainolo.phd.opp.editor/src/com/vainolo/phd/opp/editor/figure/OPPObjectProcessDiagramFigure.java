/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPPObjectProcessDiagramFigure extends Figure {

  private Label opdNameLabel;

  public OPPObjectProcessDiagramFigure() {
    setLayoutManager(new XYLayout());
    opdNameLabel = new Label();
    add(opdNameLabel);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getParent().getBounds();
    setConstraint(opdNameLabel, new Rectangle(0, 0, r.width, 30));
  }

  @Override
  public Rectangle getBounds() {
    Dimension d = getPreferredSize();
    return new Rectangle(0, 0, d.width, d.height);
  }

  public IFigure getContentPane() {
    return this;
  }

  @Override
  public boolean isCoordinateSystem() {
    return true;
  }

  public void setOPDName(String name) {
    opdNameLabel.setText(name);
  }
}
