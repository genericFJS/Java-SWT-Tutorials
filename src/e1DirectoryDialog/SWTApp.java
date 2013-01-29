package e1DirectoryDialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This example shows a directory dialog
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("DirectoryDialog");

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


        final Label status = new Label(shell, SWT.BORDER);
        status.setText("Ready");
        FormLayout layout = new FormLayout();
        shell.setLayout(layout);

        FormData labelData = new FormData();
        labelData.left = new FormAttachment(0);
        labelData.right = new FormAttachment(100);
        labelData.bottom = new FormAttachment(100);
        status.setLayoutData(labelData);

        shell.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                DirectoryDialog dialog = new DirectoryDialog(shell);
                String path = dialog.open();
                if (path != null)
                    status.setText(path);
            }

        });
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}