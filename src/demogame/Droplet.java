package demogame;

import java.awt.Image;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import javax.imageio.ImageIO;


public class Droplet {
	 private int x;
	    private int y;
	    private int speed;
	    private Image image;

	    public Droplet() {
	        Random random = new Random();
	        this.x = random.nextInt(700);
	        this.y = 0;
	        this.speed = random.nextInt(10) + 1;
	        try {
	            this.image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("droplet_icon.png")))
	                    .getScaledInstance(48, 48, Image.SCALE_DEFAULT);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public boolean isBetween(int x, int y) {
	        return x >= this.x && x <= this.x + this.image.getWidth(null) && y >= this.y && y <= this.y + this.image.getHeight(null);
	    }

	    public boolean isBetween(int x1, int y1, int x2, int y2) {
	        return x1 >= this.x && x1 <= this.x + this.image.getWidth(null) && y1 >= this.y && y1 <= this.y + this.image.getHeight(null)
	                || x2 >= this.x && x2 <= this.x + this.image.getWidth(null) && y2 >= this.y && y2 <= this.y + this.image.getHeight(null);
	    }
	    /*
	    public boolean isBetween(Ball ball) {
	        return isBetween(ball.getX(), ball.getY(), ball.getX() + ball.getImage().getWidth(null), ball.getY() + ball.getImage().getHeight(null));
	    }
*/
	    public void move() {
	        this.y += speed;
	    }

	    public void changeSpeed(int speed) {
	        this.speed = speed;
	    }

	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	    public Image getImage() {
	        return image;
	    }

	    public void reset() {
	        Random random = new Random();
	        this.x = random.nextInt(700);
	        this.y = 0;
	    }
}
