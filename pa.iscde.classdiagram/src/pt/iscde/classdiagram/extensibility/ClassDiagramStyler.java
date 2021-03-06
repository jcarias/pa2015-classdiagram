package pt.iscde.classdiagram.extensibility;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * This is the Styler that will allow customization of the Class diagram elements. With an instance
 * of this styler one is able to customize the default appearance of the elements colors and fonts.  
 * 
 * @author joaocarias
 *
 */
public interface ClassDiagramStyler {
	
	/**
	 * Sets the color of the unselected class figure's background 
	 * @return the unselected background color (not-null)
	 * 
	 */
	public Color getBackgroundColor();
	
	/**
	 * Sets the color of the selected class figure's background 
	 * @return the selected background color (not-null)
	 * 
	 */
	public Color getSelectedBackgroundColor();
	
	public Color getForegroundColor();

	public Color getSelectedForegroundColor();
	
	public Font getTitleFont();

	public Font getAttributesFont();

	public Font getMethodsFont();
}
