package e4FileDialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This example shows a file dialog
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("FileDialog");

        initUI();

        shell.setSize(350, 250);
        shell.setLocation(300, 300);

        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }


    public void initUI() {


        final Label label = new Label(shell, SWT.NONE);
        label.setText("ZetCode Java SWT tutorial");

        label.setLocation(50, 50);
        label.pack();


        shell.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                FileDialog dialog = new FileDialog(shell, SWT.OPEN);

                String[] filterNames = new String[] 
                    {"Java sources", "All Files (*)"};

                String[] filterExtensions = new String[] 
                    {"*.java", "*"};

                dialog.setFilterNames(filterNames);
                dialog.setFilterExtensions(filterExtensions);

                String path = dialog.open();
                if (path != null) {
                    label.setText(path);
                    label.pack();
                }
            }
        });
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}
