package a1Centering;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * In this program, we show a window in
 * the center of the screen
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {


    public SWTApp(Display display) {
       
        Shell shell = new Shell(display);
        shell.setText("Center");
        shell.setSize(250, 200);

        center(shell);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    public void center(Shell shell) {

//    	Doesn't work for Multi-Monitors
        Rectangle bds = shell.getDisplay().getBounds();
        System.out.println(bds);

        Point p = shell.getSize();
        System.out.println(p);

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}
