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

package avaj_launcher.aircrafts;

import avaj_launcher.simulator.Coordinates;
import java.util.ArrayList;
import java.util.Arrays;

public class AircraftFactory
{
	public static ArrayList<String> aircrafts = new ArrayList<String>() {{
      add("Baloon");
      add("Helicopter");
      add("JetPlane");
	}};

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates c = new Coordinates(longitude, latitude, height);
		Flyable craft = null;
		switch(type)
		{
			case "Baloon":
				craft = new Baloon(name, c);
				break;
			case "Helicopter":
				craft = new Helicopter(name, c);
				break;
			case "JetPlane":
				craft = new JetPlane(name, c);
				break;
		}
		return craft;
	}
}