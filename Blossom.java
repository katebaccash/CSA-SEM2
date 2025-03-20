import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 *  A Blossom Actor which is like a flower but disapears after its lifetime
 * 	is over. Blossom's are placed by Jumper bugs.
 */
public class Blossom extends Flower {
	private int lifeTime;
	private int steps = 0;
	
	public Blossom() {
		super(Color.GREEN);
		lifeTime = 10;
	}
	
	public Blossom(int life) {
		super(Color.GREEN);
		lifeTime = life;
	}
	
	public void act() {
		steps++;
		if(steps >= lifeTime)
			removeSelfFromGrid();
		
		double DARKENING_FACTOR = 0.05;
		Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
	}
}
