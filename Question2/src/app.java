import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create and set up the window.
        JFrame frame = new JFrame("Bouncing Ball Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
        
        // Mouse Click Listener
        contentPane.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
        	   Point p = e.getPoint();
        	   System.out.println(p);
        	   Ball b = new Ball(p);
        	   b.setSize(100, 100);
        	   b.setBounds((int) p.getX(), (int) p.getY(), 200, 200);
        	   contentPane.add(b);
        	   Thread t = new Thread(b);
        	   t.start();
           }
        });
        
        
        // Display the window.
        frame.setSize(300, 200);
        frame.setResizable(true);
        frame.setVisible(true);

	}

}
