package pt.iscde.classdiagram.extensibility;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchActionConstants;

public class ClassDiagramMenuHelper implements MouseListener {

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		if(arg0.button == 3){
			System.out.println("BOTAO DIREITO");
			CreateContextMenu(arg0.x, arg0.y);
		}

	}

	@Override
	public void mouseUp(MouseEvent arg0) {

	}
	
	public static Display getDisplay() {
	      Display display = Display.getCurrent();
	      //may be null if outside the UI thread
	      if (display == null)
	         display = Display.getDefault();
	      return display;		
	   }

	
	
	public void CreateContextMenu(int positionX, int positionY){
//		Display display = getDisplay();
//		Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
//
//        Menu menuBar = new Menu(shell, SWT.BAR);
//        //org.eclipse.swt.widgets.
//        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
//        cascadeFileMenu.setText("&File");
//        
//        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
//        cascadeFileMenu.setMenu(fileMenu);
//
//        //MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
//        //exitItem.setText("&Exit");
//        //shell.setMenuBar(menuBar);
//
//        shell.setText("Simple menu");
//        shell.setSize(300, 200);
//        shell.setLocation(positionX, positionY);
//        shell.open();
//
//        while (!shell.isDisposed()) {
//          if (!display.readAndDispatch()) {
//            display.sleep();
//          }
//        }
		//MenuManager mm = new MenuManager();
		//viewer.getGraphControl().setMenu(mm.createContextMenu(viewer.getGraphControl()));
		
		
	}
	

}
