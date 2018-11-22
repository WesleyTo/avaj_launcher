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
	private WeatherProvider weatherProvider;
	private String[] weather;

	private WeatherProvider()
	{
		// Do Nothing
	}

	public WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		return "";
	}
}