package actiontester;

import pt.iscde.classdiagram.extensibility.IClassDiagramAction;
import pt.iscde.classdiagram.model.TopLevelElement;

public class ClassDiagramActionTest implements IClassDiagramAction {

	/// INTERFACE

	@Override
	public void run(TopLevelElement selectedElement) {
		if(selectedElement!=null){
			System.out.println(selectedElement.getName());
			selectedElement.setSelected(true);
		}else{
			System.out.println("Nenhum elemento");
		}
	}

}
