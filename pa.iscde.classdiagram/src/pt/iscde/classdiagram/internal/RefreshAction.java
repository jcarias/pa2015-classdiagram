package pt.iscde.classdiagram.internal;

import org.eclipse.jface.action.Action;
import org.eclipse.zest.core.viewers.GraphViewer;

public class RefreshAction extends Action {

	GraphViewer viewer;
	public RefreshAction(GraphViewer viewer) {
		this.viewer = viewer;
<<<<<<< HEAD
		setText("Refresh");
=======
		setText("refresh");
>>>>>>> origin/master
	}

	@Override
	public void run() {
		viewer.refresh();
		viewer.applyLayout();
	}
<<<<<<< HEAD

	
=======
>>>>>>> origin/master
}
