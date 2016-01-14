package pt.iscde.classdiagram.extensibility;

import java.util.Set;

import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

/**
 * This is the filter that will allow/disallow the rendering of class diagram
 * elements.
 * 
 * @author João Carias (74404)
 */
public interface ClassDiagramFilterV2  {

	/**
	 * Filter for top level elements such as Classes, Interfaces or Enums
	 * 
	 * @param type
	 *            the top element's type (see {@link ETopElementType}).
	 * @param name
	 *            the top element's name.
	 * @param visibility
	 *            the top element's access control type. See
	 *            {@link EModifierType}. Typically these can be one of "PUBLIC",
	 *            "PRIVATE",...
	 * @param modifiers
	 *            a set of top element's modifiers (e.g. "STATIC", "FINAL",...). It may be empty or <code>null</code>
	 *            See {@link EModifierType}.
	 * @return <code>true</code> if this element should be displayed,
	 *         <code>false</code> otherwise.
	 */
	public boolean acceptTopElement(ETopElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers);

	/**
	 * Filter for child elements (Attributes or Methods)
	 * 
	 * @param type
	 *            the element's type (Attribute or Method). See
	 *            {@link EChildElementType}.
	 * @param name
	 *            the top element's name.
	 * @param visibility
	 *            the top element's access control type (e.g., "PUBLIC",
	 *            "PRIVATE",...). See {@link EModifierType}.
	 * @param modifiers
	 *            a set of top element's modifiers (e.g. "STATIC", "FINAL",...). . It may be empty or <code>null</code>
	 *            See {@link EModifierType}.
	 * @param returnType
	 *            the String with the return type. . It may be empty or <code>null</code>
	 * @return <code>true</code> if this element (field or method) should be displayed,
	 *         <code>false</code> otherwise.
	 */
	public boolean acceptCildElement(EChildElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers, String returnType);
	
}
