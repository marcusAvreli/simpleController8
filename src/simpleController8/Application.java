package simpleController8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Application {
	//ViewContainerEventController
	static MainFrame mainFrame;
    public static void main(String[] args) {
    	
    
    	
    	 
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {
		mainFrame=		new MainFrame();
		mainFrame.setVisible(true);
		
	
			}
		});
    	
    }
}
