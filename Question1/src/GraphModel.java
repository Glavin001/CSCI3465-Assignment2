import java.util.ArrayList;


public class GraphModel {

	private int value;
	
	private ArrayList<GraphEventObserver> observers;
	
	public GraphModel() 
	{
		observers = new ArrayList<GraphEventObserver>();
		value = 0;
	}
	
	public void setValue(int v)
	{
		value = v;
		broadcastUpdate();
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void registerObserver(GraphEventObserver i)
	{
		observers.add(i);
	}
	
	private void broadcastUpdate()
	{
		for (GraphEventObserver i : observers)
		{
			i.valueUpdated();
		}
	}

}
