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
import avaj_launcher.exceptions.LoggerException;
import avaj_launcher.exceptions.ExceptionHandler;
import avaj_launcher.util.Logger;
import avaj_launcher.util.Validator;
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
				WeatherTower tower = new WeatherTower();
				Flyable craft;
				Logger log = Logger.getLogger();
				log.setStdOut(true);
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
				for (Flyable aircraft : aircrafts)
				{
					aircraft.registerTower(tower);
				}
				for (int i = 0; i < num_simulations; i++)
				{
					log.writeLn();
					if (tower.numObservers() == 0)
					{
						log.write("ALL CRAFTS LANDED");
						break;
					}
					tower.conditionsChanged();
				}
				log.close();
			}
			catch (ScenarioException e)
			{
				ExceptionHandler.exit(e);
			}
			catch (LoggerException e)
			{
				ExceptionHandler.exit(e);
			}
			catch (FileNotFoundException e)
			{
				ExceptionHandler.exit(e);
			}
			catch (IOException e)
			{
				ExceptionHandler.exit(e);
			}
			catch (NumberFormatException e)
			{
				ExceptionHandler.exit(e);
			}
		}
		else
		{
			System.out.println("usage: java simulator <scenario>");
		}
	}
}
