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

import avaj_launcher.exceptions.ScenarioException;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Simulator
{
	private static HashSet<Flyable> aircrafts = new HashSet<Flyable>();

	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			int line_count = 2;
			try
			{
				String line;
				int num_simulations;
				Flyable craft;
				if (args[0].isEmpty())
				{
					throw new FileNotFoundException("Filename cannot be blank");
				}
				FileReader file = new FileReader(args[0]);
				BufferedReader scenario = new BufferedReader(file);
				line = scenario.readLine();
				num_simulations = Validator.validateNumSimulations(line);
				while ((line = scenario.readLine()) != null)
				{
					String[] sim_args = line.split(" ");
					Validator.validateLine(sim_args, line_count);
					craft = AircraftFactory.newAircraft(
						sim_args[0],
						sim_args[1],
						Integer.parseInt(sim_args[2]),
						Integer.parseInt(sim_args[3]),
						Integer.parseInt(sim_args[4])
					);
					aircrafts.add(craft);
					line_count++;
				}
			}
			catch (ScenarioException e)
			{
				System.out.println(e);
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e);
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
			catch (NumberFormatException e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("usage: java simulator <scenario>");
		}
	}
}
