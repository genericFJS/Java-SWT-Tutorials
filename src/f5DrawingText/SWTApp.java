package f5DrawingText;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * ZetCode Java SWT tutorial
 *
 * This program draws text
 * on the window
 *
 * @author jan bodnar
 * website zetcode.com
 * last modified June 2009
 */

public class SWTApp {

    Shell shell;

    public SWTApp(Display display) {

        shell = new Shell(display);

        shell.addPaintListener(new LyricsExamplePaintListener());

        shell.setText("Soulmate");
        shell.setSize(380, 300);
        shell.setLocation(300, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private class LyricsExamplePaintListener implements PaintListener {

        public void paintControl(PaintEvent e) {

            drawLyrics(e);
            e.gc.dispose();
        }
    }

    private void drawLyrics(PaintEvent e) {
        e.gc.setAntialias(SWT.ON);

        Font font = new Font(e.display, "Vivaldii", 25, SWT.NORMAL);
        Color color = new Color(e.display, 25, 25, 25);

        e.gc.setForeground(color);
        e.gc.setFont(font);

        e.gc.drawText("Most relationships seem so transitory", 20, 30);
        e.gc.drawText("They're good but not the permanent one", 20, 60);
        e.gc.drawText("Who doesn't long for someone to hold", 20, 120);
        e.gc.drawText("Who knows how to love without being told", 20, 150);
        e.gc.drawText("Somebody tell me why I'm on my own", 20, 180);
        e.gc.drawText("If there's a soulmate for everyone", 20, 210);


        font.dispose();
    }

    public static void main(String[] args) {
        Display display = new Display();
        new SWTApp(display);
        display.dispose();
    }
}