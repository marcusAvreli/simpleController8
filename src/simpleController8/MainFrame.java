package simpleController8;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.RootPaneContainer;

public class MainFrame extends JFrame{
	JSplitPane splitPane;
	JPanel leftRootView;
	JPanel rightRootView;
	
	public MainFrame() {
		initComponents();
	}
	
	public void initComponents() {
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 splitPane = new javax.swing.JSplitPane();
		 splitPane.setDividerLocation(200);
		 leftRootView = new JPanel();
        rightRootView = new JPanel();
        splitPane.setRightComponent(rightRootView);
        splitPane.setLeftComponent(leftRootView);
        //RootPane (this.getContentPane())
    	
    	//Container container = ((RootPaneContainer)this).getContentPane();
    	//container.add(splitPane);
    	JPanel panel = new JPanel();
    	JLabel lbl = new JLabel("testMyLabel");
    	panel.add(lbl);
    	
    	
    	AbstractViewContainer def = new DefaultView("myPanelId","myTitle",panel);
    
    	//ViewManager
    	//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewManager.java
    	ViewManager vm = new ViewManager();
    	vm.setFrame(this);
    	vm.addView(def);

		pack();
		setVisible(true);
	}
	/*
	public void setViews(Map<Object,JPanel> views) {
		rightRootView.add(views.get("view"));
		leftRootView.add(views.get("view2"));
	}
	*/
}
