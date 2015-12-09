package pt.iscde.classdiagram.internal;

import org.eclipse.jface.action.Action;
import org.eclipse.zest.core.viewers.GraphViewer;

public class SomeAction extends Action {
	
	GraphViewer viewer;
	public SomeAction(GraphViewer viewer) {
		this.viewer = viewer;
		setText("Some Action");
	}

	@Override
	public void run() {
		//Do something
		viewer.refresh();
		viewer.applyLayout();
	}

}
