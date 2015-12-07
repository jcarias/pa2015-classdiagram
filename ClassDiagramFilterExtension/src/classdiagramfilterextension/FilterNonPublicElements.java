package classdiagramfilterextension;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilter;
import pt.iscde.classdiagram.model.AttributeElement;
import pt.iscde.classdiagram.model.MethodElement;

public class FilterNonPublicElements implements ClassDiagramFilter {

	@Override
	public boolean acceptAttribute(AttributeElement attribute) {
		return attribute.isPublic();
	}

	@Override
	public boolean acceptMethod(MethodElement method) {
		return method.isPublic();
	}

	

}
