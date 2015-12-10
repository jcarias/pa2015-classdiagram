package pt.iscde.classdiagram.internal;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.zest.core.viewers.GraphViewer;

import pt.iscde.classdiagram.model.TopLevelElement;

class ClassDiagramGraphViewerSelectionChangedListener implements ISelectionChangedListener {

	private GraphViewer viewer;

	public ClassDiagramGraphViewerSelectionChangedListener(GraphViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object[] nodeElements = viewer.getNodeElements();
		for (Object nodeElement : nodeElements) {
			if (nodeElement instanceof TopLevelElement) {
				TopLevelElement element = (TopLevelElement) nodeElement;
				element.setSelected(false);
			}
		}
		
		if (selection.size() < 1) {

		} else {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof TopLevelElement) {
				TopLevelElement element = (TopLevelElement) selectedElement;
				element.setSelected(!element.isSelected());
			}
		}
		
		viewer.refresh(true);
		
		System.out.println(((IStructuredSelection)viewer.getSelection()).size());
	}
}