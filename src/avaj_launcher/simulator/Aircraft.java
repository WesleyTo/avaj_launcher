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
import avaj_launcher.exceptions.LoggerException;
import avaj_launcher.exceptions.ExceptionHandler;

public abstract class Aircraft
{
	protected String type;
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static Logger log = Logger.getLogger();
	private static long idCounter = 0;

	private String makeMsg(String weather, String s)
	{
		return String.format(
			"%s: %s [%s] %s",
			this.toString(),
			this.coordinates.toString(), weather, s
		);
	}

	protected void log(String weather, String s)
	{
		String msg = this.makeMsg(weather, s);
		try
		{
			log.write(msg);
		}
		catch (LoggerException e)
		{
			ExceptionHandler.exit(e);
		}
	}

	protected void land(String weather, String s)
	{
		String msg = this.makeMsg(weather, s);
		try
		{
			log.write(msg);
		}
		catch (LoggerException e)
		{
			ExceptionHandler.exit(e);
		}
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
