// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Aircraft.java                                      :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 22:33:04 by wto               #+#    #+#             //
//   Updated: 2018/11/21 22:33:04 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.aircrafts;

import avaj_launcher.simulator.Coordinates;
import avaj_launcher.simulator.WeatherTower;

public abstract class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId()
	{
		return idCounter++;
	}

	abstract void updateConditions();
	abstract void registerTower(WeatherTower weatherTower);
}