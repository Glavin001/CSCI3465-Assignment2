import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;


public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create and set up the window.
        JFrame frame = new JFrame("MVC Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        JFrame frameBars = new JFrame("MVC Demo (Bars)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPaneBars = frameBars.getContentPane();
        contentPaneBars.setLayout(new BoxLayout(contentPaneBars, BoxLayout.X_AXIS));
        
        // Add padding
        contentPaneBars.add( Box.createRigidArea(new Dimension(5,0)) );
        
        //
        for (int i = 0; i<10; i++) 
        {
        	//
            GraphModel m = new GraphModel();
            GraphView b = new GraphView();
            b.setModel(m);
            InputView v = new InputView();
            v.setModel(m);
            
            // Add to Bar Graphs
            contentPaneBars.add(b);
            // Add padding
            contentPaneBars.add( Box.createRigidArea(new Dimension(5,0)) );
            
            // Add Input
            contentPane.add(v);
            
        }
        
        // Display the window.
        frame.setSize(200, 500);
        frame.setResizable(true);
        frame.setVisible(true);
        
        // Display the window.
        frameBars.setSize(500, 500);
        frameBars.setResizable(true);
        frameBars.setVisible(true);
        
	}

}
