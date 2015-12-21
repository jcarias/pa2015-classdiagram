package pt.iscde.classdiagram.extensibility;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.zest.core.viewers.GraphViewer;

import pt.iscde.classdiagram.extensibility.actions.FilterAction;

public class ClassDiagramMenuHelper {

	private List<Action> defaultActions;
	private List<ClassDiagramFilter> filters;
	private List<ClassDiagramAction> actions;
	private GraphViewer viewer;
	private MenuManager mm;

	public ClassDiagramMenuHelper(GraphViewer viewer) {
		super();
		defaultActions = new ArrayList<Action>();
		filters = new ArrayList<ClassDiagramFilter>();
		actions = new ArrayList<ClassDiagramAction>();

		this.viewer = viewer;
		this.mm = new MenuManager();
	}

	public Menu getMenu() {
		mm.createContextMenu(viewer.getGraphControl());
		upadateManager();
		return mm.getMenu();
	}
	
	private void upadateManager() {
		mm.removeAll();
		addDefaultActionsToMenu();
		addFiltersToMenu();
		addActionsToMenu();
	}

	private void addDefaultActionsToMenu() {
		if (defaultActions != null && defaultActions.size() > 0) {
			for (Action action : defaultActions) {
				mm.add(action);
			}
		}
	}

	private void addFiltersToMenu() {
		if (filters != null && filters.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramFilter classDiagramFilter : filters) {
				Action filterAction = new FilterAction(classDiagramFilter, viewer);
				filterAction.setId("Filter_" + classDiagramFilter.hashCode());
				mm.add(filterAction);
			}
		}
	}

	private void addActionsToMenu() {
		if (actions != null && actions.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramAction action : actions) {
				mm.add(action);
			}
		}

	}


	public void addDefaultAction(Action refreshAction) {
		defaultActions.add(refreshAction);
		upadateManager();
	}

	public void setFilters(List<ClassDiagramFilter> filters) {
		this.filters = filters;
		upadateManager();
	}

	public void setActions(List<ClassDiagramAction> actions) {
		this.actions = actions;
		upadateManager();
	}
}
