import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongGame extends JPanel implements KeyListener, Runnable {

    private Paddle player1, player2;
    private Ball ball;
    private boolean gameRunning;

    public PongGame() {
        this.setFocusable(true);
        this.addKeyListener(this);

        player1 = new Paddle(30, 150);
        player2 = new Paddle(640, 150);
        ball = new Ball(350, 250);
        gameRunning = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw paddles
        player1.draw(g);
        player2.draw(g);
        // Draw ball
        ball.draw(g);
    }

    @Override
    public void run() {
        while (gameRunning) {
            player1.move();
            player2.move();
            ball.move(player1, player2);
            repaint();
            try {
                Thread.sleep(10); // Control speed of the game
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            player1.setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2.setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            player1.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2.setDown(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No actions needed here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame game = new PongGame();
        frame.add(game);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(game).start();
    }
}
