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

public abstract class Aircraft
{
	protected String type;
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected void log(String s)
	{
		String msg = String.format(
			"%s#%s(%d) %s %s",
			this.type,
			this.name,
			this.id,
			this.coordinates.toString(),
			s
		);
		System.out.println(msg);
	}

	protected void land(String s)
	{

		String msg = String.format(
			"%s#%s(%d) %s caused the craft to land",
			this.type,
			this.name,
			this.id,
			s
		);
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
}
