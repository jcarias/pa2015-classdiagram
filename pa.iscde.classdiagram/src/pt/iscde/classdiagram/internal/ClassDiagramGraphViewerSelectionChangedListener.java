package pt.iscde.classdiagram.internal;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.zest.core.viewers.GraphViewer;

import pt.iscde.classdiagram.model.TopLevelElement;

class ClassDiagramGraphViewerSelectionChangedListener implements ISelectionChangedListener {

	private GraphViewer viewer;
	private MenuManager mm;
	ClassDiagramMenuHelper menuHelper;

	public ClassDiagramGraphViewerSelectionChangedListener(GraphViewer viewer, MenuManager mm) {
		this.viewer = viewer;
		this.mm = mm;
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
		
		//ClassDiagramMenuHelper.createMenu(this.viewer, mm);
		
		viewer.refresh(true);
		
		System.out.println(((IStructuredSelection)viewer.getSelection()).size());
	}
	
}