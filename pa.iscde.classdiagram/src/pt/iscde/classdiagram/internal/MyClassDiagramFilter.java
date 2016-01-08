package pt.iscde.classdiagram.internal;

import java.util.Set;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilterV2;
import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

public class MyClassDiagramFilter {
	private boolean active;
	private ClassDiagramFilterV2 diagramFilter;
	private String filterText;
	private String filterShortDescription;
	
	public MyClassDiagramFilter(boolean active, ClassDiagramFilterV2 diagramFilter, String filterText, String filterShortDescription) {
		super();
		this.active = active;
		this.diagramFilter = diagramFilter;
		this.filterText = filterText;
		this.filterShortDescription = filterShortDescription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClassDiagramFilterV2 getDiagramFilter() {
		return diagramFilter;
	}
	

	public boolean acceptTopElement(ETopElementType classType, String name, EModifierType accessControlType, Set<EModifierType> modifiers) {
		if(diagramFilter!=null){
			return diagramFilter.acceptTopElement(classType, name, accessControlType, modifiers);
		}else{
			return true;
		}
	}
	
	public boolean acceptCildElement(EChildElementType elementType, String name, EModifierType accessControlType, Set<EModifierType> modifiers, String returnType) {
		if(diagramFilter!=null){
			return diagramFilter.acceptCildElement(elementType, name, accessControlType, modifiers, returnType);
		}else{
			return true;
		}
	}

	public String getFilterText() {
		return filterText;
	}

	public String getFilterShortDescription() {
		return filterShortDescription;
	}
}
