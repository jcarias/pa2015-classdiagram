package pt.iscde.classdiagram.extensibility;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SpringLayout;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import pt.iscde.classdiagram.extensibility.actions.ChangeLayoutAction;
import pt.iscde.classdiagram.extensibility.actions.FilterAction;
import pt.iscde.classdiagram.extensibility.actions.RefreshAction;
import pt.iscde.classdiagram.model.TopLevelElement;

import org.eclipse.jface.action.Action;

public class ClassDiagramMenuHelper {
	
	public static void createMenu(GraphViewer viewer, MenuManager mm) {
		viewer.getGraphControl().setMenu(mm.createContextMenu(viewer.getGraphControl()));
		mm.add(new RefreshAction(viewer));
		//mm.add(new ChangeLayout(viewer, "Spring Layout", new SpringLayoutAlgorithm()));
		//mm.add(new ChangeLayout(viewer, "Tree Layout", new TreeLayoutAlgorithm()));
	}
	
	public static void addFiltersToMenu(GraphViewer viewer, List<ClassDiagramFilter> filters, MenuManager mm){
		if (filters != null && filters.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramFilter classDiagramFilter : filters) {
				mm.add(new FilterAction(classDiagramFilter, viewer));
			}
		}
		else
		{
			createMenu(viewer, new MenuManager());
		}
	}
	
	public static void addLayoutsToMenu(GraphViewer viewer, List<LayoutAlgorithm> layoutAlgorithms, MenuManager mm){
		if (layoutAlgorithms != null && layoutAlgorithms.size() > 0) {
			mm.add(new Separator());
			for (LayoutAlgorithm algorithm : layoutAlgorithms) {
				mm.add(new ChangeLayoutAction(viewer, algorithm.toString(), algorithm));
			}
		}
		else
		{
			createMenu(viewer, new MenuManager());
		}
	}
	
	public static void addActionsToMenu(GraphViewer viewer, List<ClassDiagramAction> actions, MenuManager mm){
		if (actions != null && actions.size() > 0) {
			mm.add(new Separator());
			for (ClassDiagramAction action : actions) {
				mm.add(action);
			}
		}
		else
		{
			createMenu(viewer, new MenuManager());
		}
	}
	
	
}
