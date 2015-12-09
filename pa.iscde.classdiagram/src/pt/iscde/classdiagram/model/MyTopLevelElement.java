package pt.iscde.classdiagram.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import pt.iscde.classdiagram.extensibility.ClassDiagramFilter;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;
import pt.iscde.classdiagram.ui.ToolTipFigure;
import pt.iscde.classdiagram.ui.UMLClassFigure;

public class MyTopLevelElement implements TopLevelElement {
	private String id;
	private String name;
	private ETopElementType classType;
	private EModifierType accessControlType;
	private List<TopLevelElement> connections;
	private List<ChildElementTemplate> attributes;
	private List<ChildElementTemplate> methods;
	private Set<EModifierType> modifiers;

	private Map<String, Image> imageMap;
	private List<ClassDiagramFilter> filters;

	public MyTopLevelElement(String id, String name, ETopElementType classType, Map<String, Image> imageMap) {
		this.id = id;
		this.name = name;
		this.classType = classType;
		this.imageMap = imageMap;

		this.connections = new ArrayList<TopLevelElement>();
		this.attributes = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.modifiers = new HashSet<EModifierType>();
	}

	public MyTopLevelElement() {
		this.connections = new ArrayList<TopLevelElement>();
		this.attributes = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.modifiers = new HashSet<EModifierType>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ETopElementType getClassType() {
		return classType;
	}

	@Override
	public List<TopLevelElement> getConnectedTo() {
		return connections;
	}

	@Override
	public void addAttribute(ChildElementTemplate childElement) {
		this.attributes.add(childElement);
	}

	@Override
	public void addMethod(ChildElementTemplate childElement) {
		this.methods.add(childElement);
	}

	@Override
	public IFigure getFigure() {
		if (filters != null)
			for (ClassDiagramFilter filter : filters) {
				if (filter.isActive() && !filter.acceptTopElement(classType, name, accessControlType, modifiers))
				return null;
			}

		Label classLabel = new Label(getName(), getClassIcon());
		classLabel.setFont(new Font(null, "Arial", 12, SWT.BOLD));
		classLabel.setToolTip(new ToolTipFigure(getId()));
		UMLClassFigure classFigure = new UMLClassFigure(classLabel);

		if (attributes != null && attributes.size() > 0) {
			boolean displaybleAttributesFound = false;
			for (ChildElementTemplate childElement : attributes) {
				if (canBeRedered(childElement)) {
					classFigure.getAttributesCompartment().add(childElement.getLabel());
					displaybleAttributesFound = true;
				}
			}

			if (!displaybleAttributesFound) {
				classFigure.getAttributesCompartment().add(new Label("", null));
			}
		} else {
			classFigure.getAttributesCompartment().add(new Label("", null));
		}

		if (methods != null && methods.size() > 0) {
			boolean displaybleMethodsFound = false;
			for (ChildElementTemplate childElement : methods) {
				if (canBeRedered(childElement)) {
					classFigure.getMethodsCompartment().add(childElement.getLabel());
					displaybleMethodsFound = true;
				}
			}
			if (!displaybleMethodsFound) {
				classFigure.getMethodsCompartment().add(new Label("", null));
			}
		} else {
			classFigure.getMethodsCompartment().add(new Label("", null));
		}

		classFigure.setSize(-1, -1);

		return classFigure;
	}

	private boolean canBeRedered(ChildElementTemplate childElement) {
		if (filters != null) {
			for (ClassDiagramFilter filter : filters) {
				if (filter.isActive())
					return filter.acceptCildElement(childElement.getElementType(), childElement.getName(), childElement.getAccessControlType(), childElement.getModifiers(), childElement.getReturnType());
				else
					return true;
			}
		}
		return true;
	}

	private Image getClassIcon() {
		Image image = null;

		switch (getClassType()) {
		case CLASS:
		case SUPERCLASS:
			image = imageMap.get("class_obj.png");
			break;
		case INTERFACE:
			image = imageMap.get("int_obj.png");
			break;
		case ENUM:
			image = imageMap.get("enum_obj.png");
			break;
		default:
			return null;
		}

		// Add modifier overlays
		int mergedOverlays = 0;

		if (accessControlType != null) {
			Image overlayImg = EModifierType.getModifierIcon(accessControlType, imageMap);
			if (overlayImg != null) {
				image = ChildElementTemplate.getDecoratedImage(image, overlayImg, mergedOverlays++);
			}
		}

		if (modifiers != null) {
			for (EModifierType modifierType : modifiers) {
				Image overlayImg = EModifierType.getModifierIcon(modifierType, imageMap);
				image = ChildElementTemplate.getDecoratedImage(image, overlayImg, mergedOverlays++);
			}
		}
		return image;
	}

	@Override
	public void addMmodifier(EModifierType modifierType) {
		modifiers.add(modifierType);
	}

	public void addModifier(Modifier node) {
		// Set Access ControlType
		if (node.isPublic())
			accessControlType = EModifierType.PUBLIC;
		else if (node.isPrivate())
			accessControlType = EModifierType.PRIVATE;
		else if (node.isProtected())
			accessControlType = EModifierType.PROTECTED;
		else if (node.isDefault())
			accessControlType = EModifierType.PACKAGE;

		// Add modifiers ControlType
		if (node.isAbstract()) {
			modifiers.add(EModifierType.ABSTRACT);
		}
		if (node.isFinal()) {
			modifiers.add(EModifierType.FINAL);
		}
		if (node.isStatic()) {
			modifiers.add(EModifierType.STATIC);
		}
		if (node.isTransient()) {
			modifiers.add(EModifierType.TRANSIENT);
		}
		if (node.isSynchronized()) {
			modifiers.add(EModifierType.SYNCHRONIZED);
		}
		if (node.isVolatile()) {
			modifiers.add(EModifierType.VOLATILE);
		}
	}

	@Override
	public void setSelected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFilters(List<ClassDiagramFilter> filters) {
		this.filters = filters;

	}
}
