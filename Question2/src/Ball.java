import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 
 */
public class Ball extends JComponent implements Runnable {
	
	private Point center;
	private double radius;
	private Point velocity;
	
	private static final int UPDATE_RATE = 30; // Number of refresh per second
	
	public Ball(Point c)
	{
		center = c;
		// Random velocity
		velocity = new Point((int)(Math.random()*20-10), (int)(Math.random()*20-10));
		radius = 20;
		//
		repaint();
	}
	
	// Draw a Circle
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    //Convert to Java2D Object
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Create the circle
	    Ellipse2D circle = new Ellipse2D.Double();
	    circle.setFrameFromCenter(radius, radius, 2*radius, 2*radius);
	    this.setBounds((int) center.getX(), (int) center.getY(), (int) (radius*4), (int) (radius*4));
	    
	    //System.out.println(center);
	    
	    // Draw it
	    g2.draw(circle);
	    //g2.fill(circle);
	}// end paintComponent

	protected void move()
	{
		center.x += velocity.x;
		center.y += velocity.y;
	}
	
	protected void collisions()
	{
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		Dimension d = frame.getContentPane().getSize();
		
		// Check top
		if (0 > (center.getY() + 0*radius))
		{
			velocity.y = Math.abs(velocity.y); // Velocity to DOWN
			// Fix position
			center.y = (int) (0+0*radius);
		}
		// Check bottom
		else if (d.getHeight() < (center.getY() + 2*radius) ) 
		{
			velocity.y = -1 * Math.abs(velocity.y); // Velocity to UP
			// Fix position
			center.y = (int) (d.getHeight() - 2*radius);
		}
		
		// Check left
		if (0 > (center.getX() + 0*radius))
		{
			velocity.x = Math.abs(velocity.x); // Velocity to RIGHT
			// Fix position
			center.x = (int) (0+0*radius);
		}
		// Check right
		else if (d.getWidth() < (center.getX() + 2*radius) ) 
		{
			velocity.x = -1 * Math.abs(velocity.x); // Velocity to LEFT
			// Fix position
			center.x = (int) (d.getWidth() - 2*radius);
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) 
		{
			//
			move();
			
			// 
			collisions();
			
			// Refresh the display
            repaint(); // Callback paintComponent()
            // Delay for timing control and give other threads a chance
            try {
               Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
            } catch (InterruptedException ex) { }
		}
	}
	
}
