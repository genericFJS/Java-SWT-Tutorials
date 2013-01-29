package b3RowLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program demonstrates the RowLayout
 * manager
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;


    public SWTApp(Display display) {

        shell = new Shell(display);
        shell.setText("RowLayout");
        
        initUI();

        shell.pack();
        shell.setLocation(300, 300);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    public void initUI() {

        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 10;
        shell.setLayout(rowLayout);


        Button button1 = new Button(shell, SWT.PUSH);
        button1.setText("Button");
        button1.setLayoutData(new RowData(80, 30));

        Button button2 = new Button(shell, SWT.PUSH);
        button2.setText("Button");
        button2.setLayoutData(new RowData(80, 30));

        Button button3 = new Button(shell, SWT.PUSH);
        button3.setText("Button");
        button3.setLayoutData(new RowData(80, 30));
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}