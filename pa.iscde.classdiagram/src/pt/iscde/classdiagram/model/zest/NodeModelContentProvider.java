package pt.iscde.classdiagram.model.zest;

import java.util.ArrayList;
import java.util.List;

import pt.iscde.classdiagram.internal.MyClassDiagramFilter;
import pt.iscde.classdiagram.model.MyConnection;
import pt.iscde.classdiagram.model.MyTopLevelElement;
import pt.iscde.classdiagram.model.TopLevelElement;

public class NodeModelContentProvider {
	private List<MyConnection> connections;
	private List<MyTopLevelElement> nodes;
	private List<MyClassDiagramFilter> filters;

	public NodeModelContentProvider() {
		nodes = new ArrayList<MyTopLevelElement>();
		connections = new ArrayList<MyConnection>();
		filters = new ArrayList<MyClassDiagramFilter>();

		for (MyConnection connection : connections) {
			connection.getSource().getConnectedTo().add(connection.getDestination());
		}
	}

	public List<MyTopLevelElement> getNodes() {
		return nodes;
	}

	public void addConnection(MyConnection connection) {
		this.connections.add(connection);
		for (MyConnection conn : connections) {
			conn.getSource().getConnectedTo().add(connection.getDestination());
		}
	}
	
	public void addFilters(List<MyClassDiagramFilter> filters){
		if(filters!=null){
			for (MyClassDiagramFilter classDiagramFilter : filters) {
				this.filters.add(classDiagramFilter);
			}
		}
		if(nodes!=null){
			for (TopLevelElement element : nodes) {
				element.setFilters(this.filters);
				if(!element.getConnectedTo().isEmpty()){
					for (TopLevelElement connectedElem : element.getConnectedTo()) {
						connectedElem.setFilters(filters);
					}
				}
			}
		}
	}
	
	
	public void  clearFilters(){
		filters = new ArrayList<MyClassDiagramFilter>();
		
		if(nodes!=null){
			for (MyTopLevelElement element : nodes) {
				element.setFilters(filters);
				if(!element.getConnectedTo().isEmpty()){
					for (TopLevelElement connectedElem : element.getConnectedTo()) {
						connectedElem.setFilters(filters);
					}
				}
			}
		}
	}
	
	
	public void clearSelection(){
		if(nodes!=null){
			for (MyTopLevelElement element : nodes) {
				element.setSelected(false);
			}
		}
	}
}
