package actiontester;

import pt.iscde.classdiagram.extensibility.ClassDiagramAction;

public class ClassDiagramActionTest extends ClassDiagramAction {

	@Override
	public void run() {
		if(selectedElement!=null){
			System.out.println(selectedElement.getName());
		}else{
			System.out.println("Nenhum elemento");
		}
	}

}
