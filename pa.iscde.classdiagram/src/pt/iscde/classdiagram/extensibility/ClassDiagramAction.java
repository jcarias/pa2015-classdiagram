package pt.iscde.classdiagram.extensibility;

import org.eclipse.jface.action.Action;

import pt.iscde.classdiagram.model.TopLevelElement;


public abstract class ClassDiagramAction extends Action {

	protected TopLevelElement selectedElement;
	
	public abstract void run();
	
	public abstract String getName();
	
	public abstract String getTooltipText();
	
	public final void setSelectedElement(TopLevelElement selectedElement){
		this.selectedElement = selectedElement;
	}

}
