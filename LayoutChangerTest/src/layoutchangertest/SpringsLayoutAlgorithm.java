package layoutchangertest;


import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import pt.iscde.classdiagram.extensibility.ILayoutExtender;

public class SpringsLayoutAlgorithm implements ILayoutExtender {

	@Override
	public AbstractLayoutAlgorithm getLayout() {
		// TODO Auto-generated method stub
		return new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
	}

	@Override
	public String getLayoutName() {
		// TODO Auto-generated method stub
		return "Spring Layout";
	}



}
