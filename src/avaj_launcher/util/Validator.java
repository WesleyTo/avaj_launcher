// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Validator.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/22 19:21:33 by wto               #+#    #+#             //
//   Updated: 2018/11/22 19:21:35 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.util;

import avaj_launcher.simulator.AircraftFactory;
import avaj_launcher.exceptions.ExceptionHandler;
import avaj_launcher.exceptions.ScenarioException;
import java.lang.StringBuffer;

public class Validator
{
	public static int validateNumSimulations(String line) throws ScenarioException, NumberFormatException
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
			StringBuffer buf = new StringBuffer();
			buf.append("[");
			for (int i = 0; i < sim_args.length; i++)
			{
				buf.append(String.format("\"%s\"%s", sim_args[i], i + 1 == sim_args.length ? "" : ", "));
			}
			buf.append("]");
			throw new ScenarioException(String.format("Line %d is malformed and contains %d parameters instead of 5: %s", line_count, sim_args.length, buf.toString()));
		}
		if (!AircraftFactory.aircrafts.contains(sim_args[0]))
		{
			throw new ScenarioException(String.format("Line %d aircraft type is unrecognized type '%s'", line_count, sim_args[0]));
		}
		if (sim_args[0].isEmpty())
		{
			throw new ScenarioException(String.format("Line %d aircraft type is blank", line_count));
		}
		if (sim_args[1].isEmpty())
		{
			throw new ScenarioException(String.format("Line %d aircraft name is blank", line_count));
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
}