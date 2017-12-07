package step3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Listener02 implements ServletRequestListener {
    
    @Override
    public void requestInitialized(ServletRequestEvent sce) {
        System.out.println("Listener02.requestInitialized()");
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sce) {
        System.out.println("Listener02.requestDestroyed()");
    }
    
}
