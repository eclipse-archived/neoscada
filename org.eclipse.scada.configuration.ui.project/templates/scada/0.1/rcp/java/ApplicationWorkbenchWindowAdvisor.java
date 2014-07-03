package $pluginId$;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize ( new Point ( 1200, 1024 ) );
        configurer.setShowCoolBar ( false );
        configurer.setShowStatusLine ( true );
        configurer.setShowProgressIndicator ( true );
        configurer.setShowMenuBar ( true );
        configurer.setTitle("Eclipse SCADA Client"); //$$NON-NLS-1$$
    }
    
    @Override
    public void postWindowOpen() {
        super.postWindowOpen();
        getWindowConfigurer().getWindow().getShell().setMaximized(true);
    }
}
