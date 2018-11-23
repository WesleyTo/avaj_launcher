// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Baloon.java                                        :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 22:50:55 by wto               #+#    #+#             //
//   Updated: 2018/11/21 22:50:55 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates)
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