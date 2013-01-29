package g1Nibbles;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * In this code example, we create
 * a Nibbles game clone
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */


public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("Nibbles");

        initUI();

        shell.setSize(305, 330);
        shell.setLocation(300, 300);
        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    public void initUI() {

        FillLayout layout = new FillLayout();
        shell.setLayout(layout);

        new Board(shell);
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}
