// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Coordinates.java                                   :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 19:16:15 by wto               #+#    #+#             //
//   Updated: 2018/11/21 19:16:15 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getLatitude()
	{
		return this.latitude;
	}

	public int getHeight()
	{
		return this.height;
	}

	public String toString()
	{
		return String.format("(%d, %d, %d)", longitude, latitude, height);
	}
}