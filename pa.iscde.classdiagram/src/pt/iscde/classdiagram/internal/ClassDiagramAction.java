package pt.iscde.classdiagram.internal;

import org.eclipse.jface.action.Action;

import pt.iscde.classdiagram.extensibility.IClassDiagramAction;
import pt.iscde.classdiagram.model.TopLevelElement;


public class ClassDiagramAction extends Action{

	private TopLevelElement selectedElement;
	private IClassDiagramAction action;
	
	public final void setSelectedElement(TopLevelElement selectedElement){
		this.selectedElement = selectedElement;
	}

	public void setAction(IClassDiagramAction action) {
		this.action = action;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		action.run(selectedElement);
	}
	
	

}
