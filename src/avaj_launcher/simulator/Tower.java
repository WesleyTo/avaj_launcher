// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Tower.java                                         :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 19:09:00 by wto               #+#    #+#             //
//   Updated: 2018/11/21 19:09:03 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

import avaj_launcher.util.Logger;
import java.util.HashSet;
import java.io.IOException;

public abstract class Tower
{
	private HashSet<Flyable> observers = new HashSet<Flyable>();
	private HashSet<Flyable> ignored = new HashSet<Flyable>();
	private static final Logger log = Logger.getLogger();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		String msg = String.format(
			"Tower says: %s registered",
			flyable.toString()
		);
		System.out.println(msg);
		try
		{
			log.write(msg);
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}

	public void unregister(Flyable flyable)
	{
		ignored.add(flyable);
		String msg = String.format(
			"Tower says: %s unregistered",
			flyable.toString()
		);
		System.out.println(msg);
		try
		{
			log.write(msg);
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}

	public int numObservers()
	{
		return observers.size();
	}

	protected void conditionsChanged()
	{
		for (Flyable craft : observers)
		{
			if (!ignored.contains(craft))
			{
				craft.updateConditions();
			}
		}
		for (Flyable craft : ignored)
		{
			observers.remove(craft);
		}
	}
}
