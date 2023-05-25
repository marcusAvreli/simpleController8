package simpleController8;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

public class ViewManager {
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}

	public void addView	(ViewContainer view)  
	{	 
		System.out.println("hello");
		if(null != view) {
			System.out.println("not_null");

		}
		view.viewInit();
		Component component = view.getRootPane();
		if(null !=component) {
			System.out.println("component_is_not_null");
		}else {
			System.out.println("component_is_null");
		}
		JFrame frame = this.getFrame();
		frame.add(component);
		
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
