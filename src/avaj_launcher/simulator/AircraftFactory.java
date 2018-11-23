// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   AircraftFactory.java                               :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 21:37:22 by wto               #+#    #+#             //
//   Updated: 2018/11/21 21:37:22 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AircraftFactory
{
	private static final String baloon = "Baloon";
	private static final String heli = "Helicopter";
	private static final String jet = "JetPlane";
	public static final ArrayList<String> aircrafts = new ArrayList<String>() {{
      add(baloon);
      add(heli);
      add(jet);
	}};

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates c = new Coordinates(longitude, latitude, height);
		Flyable craft = null;
		switch(type)
		{
			case baloon:
				craft = new Baloon(name, c);
				break;
			case heli:
				craft = new Helicopter(name, c);
				break;
			case jet:
				craft = new JetPlane(name, c);
				break;
		}
		return craft;
	}
}