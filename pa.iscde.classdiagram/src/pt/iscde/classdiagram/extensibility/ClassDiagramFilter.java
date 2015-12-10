package pt.iscde.classdiagram.extensibility;

import java.util.Set;

import org.eclipse.swt.internal.theme.Theme;

import pt.iscde.classdiagram.model.types.EChildElementType;
import pt.iscde.classdiagram.model.types.EModifierType;
import pt.iscde.classdiagram.model.types.ETopElementType;

/**
 * This is the filter that will allow/disallow the rendering of class diagram
 * elements.
 * 
 * @author João Carias (74404)
 */
public abstract class ClassDiagramFilter {

	private boolean active;
	
	/**
	 * Default constructor. By default the filter is initialized as <b>Active</b>.
	 */
	protected ClassDiagramFilter() {
		this.active = true;
	}
	
	/**
	 * Constructs a new instance setting the active state of the filter
	 * @param active <code>true</code> to initialize the state as "Active", <code>false</code> otherwise.
	 */
	protected ClassDiagramFilter(boolean active) {
		this.active = active;
	}

	/**
	 * Get the filter's name.
	 * 
	 * @return A {@link String} containing the filter's name
	 */
	public abstract String getFilterName();

	/**
	 * Get the filter's short description
	 * 
	 * @return A {@link String} containing a short description of the filter
	 */
	public abstract String getFilterShortDescription();

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
	 *            a set of top element's modifiers (e.g. "STATIC", "FINAL",...).
	 *            See {@link EModifierType}.
	 * @return <code>true</code> if this element should be displayed,
	 *         <code>false</code> otherwise.
	 */
	public abstract boolean acceptTopElement(ETopElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers);

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
	 *            a set of top element's modifiers (e.g. "STATIC", "FINAL",...).
	 *            See {@link EModifierType}.
	 * @param returnType
	 *            the String with the return type.
	 * @return <code>true</code> if this element should be displayed,
	 * 
	 *         <code>false</code> otherwise.
	 */
	public abstract boolean acceptCildElement(EChildElementType type, String name, EModifierType visibility, Set<EModifierType> modifiers, String returnType);
	
	/**
	 * Gets the filter active state
	 * @return <code>true</code> if the filter is active, <code>false</code> otherwise.
	 */
	public final boolean isActive(){
		return this.active;
	}
	
	/**
	 * Activates the filter. Implementations must change the flag's value returned by <code>boolean isActive()</code> to <code>true</code>.
	 */
	public final void activate(){
		this.active = true;
	}
	
	/**
	 * Deactivates the filter. Implementations must change the flag's value returned by <code>boolean isActive()</code> to <code>false</code>.
	 */
	public final void deactivate(){
		this.active = false;
	}
}
