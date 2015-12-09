package classdiagramfilterextension;

import java.util.Set;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilter;
import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

public class ExtensionPointTestFilter implements ClassDiagramFilter {

<<<<<<< HEAD
	
=======
	private boolean active;

	public ExtensionPointTestFilter() {
		this.active = true;
	}

>>>>>>> origin/master
	@Override
	public String getFilterName() {
		return "Example filter";
	}

	@Override
	public String getFilterShortDescription() {
		return "Example filter's short description.";
	}

	@Override
	public boolean acceptTopElement(ETopElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers) {
		return ETopElementType.CLASS == type;
	}

	@Override
	public boolean acceptCildElement(EChildElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers, String returnType) {
<<<<<<< HEAD
		
		return modifiers.contains(EModifierType.CONSTRUCTOR);
	}

	


=======

		return modifiers.contains(EModifierType.CONSTRUCTOR);
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void activate() {
		active = true;
	}

	@Override
	public void deactivate() {
		active = false;

	}
>>>>>>> origin/master
}
