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

package avaj_launcher.simulator;

public class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected WeatherTower weatherTower;

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
}
