// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   JetPlane.java                                      :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 22:50:59 by wto               #+#    #+#             //
//   Updated: 2018/11/21 22:50:59 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.aircrafts;

import avaj_launcher.simulator.WeatherTower;
import avaj_launcher.simulator.Coordinates;

public class JetPlane extends Aircraft implements Flyable
{
	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	@Override
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
	}

	@Override
	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}