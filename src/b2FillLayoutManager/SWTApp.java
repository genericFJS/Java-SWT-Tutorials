package b2FillLayoutManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program demonstrates the FillLayout
 * manager
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */


public class SWTApp {

    private Shell shell;
    private Image castle;

    public SWTApp(Display display) {

        shell = new Shell(display);
        shell.setLayout(new FillLayout());

        shell.setText("FillLayout");

        Device dev = shell.getDisplay();

        try {
            castle = new Image(dev, "res/castle.jpg");
        } catch(Exception e) {
            System.out.println("Cannot load image");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        initUI();
        
        Rectangle rect = castle.getBounds();
        shell.setSize(rect.width, rect.height);

        shell.setLocation(300, 300);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }

    public void initUI() {

        Label label = new Label(shell, SWT.IMAGE_PNG);
        label.setImage(castle);
        label.pack();
    }

    @Override
    public void finalize() {
        System.out.println("disposing");
        castle.dispose();
    }


    public static void main(String[] args) {
        Display display = new Display();
        SWTApp app = new SWTApp(display);
        app.finalize();
        display.dispose();
    }
}
