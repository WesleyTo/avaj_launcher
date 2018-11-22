package avaj_launcher.simulator;

public class Simulator
{
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