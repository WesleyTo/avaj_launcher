// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Simulator.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 19:09:37 by wto               #+#    #+#             //
//   Updated: 2018/11/21 19:09:40 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.simulator;

import java.util.HashSet;

public class Simulator
{
	private static HashSet<Flyable> aircrafts = new HashSet<Flyable>();

	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			System.out.println(args[0]);
		}
		else
		{
			System.out.println("usage: java simulator <scenario>");
		}
	}
}
