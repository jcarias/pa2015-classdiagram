package classdiagramfilterextension;

import java.util.Set;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilterV2;
import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

public class ExtensionPointTestFilter implements ClassDiagramFilterV2 {

	@Override
	public boolean acceptTopElement(ETopElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers) {
		//This will display classes and super-classes
		return ETopElementType.CLASS.equals(type) || ETopElementType.SUPERCLASS.equals(type);
	}

	@Override
	public boolean acceptCildElement(EChildElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers, String returnType) {
		//This will display public attributes and methods  
		return EModifierType.PUBLIC.equals(visibility);
	}
}