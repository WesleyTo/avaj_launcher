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

import avaj_launcher.exceptions.LoggerException;
import avaj_launcher.exceptions.ExceptionHandler;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
	private static Logger logger;
	private static final String output = "simulation.txt";
	private static FileWriter file;
	private boolean stdOut = false;

	private Logger() throws LoggerException
	{
		try
		{
			file = new FileWriter(output);
		}
		catch (IOException e)
		{
			throw new LoggerException(String.format("Could not open file '%s' for logging", output));
		}
	}

	public static Logger getLogger()
	{
		if (logger == null)
			try
			{
				logger = new Logger();
			}
			catch (LoggerException e)
			{
				ExceptionHandler.exit(e);
			}
		return logger;
	}

	public void write(String msg) throws LoggerException
	{
		if (file == null)
		{
			throw new LoggerException(String.format("File '%s' has already been closed for writing", output));
		}
		else
		{
			try
			{
				file.write(msg);
				file.write(System.lineSeparator());
				if (stdOut)
				{
					System.out.println(msg);
				}
			}
			catch (IOException e)
			{
				throw new LoggerException(String.format("Could not write to file '%s'", output));
			}
		}
	}

	public void writeLn() throws LoggerException
	{
		this.write("");
	}

	public void close() throws LoggerException
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
			throw new LoggerException(String.format("Could not close log file '%s'", output));
		}
	}

	public void setStdOut(boolean b)
	{
		this.stdOut = b;
	}
}