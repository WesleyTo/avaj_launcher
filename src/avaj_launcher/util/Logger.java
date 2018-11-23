// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Logger.java                                        :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/23 01:33:18 by wto               #+#    #+#             //
//   Updated: 2018/11/23 01:33:18 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.util;

import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
	private static Logger logger;
	private static final String output = "simulation.txt";
	private static FileWriter file;

	private Logger()
	{
		try
		{
			file = new FileWriter(output);
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}

	public static Logger getLogger()
	{
		if (logger == null)
			logger = new Logger();
		return logger;
	}

	public void write(String msg) throws IOException
	{
		if (file == null)
		{
			throw new IOException(String.format("File '%s' has already been closed for writing", output));
		}
		else
		{
			try
			{
				file.write(msg);
				file.write(System.lineSeparator());
			}
			catch (IOException e)
			{
				System.out.println(e);
				System.exit(1);
			}
		}
	}

	public void close()
	{
		try
		{
			if (file != null)
			{
				file.close();
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
}