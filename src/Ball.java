import java.awt.*;

public class Ball {
    private int x, y, xVelocity, yVelocity;
    private final int DIAMETER = 20;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        xVelocity = 3;
        yVelocity = 3;
    }

    public void move(Paddle p1, Paddle p2) {
        x += xVelocity;
        y += yVelocity;

        // Bounce off top and bottom
        if (y <= 0 || y >= 460) {
            yVelocity = -yVelocity;
        }

        // Bounce off paddles
        if (getBounds().intersects(p1.getBounds()) || getBounds().intersects(p2.getBounds())) {
            xVelocity = -xVelocity;
        }

        // Reset ball if it goes out of bounds
        if (x <= 0 || x >= 680) {
            x = 350;
            y = 250;
            xVelocity = -xVelocity;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
