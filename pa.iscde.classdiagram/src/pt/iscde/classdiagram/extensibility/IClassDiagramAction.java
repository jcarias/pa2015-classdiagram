package pt.iscde.classdiagram.extensibility;

import pt.iscde.classdiagram.model.TopLevelElement;

public interface IClassDiagramAction {

	
	/**
	 * Executes an action defined in the implementing class over the selected element (if any).
	 * 
	 * @param selectedElement represents the selected element in the Class Diagram. It may be null.
	 * 
	 */
	public void run(TopLevelElement selectedElement);
	
}
