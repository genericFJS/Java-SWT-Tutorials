package f3TransparentRectangles;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program draws ten
 * rectangles with different
 * levels of transparency
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    private Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.addPaintListener(new ArcExamplePaintListener());

        shell.setText("Transparent rectangles");
        shell.setSize(590, 120);
        shell.setLocation(300, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private class ArcExamplePaintListener implements PaintListener {

        public void paintControl(PaintEvent e) {

            drawRectangles(e);

            e.gc.dispose();
        }
    }

    private void drawRectangles(PaintEvent e) {

        Color blue = new Color(e.display, 0, 0, 255);
        e.gc.setBackground(blue);

        for (int i = 1; i < 11; i++) {
            e.gc.setAlpha(i * 25);
            e.gc.fillRectangle(50 * i, 20, 40, 40);
        }

        blue.dispose();
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}