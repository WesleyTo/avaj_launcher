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

import java.util.HashSet;

public abstract class Tower
{
	private HashSet<Flyable> observers = new HashSet<Flyable>();
	private HashSet<Flyable> ignored = new HashSet<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		ignored.add(flyable);
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
