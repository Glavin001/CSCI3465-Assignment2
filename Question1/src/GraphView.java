import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GraphView extends JComponent implements GraphEventObserver, MouseListener, MouseMotionListener
{
	
	private GraphModel model;
		
	public void setModel(GraphModel m) 
	{

        addMouseListener(this);
        addMouseMotionListener(this);
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
		int height = model.getValue();
		Point offset = new Point(0, d.height-height);

		Rectangle b = this.getBounds();
		this.setBounds(b.x, b.y, b.width, d.height);

		System.out.println(offset);		
		System.out.println(width);
		System.out.println(height);
		
		Rectangle2D r = new Rectangle2D.Double(offset.x,offset.y,(int)width,(int)height);
		g2.setColor(Color.BLACK);
		g2.draw(r);
		
	}
	
	private void setValueWithPoint(Point p)
	{
		int h = this.getHeight();
		int v = (int) (h - p.getY());
		model.setValue(v);
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("mouseDragged");
		Point p = event.getPoint();
		System.out.println(p);
		setValueWithPoint(p);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
		Point p = event.getPoint();
		System.out.println(p);
		setValueWithPoint(p);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
