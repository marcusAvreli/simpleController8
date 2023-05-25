package simpleController8;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewContainer.java
public class AbstractViewContainer  implements ViewContainer {
	private JRootPane 								rootPane;
	Container contentPane;
	String id;
	String title;
	private List<ViewContainerEventController> viewContainerEventControllers;
	public AbstractViewContainer(String id,String title,Component component){
		//super();
		this.setId(id);
		this.setTitle(title);
		this.getContentPane().add(component);
		this.viewContainerEventControllers = new ArrayList<ViewContainerEventController>();
		addViewContainerListener(new DefaultViewContainerEventController());
	}
	@Override
	public void setContentPane(Container contentPane) {
		// TODO Auto-generated method stub
		if(null != contentPane) {
			System.out.println("setContentPane");
		}else {
			System.out.println("set_content_pane_is_null");
		}
		this.getRootPane().setContentPane(contentPane);
	}

	@Override
	public Container getContentPane() {
		// TODO Auto-generated method stub
		
		return this.getRootPane().getContentPane(); 
	
	}

	@Override
	public void setLayeredPane(JLayeredPane layeredPane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JLayeredPane getLayeredPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGlassPane(Component glassPane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getGlassPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JRootPane getRootPane() {
		// TODO Auto-generated method stub
		if (this.rootPane == null){
			this.rootPane = new JRootPane();
			this.rootPane.setName("ROOTPANE");
		}
		return this.rootPane;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void viewInit() {
		System.out.println("view_init");
		if (this.getContentPane()!=null) { 
			this.getContentPane().setName("contentPane");
			}
		this.fireViewInit(new ViewContainerEvent(this));
	}
	/* (non-Javadoc)
	 * @see org.viewaframework.view.ViewContainerEventAware#fireViewInit(org.viewaframework.view.ViewContainerEvent)
	 */
	public void fireViewInit(ViewContainerEvent event) {
		System.out.println("fire_view_init");
		for (ViewContainerEventController listener: this.viewContainerEventControllers){
			listener.onViewInit(event);
		}
	}
	public void addViewContainerListener(ViewContainerEventController listener){
		this.viewContainerEventControllers.add(listener);
	}
}
