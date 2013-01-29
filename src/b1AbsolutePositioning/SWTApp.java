package b1AbsolutePositioning;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * In this program, we position two
 * buttons using absolute coordinates
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;


    public SWTApp(Display display) {

        shell = new Shell(display);
        shell.setText("Absolute");

        initUI();

        shell.setSize(250, 200);
        shell.setLocation(300, 300);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    public void initUI() {
        Button button1 = new Button(shell, SWT.PUSH);
        button1.setText("Button");
        button1.setBounds(20, 50, 80, 30);

        Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("Button");
        button2.setSize(80, 30);
        button2.setLocation(50, 100);
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}