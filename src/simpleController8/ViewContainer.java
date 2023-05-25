package simpleController8;

import javax.swing.JComponent;
import javax.swing.RootPaneContainer;

public interface ViewContainer extends RootPaneContainer{
	// public JComponent getView();
	public abstract void viewInit();
}
