package classdiagramfilterextension;

import java.util.Set;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilter;
import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

public class ExtensionPointTestFilter implements ClassDiagramFilter {

	private boolean active;

	@Override
	public boolean acceptTopElement(ETopElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers) {
		return ETopElementType.CLASS.equals(type) || ETopElementType.SUPERCLASS.equals(type);
	}

	@Override
	public boolean acceptCildElement(EChildElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers, String returnType) {
		return visibility.equals(EModifierType.PUBLIC);
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void activate() {
		this.active = true;

	}

	@Override
	public void deactivate() {
		this.active = false;
	}

	@Override
	public String getFilterName() {
		return "Filtro de Teste";
	}

	@Override
	public String getFilterShortDescription() {
		return "Filtro de Teste para exibir apenas classes e os métodos públicos das mesmas";
	}
}