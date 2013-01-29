package a2Tooltipp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * In this program, we show a tooltip
 * 
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {


    public SWTApp(Display display) {
        
        Shell shell = new Shell(display);

        shell.setText("Tooltip");
        shell.setLocation(300, 300);
        shell.setToolTipText("This is a window");

        shell.setSize(250, 200);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }        
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}
