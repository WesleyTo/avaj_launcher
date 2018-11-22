package avaj_launcher.simulator;

import java.util.HashSet;

public class Tower
{
	private HashSet<Flyable> observers = new HashSet<Flyable>();

	public void register(Flyable craft)
	{
		observers.add(craft);
	}

	public void unregister(Flyable craft)
	{
		observers.remove(craft);
	}

	protected void conditionsChanged()
	{
		for (Flyable craft : observers)
		{
			craft.updateConditions();
		}
	}
}
