import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GraphView extends JComponent implements GraphEventObserver 
{
	
	private GraphModel model;
	
	public void setModel(GraphModel m) 
	{
		model = m;
		model.registerObserver(this);
		repaint();
	}

	@Override
	public void valueUpdated() {
		// TODO Auto-generated method stub
		repaint();
	}
	

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		Dimension d = frame.getContentPane().getSize();
		System.out.println(d);
		
		int width = this.getWidth()-1;
		// TODO: Calculate size based off of max value
		int height = (d.height / 10) * model.getValue();
		Point offset = new Point(0, d.height-height);
		
		System.out.println(offset);		
		System.out.println(width);
		System.out.println(height);
		
		//Rectangle2D r = new Rectangle2D.Double((new Double(width))/10, (new Double(height))/10, (new Double(width))*.8, (new Double(height))*.8);
		//this.setBounds((int)offset.x,(int)offset.y,(int)width,(int)height);
		Rectangle2D r = new Rectangle2D.Double(offset.x,offset.y,(int)width,(int)height);
		//Rectangle2D r = new Rectangle2D.Double((double)x - (double) ((int)x), (double) y - (double) ((int)y), width, height);
		//g2.setBackground(getBackground());
		g2.setColor(Color.BLACK);
		//g2.fill3DRect(r.getX(), r.getY(), width, height, true);
		//g2.fill(r);
		g2.draw(r);
	}
	
}
