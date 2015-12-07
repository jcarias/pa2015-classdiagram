package pt.iscde.classdiagram.extensibility;

import pt.iscde.classdiagram.model.AttributeElement;
import pt.iscde.classdiagram.model.MethodElement;

/**
 * This is the filter that will allow/disallow the rendering of class diagram elements.
 * @author João Carias (74404)
 */
public interface ClassDiagramFilter {

	public boolean acceptAttribute(AttributeElement attribute);
	
	public boolean acceptMethod(MethodElement method);
}
