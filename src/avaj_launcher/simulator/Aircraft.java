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

import avaj_launcher.util.Logger;
import java.io.IOException;

public abstract class Aircraft
{
	protected String type;
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static Logger log = Logger.getLogger();
	private static long idCounter = 0;

	protected void log(String s)
	{
		String msg = String.format(
			"%s: %s %s",
			this.toString(),
			this.coordinates.toString(), s
		);
		try
		{
			log.write(msg);
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		System.out.println(msg);
	}

	protected void land(String s)
	{
		String msg = String.format(
			"%s: %s caused the craft to land",
			this.toString(), s
		);
		try
		{
			log.write(msg);
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		System.out.println(msg);
	}

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

	public String toString()
	{
		return String.format(
			"%s#%s(%d)",
			this.type,
			this.name,
			this.id
		);
	}
}
