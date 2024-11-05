import java.awt.*;

public class Paddle {
    private int x, y, yVelocity;
    private final int WIDTH = 10, HEIGHT = 60, SPEED = 5;
    private boolean up = false, down = false;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void move() {
        if (up && y > 0) {
            yVelocity = -SPEED;
        } else if (down && y < 440) {
            yVelocity = SPEED;
        } else {
            yVelocity = 0;
        }
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
