/*Author Name: Tran Nguyen
 * Date: 1/11/2022
 * Program Name: Nguyenn_Drone
 * Purpose: Simulation using number to move the drone in x,y,z location
 */
import java.util.Scanner;


public class Drone {
	private int x,y,z;
	private int direction;
	
	// Create variables for position
	public Drone() {
		x = 0;
		y = 0;
		z = 0;
		direction = 0;
		
	}
	// Declare the drone position
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	// Get and Set for position
	public void moveUp(int spaces) {
		z += spaces;
	}
	public void moveDown(int spaces) {
		z -= spaces;
	}
	// Method to move the drone up and down by given spaces
	public void forward(int spaces) {
		if (direction == 0) {
			y += spaces;
		} else if (direction == 1){
			x += spaces;
		} else if (direction == 2) {
			y -= spaces;
		} else {
			x -= spaces;
		}
	}
	public void backward(int spaces) {
		if (direction == 0) {
			y -= spaces;
		} else if (direction == 1){
			x -= spaces;
		} else if (direction == 2) {
			y += spaces;
		} else {
			x += spaces;
		}
	}
	// Method to move the drone forward and backward by given spaces
	public void turnRight() {
		direction = (direction + 1) % 4;
	}
	public void turnLeft() {
		direction -- ;
		if (direction < 0) {
			direction = 3;
		}
	}
	// Method to turn the drone to left or right
	public String checkOrientation() {
		String orientation = "";
		if(z > 0) {
			orientation = "North";
		}else if (z < 0) {
			orientation = "South";
		}else if (x < 0) {
			orientation = "West";
		}else if(x > 0) {
			orientation = "East";
		}else
		{
			orientation = "Center";
		}
		return orientation;
	}
	// Condition for the orientation
	
	@Override
	public String toString() {
		
		return "Drone is at x = " + x + ", y = " + y + ", z = " + z;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drone drone = new Drone();
		Scanner scanner = new Scanner(System.in);
		String ch = "";
		while (!ch.equalsIgnoreCase("8"))
		{
			// Print the menu
			System.out.println("1 - Move Forward");
			System.out.println("2 - Move Backward");
			System.out.println("3 - Move Up");
			System.out.println("4 - Move Down");
			System.out.println("5 - Move Right");
			System.out.println("6 - Move Left");
			System.out.println("7 - Display Position");
			System.out.println("8 - Exit");
			System.out.println("Your choice: ");
			ch = scanner.next();
			// The condition for the menu with specific given space.
			if (ch.equalsIgnoreCase("1")) {
				drone.forward(1);
				System.out.println("You have move forward");
			} else if (ch.equalsIgnoreCase("2")) {
				drone.backward(1);
				System.out.println("You have move backward");
			} else if (ch.equalsIgnoreCase("3")) {
				drone.moveUp(1);
				System.out.println("You have move up");
			} else if (ch.equalsIgnoreCase("4")) {
				drone.moveDown(1);
				System.out.println("You have move down");
			} else if (ch.equalsIgnoreCase("5")) {
				drone.turnRight();
				System.out.println("You have turn right");
			} else if (ch.equalsIgnoreCase("6")) {
				drone.turnLeft();
				System.out.println("You have turn left");
			} else if (ch.equalsIgnoreCase("7")) {
				System.out.print("\n" + drone + "\n" );
				System.out.println("Orentation= "+drone.checkOrientation());
				
			}
		}
		




	}

}
