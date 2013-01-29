package f4Donut;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program creates a donut shape
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */
public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.addPaintListener(new DonutPaintListener());

        shell.setText("Donut");
        shell.setSize(430, 300);
        shell.setLocation(300, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private class DonutPaintListener implements PaintListener {

        public void paintControl(PaintEvent e) {

            drawDonut(e);

            e.gc.dispose();
        }
    }

    private void drawDonut(PaintEvent e) {
        int w = e.width;
        int h = e.height;

        e.gc.setAntialias(SWT.ON);

        Transform tr = new Transform(e.display);
        tr.translate(w / 2, h / 2);
        e.gc.setTransform(tr);

        for (int rot = 0; rot < 36; rot++) {
            tr.rotate(5f);
            e.gc.drawOval(-125, -40, 250, 80);
            e.gc.setTransform(tr);
        }
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}