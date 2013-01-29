package g1Nibbles;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Board extends Canvas {

    private final int WIDTH = 300;
    private final int HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    private Image ball;
    private Image apple;
    private Image head;

    private Display display;
    private Shell shell;
    private Runnable runnable;



    public Board(Shell shell) {

        super(shell, SWT.NULL);

        this.shell = shell;
        display = shell.getDisplay();

        setSize(WIDTH, HEIGHT);

        this.addPaintListener(new BoardPaintListener());
        this.addKeyListener(new BoardKeyListener());

        Color col = new Color(shell.getDisplay(), 0, 0, 0);

        this.setBackground(col);
        col.dispose();

        ImageData iib = new ImageData("res/dot.png");
        ball = new Image(display, iib);

        ImageData iia = new ImageData("res/apple.png");
        apple = new Image(display, iia);
        
        ImageData iih = new ImageData("res/head.png");
        head = new Image(display, iih);

        initGame(shell.getDisplay());
    }


    public void initGame(final Display display) {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z*10;
            y[z] = 50;
        }

        locateApple();

        runnable = new Runnable() {
          public void run() {
             if (inGame) {
                checkApple();
                checkCollision();
                move();

            }
            display.timerExec(DELAY, this);
            redraw();
          }
        };

        display.timerExec(DELAY, runnable);
    };


    private class BoardPaintListener implements PaintListener {

        public void paintControl(PaintEvent e) {

            Color col = new Color(shell.getDisplay(), 0, 0, 0);
            e.gc.setBackground(col);
            col.dispose();

            e.gc.setAntialias(SWT.ON);

            if (inGame) {
                drawObjects(e);
            } else {
                gameOver(e);
            }

            e.gc.dispose();

        }
    }


    public void drawObjects(PaintEvent e) {
        e.gc.drawImage(apple, apple_x, apple_y);

        for (int z = 0; z < dots; z++) {
            if (z == 0) {
                e.gc.drawImage(head, x[z], y[z]);
            } else {
                e.gc.drawImage(ball, x[z], y[z]);
            }
        }
    }

    public void gameOver(PaintEvent e) {
        String msg = "Game Over";

        Font font = new Font(e.display, "Helvetica",
                12, SWT.NORMAL);
        Color white = new Color(shell.getDisplay(),
                255, 255, 255);

        Point size = e.gc.textExtent (msg);
                
        e.gc.setForeground(white);
        e.gc.setFont(font);
        e.gc.drawText(msg, (WIDTH - size.x) / 2, (HEIGHT - size.y) / 2);

        font.dispose();
        white.dispose();
        e.gc.dispose();
        display.timerExec(-1, runnable);

    }


    public void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            locateApple();
        }
    }


    public void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (left) {
            x[0] -= DOT_SIZE;
        }

        if (right) {
            x[0] += DOT_SIZE;
        }

        if (up) {
            y[0] -= DOT_SIZE;
        }

        if (down) {
            y[0] += DOT_SIZE;
        }
    }


    public void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] > HEIGHT - DOT_SIZE) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] > WIDTH - DOT_SIZE) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
    }

    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    private class BoardKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(org.eclipse.swt.events.KeyEvent e) {

            int key = e.keyCode;

            if ((key == SWT.ARROW_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == SWT.ARROW_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == SWT.ARROW_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == SWT.ARROW_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }
}