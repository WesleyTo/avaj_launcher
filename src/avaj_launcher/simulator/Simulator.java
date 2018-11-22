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
