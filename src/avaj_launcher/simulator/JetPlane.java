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
	
	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "JetPlane";
	}

	@Override
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		int i = 3;
		if (weather == WeatherProvider.sun)
		{
			i = 0;
		}
		else if (weather == WeatherProvider.fog)
		{
			i = 1;
		}
		else if (weather == WeatherProvider.rain)
		{
			i = 2;
		}
		this.coordinates = new Coordinates(
			this.coordinates.getLongitude() + update[i][0],
			this.coordinates.getLatitude() + update[i][1],
			this.coordinates.getHeight() + update[i][2]
		);
		if (this.coordinates.getHeight() <= 0)
		{
			this.land(WeatherProvider.getWeatherTypes()[i]);
			this.weatherTower.unregister(this);
		}
		else
		{
			this.log(WeatherProvider.getWeatherTypes()[i]);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}