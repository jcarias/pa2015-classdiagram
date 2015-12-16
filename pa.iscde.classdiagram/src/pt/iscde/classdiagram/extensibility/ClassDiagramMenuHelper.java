package pt.iscde.classdiagram.extensibility;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutAlgorithm;

import pt.iscde.classdiagram.extensibility.actions.ChangeLayoutAction;
import pt.iscde.classdiagram.extensibility.actions.FilterAction;
import pt.iscde.classdiagram.extensibility.actions.RefreshAction;

public class ClassDiagramMenuHelper {

	public static void createMenu(GraphViewer viewer, MenuManager mm) {
		viewer.getGraphControl().setMenu(mm.createContextMenu(viewer.getGraphControl()));
		mm.add(new RefreshAction(viewer));
	}

	public static void addFiltersToMenu(GraphViewer viewer, List<ClassDiagramFilter> filters, MenuManager mm) {
		if (filters != null && filters.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramFilter classDiagramFilter : filters) {
				Action filterAction = new FilterAction(classDiagramFilter, viewer);
				filterAction.setId("Filter_" + classDiagramFilter.hashCode());
				mm.add(filterAction);
			}
		}
	}

	public static void addLayoutsToMenu(GraphViewer viewer, List<LayoutAlgorithm> layoutAlgorithms, MenuManager mm) {
		if (layoutAlgorithms != null && layoutAlgorithms.size() > 0) {
			mm.add(new Separator());
			for (LayoutAlgorithm algorithm : layoutAlgorithms) {
				mm.add(new ChangeLayoutAction(viewer, algorithm.toString(), algorithm));
			}
		}
	}

	public static void addActionsToMenu(GraphViewer viewer, List<ClassDiagramAction> actions, MenuManager mm) {
		if (actions != null && actions.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramAction action : actions) {
				mm.add(action);
			}
		}

	}

	public static void deleteFilters(MenuManager mm) {
		List<IContributionItem> items = new ArrayList<>();
		
		for (IContributionItem item : mm.getItems()) {
			if (item.getId()!=null && item.getId().startsWith("Filter_")){
				items.add(item);
			}
		}
		
		for (IContributionItem item : items) {
			mm.remove(item);
		}
	}

}
