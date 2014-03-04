import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


public class InputView extends JTextField implements GraphEventObserver, ActionListener
{

	private GraphModel model;
	
	public InputView() 
	{
		super();
		addActionListener(this);	
	}

	public void setModel(GraphModel m)
	{
		model = m;
		model.registerObserver(this);
		forceUpdate();
	}
	
	@Override
	public void valueUpdated() 
	{
		forceUpdate();
	}
	
	private void forceUpdate()
	{
		int v = model.getValue();
		String t = new Integer(v).toString();
		this.setText(t);
	}

    public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		String t = this.getText();
		try
		{
			int v = Integer.parseInt(t);
			model.setValue(v);
		} catch (NumberFormatException err) {
			model.setValue(0);
		}
	}
	
}
