import info.gridworld.actor.Bug;
import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

/**
 * 	A Jumper Bug that moves 2 spaces each move. If the space in the direction
 * 	it is facing 2 spaces away is not available, it turns halfway right.
 */
public class Jumper extends Bug {
	
	private int length;
	private int lengthTraveled;
	
	public Jumper() {
		super(Color.BLUE);
		length = 6;
		lengthTraveled = 0;
	}
	
	public Jumper(int len) {
		super(Color.BLUE);
		length = len;
		lengthTraveled = 0;
	}
	
	public void act() {
		Grid<Actor> gr = getGrid();
		boolean noMovesLeft = true;
		for(int i = 0; i < Location.FULL_CIRCLE; i+=45) {
			if(canMove()) {
				noMovesLeft = false;
				turn();
			}
			else
				turn();
		}
		
		if (canMove()) {
            move();
		}
        else if(noMovesLeft) {
			Location loc = getLocation();
			Location next = loc.getAdjacentLocation(getDirection());
			if (gr.isValid(next))
				moveTo(next);
			else
				removeSelfFromGrid();
			
			Blossom flower = new Blossom();
			flower.putSelfInGrid(gr, loc);
			lengthTraveled++;
		}
        else {
            turn();
            lengthTraveled = 0;
		}
	}
	
	public void move() {
		if(lengthTraveled >= length) {
			turn();
			lengthTraveled = 0;
			return;
		}
		
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location adjacent = loc.getAdjacentLocation(getDirection());
        Location next = adjacent.getAdjacentLocation(getDirection());
        
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
		
		Blossom flower = new Blossom((int)(Math.random()*15) + 2);
        flower.putSelfInGrid(gr, loc);
       
        lengthTraveled += 2;
	}
	
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
			
        Location loc = getLocation();
        Location adjacent = loc.getAdjacentLocation(getDirection());
        Location next = adjacent.getAdjacentLocation(getDirection());

        if(gr.isValid(next) && (gr.get(next) == null || (gr.get(next) 
			instanceof Flower && !(gr.get(next) instanceof Blossom))))
            return true;
		return false;
	}
}
