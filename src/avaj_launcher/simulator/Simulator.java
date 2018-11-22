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

import avaj_launcher.aircrafts.Flyable;
import avaj_launcher.aircrafts.AircraftFactory;
import avaj_launcher.exceptions.ScenarioException;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Simulator
{
	private static HashSet<Flyable> aircrafts = new HashSet<Flyable>();

	public static int validateNumSimulations(String line) throws ScenarioException
	{
		if (line != null)
		{
			String[] temp = line.split(" ");
			if (temp.length != 1)
			{
				throw new ScenarioException(String.format("First line of scenario contains too many parameters (%d) instead of (1)", temp.length));
			}
			int num_simulations = Integer.parseInt(temp[0]);
			if (num_simulations <= 0)
			{
				throw new ScenarioException(String.format("Scenario must contain a positive, non-zero number of simulations (got %d)", num_simulations));
			}
			return num_simulations;
		}
		else
		{
			throw new ScenarioException("Scenario file is empty");
		}
	}

	public static void validateLine(String[] sim_args, int line_count) throws ScenarioException, NumberFormatException
	{
		if (sim_args.length != 5)
		{
			throw new ScenarioException(String.format("Line %d is malformed and contains %d parameters instead of 5", line_count, sim_args.length));
		}
		if (!AircraftFactory.aircrafts.contains(sim_args[0]))
		{
			throw new ScenarioException(String.format("Line %d aircraft type is unrecognized type '%s'", line_count, sim_args[0]));
		}
		if (Integer.parseInt(sim_args[2]) < 0)
		{
			throw new ScenarioException(String.format("Line %d longitude is negative", line_count));
		}
		if (Integer.parseInt(sim_args[3]) < 0)
		{
			throw new ScenarioException(String.format("Line %d latitude is negative", line_count));
		}
		if (Integer.parseInt(sim_args[4]) < 0)
		{
			throw new ScenarioException(String.format("Line %d height is negative", line_count));
		}
	}

	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			int line_count = 2;
			try
			{
				String line;
				int num_simulations;
				if (args[0].isEmpty())
				{
					throw new FileNotFoundException("Filename cannot be blank");
				}
				FileReader file = new FileReader(args[0]);
				BufferedReader scenario = new BufferedReader(file);
				line = scenario.readLine();
				num_simulations = validateNumSimulations(line);
				while ((line = scenario.readLine()) != null)
				{
					String[] sim_args = line.split(" ");
					Simulator.validateLine(sim_args, line_count);
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
