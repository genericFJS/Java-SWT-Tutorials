package d4PopupMenu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program creates a popup
 * menu
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("Popup menu");

        initUI();

        shell.setSize(300, 250);
        shell.setLocation(300, 300);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public void initUI() {

        Menu menu = new Menu(shell, SWT.POP_UP);

        MenuItem minItem = new MenuItem(menu, SWT.PUSH);
        minItem.setText("Minimize");

        minItem.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.setMinimized(true);
            }
        });


        MenuItem exitItem = new MenuItem(menu, SWT.PUSH);
        exitItem.setText("Exit");

        exitItem.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
        });

        shell.setMenu(menu);

    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}