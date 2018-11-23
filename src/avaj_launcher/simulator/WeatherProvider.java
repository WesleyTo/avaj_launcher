// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   WeatherProvider.java                               :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 19:24:09 by wto               #+#    #+#             //
//   Updated: 2018/11/21 19:24:10 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider;
	public static final String sun = "SUN";
	public static final String fog = "FOG";
	public static final String rain = "RAIN";
	public static final String snow = "SNOW";
	private static final String[] weather = {
		sun, fog, rain, snow
	};

	private WeatherProvider()
	{
		// Do Nothing
	}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public static String[] getWeatherTypes()
	{
		return weather;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		//float[] dist = {0.24f, 0.27f, 0.31f, 1.0f}; // ~uniform
		float[] dist = {0.24f, 0.29f, 0.35f, 1.0f}; // 40, 30, 20, 10 split
		int x = coordinates.getLongitude();
		int y = coordinates.getLatitude();
		int z = coordinates.getHeight();
		float noise = Noise3D.get(x, y, z);
		for (int i = 0; i < dist.length; i++)
		{
			if (noise <= dist[i])
			{
				return weather[i];
			}
		}
		return weather[3];
	}
}