package dmtoolkit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dmtoolkit.entities.StatBlock;

public class StatIO
{
	public static final String PATH = "StatBlockDatabase.txt";
	private static Scanner scan;

	public static java.util.LinkedList<StatBlock> buildStats() throws FileNotFoundException
	{
		java.util.LinkedList<StatBlock> statBlocks = new java.util.LinkedList<StatBlock>();
		File fin = new File(PATH);
		scan = new Scanner(fin);
		int total = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < total; i++)
		{
			String name = scan.nextLine();
			String type = scan.nextLine();
			String alignment = scan.nextLine();
			int ac = Integer.parseInt(scan.nextLine());
			int hp = Integer.parseInt(scan.nextLine());
			int walkingSpeed = Integer.parseInt(scan.nextLine());
			int swimmingSpeed = Integer.parseInt(scan.nextLine());
			int climbingSpeed = Integer.parseInt(scan.nextLine());
			int flyingSpeed = Integer.parseInt(scan.nextLine());
			int str = Integer.parseInt(scan.nextLine());
			int dex = Integer.parseInt(scan.nextLine());
			int con = Integer.parseInt(scan.nextLine());
			int intl = Integer.parseInt(scan.nextLine());
			int wis = Integer.parseInt(scan.nextLine());
			int cha = Integer.parseInt(scan.nextLine());
			int numSaves = Integer.parseInt(scan.nextLine());
			String[] saves = new String[numSaves];
			for (int j = 0; j < numSaves; j++)
				saves[j] = scan.nextLine();
			int numSkills = Integer.parseInt(scan.nextLine());
			String[] skills = new String[numSkills];
			for (int j = 0; j < numSkills; j++)
				skills[j] = scan.nextLine();
			int numSenses = Integer.parseInt(scan.nextLine());
			String[] senses = new String[numSenses];
			for (int j = 0; j < numSenses; j++)
				senses[j] = scan.nextLine();
			int numLanguages = Integer.parseInt(scan.nextLine());
			String[] languages = new String[numLanguages];
			for (int j = 0; j < numLanguages; j++)
				languages[j] = scan.nextLine();
			double cr = Double.parseDouble(scan.nextLine());
			int numProperties = Integer.parseInt(scan.nextLine());
			String[] properties = new String[numProperties];
			for (int j = 0; j < numProperties; j++)
				properties[j] = scan.nextLine();
			int numActions = Integer.parseInt(scan.nextLine());
			String[] actions = new String[numActions];
			for (int j = 0; j < numActions; j++)
				actions[j] = scan.nextLine();
			int numLegendaryActions = Integer.parseInt(scan.nextLine());
			String[] legendaryActions = new String[numLegendaryActions];
			for (int j = 0; j < numLegendaryActions; j++)
				legendaryActions[j] = scan.nextLine();
			String imgPath = scan.nextLine();
			boolean custom = Boolean.parseBoolean(scan.nextLine());
			String lore = "";
			while (scan.hasNextLine())
			{
				String next = scan.nextLine();
				if (next.compareToIgnoreCase("(endLore)") != 0)
					lore = lore + next + " ";
			}

			lore = reformatString(lore);
			statBlocks.add(new StatBlock(name, type, alignment, ac, hp, walkingSpeed, swimmingSpeed, climbingSpeed, flyingSpeed, str, dex, con, intl, wis, cha, saves, skills, senses, languages, cr, properties, actions, legendaryActions, imgPath, custom, lore.trim()));
		}
		return statBlocks;
	}

	public static String reformatString(final String in)
	{
		StringBuilder sb = new StringBuilder(in);
		int j = in.length();
		for (int i = 1; i < j; i++)
		{
			if (in.charAt(i) == '\t')
			{
				sb.replace(i - 1, i + 1, "\n\n");
				i++;
			}
		}
		return sb.toString();
	}
}
