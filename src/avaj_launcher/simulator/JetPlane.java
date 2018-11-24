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

package avaj_launcher.simulator;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	private static final int[][] update = {
		{0, 10, 2},
		{0, 1, 0},
		{0, 5, 0},
		{0, 0, -7}
	};
	private static final String[] msgs = {
		"Beautiful weather for jetsetting.",
		"Can't see, good thing we have radar.",
		"It's OK. We're not some dumb 'baloon.'",
		"Better initiate a controlled descent.",
		"We've landed safely, ladies and gents."
	};
	
	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "JetPlane";
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
			this.coordinates.getHeight() + update[i][2]
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