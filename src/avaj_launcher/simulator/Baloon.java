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
	private static final int[][] update = {
		{2, 0, 4},
		{0, 0, -3},
		{0, 0, -2},
		{0, 0, -15}
	};
	private static final String[] msgs = {
		"This is nice 'balooning' weather...",
		"Visibility is a bit low, better descend.",
		"We'll need to land if this rain keeps up.",
		"It's too cold, we need to go down!",
		"We're crashing! Damn this off-brand 'baloon'!"
	};
	
	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "Baloon";
	}

	@Override
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		String[] weathers = WeatherProvider.getWeatherTypes();
		int i = 0;
		for (i = 0; i < weathers.length; i++)
		{
			if (weather == weathers[i])
			{
				break;
			}
		}
		this.coordinates = new Coordinates(
			this.coordinates.getLongitude() + update[i][0],
			this.coordinates.getLatitude() + update[i][1],
			Aircraft.clampHeight(this.coordinates.getHeight() + update[i][2])
		);
		if (this.coordinates.getHeight() <= 0)
		{
			this.land(weathers[i], msgs[4]);
			this.weatherTower.unregister(this);
		}
		else
		{
			this.log(weathers[i], msgs[i]);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}