package pt.iscde.classdiagram.extensibility.actions;

import org.eclipse.zest.core.viewers.GraphViewer;

import pt.iscde.classdiagram.internal.MyClassDiagramFilter;

public class FilterAction extends RefreshAction{
	
	private MyClassDiagramFilter filter;
	
	public FilterAction(MyClassDiagramFilter classDiagramFilter, GraphViewer viewer) {
		super(viewer);
		this.filter = classDiagramFilter;
		setText(classDiagramFilter.getFilterText());
		setToolTipText(classDiagramFilter.getFilterShortDescription());
		setChecked(classDiagramFilter.isActive());
	}

	@Override
	public void run() {
		if(filter.isActive()){
			filter.setActive(false);
		}else{
			filter.setActive(true);
		}
		
		setChecked(filter.isActive());
		super.run();
	}
	
	
}
