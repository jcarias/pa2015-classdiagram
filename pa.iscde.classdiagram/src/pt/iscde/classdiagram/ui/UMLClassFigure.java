package pt.iscde.classdiagram.ui;



import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;

public class UMLClassFigure extends Figure {

	private CompartmentFigure attributeFigure = new CompartmentFigure();
	private CompartmentFigure methodFigure = new CompartmentFigure();

	public UMLClassFigure(Label name) {
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(getLineBorder());
		setOpaque(true);
		add(name);
		add(attributeFigure);
		add(methodFigure);
	}
	
	
	private Border getLineBorder() {
		return new LineBorder(ColorConstants.black, 1);
	}
	
	public CompartmentFigure getAttributesCompartment() {
		return attributeFigure;
	}

	public CompartmentFigure getMethodsCompartment() {
		return methodFigure;
	}
}
