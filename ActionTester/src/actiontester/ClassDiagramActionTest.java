package actiontester;

import pt.iscde.classdiagram.extensibility.ClassDiagramAction;

public class ClassDiagramActionTest extends ClassDiagramAction {

	/// INTERFACE
	
	@Override
	public void run() {
		if(selectedElement!=null){
			System.out.println(selectedElement.getName());
			selectedElement.setSelected(true);
		}else{
			System.out.println("Nenhum elemento");
		}
	}

}
