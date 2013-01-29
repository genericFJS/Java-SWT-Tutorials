package d5SimpleToolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * ZetCode Java SWT tutorial
 *
 * This program creates a simple toolbar
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */


public class SWTApp {

    private Shell shell;
    private Image newi;
    private Image opei;
    private Image quii;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("Simple toolbar");

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

        Device dev = shell.getDisplay();

        try {
            newi = new Image(dev, "res/new.png");
            opei = new Image(dev, "res/open.png");
            quii = new Image(dev, "res/quit.png");

        } catch (Exception e) {
            System.out.println("Cannot load images");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ToolBar toolBar = new ToolBar(shell, SWT.BORDER);

        ToolItem item1 = new ToolItem(toolBar, SWT.PUSH);
        item1.setImage(newi);

        ToolItem item2 = new ToolItem(toolBar, SWT.PUSH);
        item2.setImage(opei);

        new ToolItem(toolBar, SWT.SEPARATOR);

        ToolItem item3 = new ToolItem(toolBar, SWT.PUSH);
        item3.setImage(quii);

        toolBar.pack();

        item3.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}