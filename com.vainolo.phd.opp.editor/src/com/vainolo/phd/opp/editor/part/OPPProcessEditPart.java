/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IFileEditorInput;

import com.vainolo.phd.opp.editor.command.OPPNodeChangeConstraintCommand;
import com.vainolo.phd.opp.editor.figure.OPPFigureConstants;
import com.vainolo.phd.opp.editor.figure.OPPProcessFigure;
import com.vainolo.phd.opp.editor.figure.OPPThingFigure;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPNodeExtensions;

public class OPPProcessEditPart extends OPPThingEditPart {

  @Override
  protected IFigure createFigure() {
    return new OPPProcessFigure();
  }

  @Override
  protected void refreshVisuals() {
    OPPProcessFigure figure = getFigure();
    OPPProcess model = getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();
    OPPObjectProcessDiagram opd = OPPNodeExtensions.findOPD(model);
    if (opd == null)
      return;

    figure.setTooltipText(model.getDescription());
    figure.setDashedBorder(model.isAbstract());

    if (opd.getKind() != OPPObjectProcessDiagramKind.COMPOUND || !model.isMain()) {
      figure.getNameFigure().setText(model.getName());

      if (opd.getKind() != OPPObjectProcessDiagramKind.FREE_FORM) {
        final IFileEditorInput input = (IFileEditorInput) ((DefaultEditDomain) getViewer().getEditDomain()).getEditorPart().getEditorInput();
        final IFile oppFile = input.getFile().getParent().getFile(new Path(model.getName() + ".opp"));
        if (oppFile.exists()) {
          figure.setBorderWidth(OPPFigureConstants.IN_ZOOMED_THING_BORDER_WIDTH);
        } else {
          figure.setBorderWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
        }
      }
    }
    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
    if (!model.isManualSize()) {
      Display.getCurrent().asyncExec(new Runnable() {
        @Override
        public void run() {
          OPPProcess model = getModel();
          if (model.isMain())
            return;
          OPPProcessFigure figure = getFigure();
          Dimension prefSize = figure.getPreferredSize();

          if (prefSize.width != model.getWidth() || prefSize.height != model.getHeight()) {
            OPPNodeChangeConstraintCommand command = new OPPNodeChangeConstraintCommand();
            command.setNode(model);
            command.setNewConstraint(model.getX(), model.getY(), figure.getPreferredSize().width, figure.getPreferredSize().height);
            getViewer().getEditDomain().getCommandStack().execute(command);

          }
        }
      });
    }
  }

  @Override
  public IFigure getContentPane() {
    return ((OPPThingFigure) getFigure()).getContentPane();
  }

  @Override
  public OPPProcessFigure getFigure() {
    return OPPProcessFigure.class.cast(super.getFigure());
  }

  @Override
  public OPPProcess getModel() {
    return OPPProcess.class.cast(super.getModel());
  }
}
