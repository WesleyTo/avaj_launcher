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

public class Tower
{
	private HashSet<Flyable> observers = new HashSet<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}

	protected void conditionsChanged()
	{
		for (Flyable craft : observers)
		{
			craft.updateConditions();
		}
	}
}
