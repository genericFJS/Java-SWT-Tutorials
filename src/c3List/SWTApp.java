package c3List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program shows the List
 * widget
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */


public class SWTApp {

    Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.setText("List");

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


        final Label status = new Label(shell, SWT.BORDER);
        status.setText("Ready");
        
        FormLayout layout = new FormLayout();
        shell.setLayout(layout);

        FormData labelData = new FormData();
        labelData.left = new FormAttachment(0);
        labelData.right = new FormAttachment(100);
        labelData.bottom = new FormAttachment(100);
        status.setLayoutData(labelData);

        final List list = new List(shell, SWT.BORDER);
        
        list.add("Aliens");
        list.add("Capote");
        list.add("Neverending story");
        list.add("Starship troopers");
        list.add("Exorcist");
        list.add("Omen");

        list.addListener(SWT.Selection, new Listener () {
            public void handleEvent (Event e) {
                String[] items = list.getSelection();
                status.setText(items[0]);
            }
        });


        FormData listData = new FormData();
        listData.left = new FormAttachment(shell, 30, SWT.LEFT);
        listData.top = new FormAttachment(shell, 30, SWT.TOP);
        list.setLayoutData(listData);
    }


    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}