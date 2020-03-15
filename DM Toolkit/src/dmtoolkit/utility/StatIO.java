package dmtoolkit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import dmtoolkit.entities.StatBlock;
import dmtoolkit.utility.comparators.NameComparator;

public class StatIO
{
	public static final String PATH = "./out/dbOut.txt";
	private static Scanner scan;

	public static ObservableLinkedList<StatBlock> buildStats() throws FileNotFoundException
	{
		ObservableLinkedList<StatBlock> statBlocks = new ObservableLinkedList<StatBlock>();
		File fin = new File(PATH);
		scan = new Scanner(fin);
		scan.useDelimiter("\\s\\|\\s");
		int total = Integer.parseInt(scan.next().trim());
		for (int i = 0; i < total; i++)
		{
			String name = scan.next();
			String type = scan.next();
			String alignment = scan.next();
			int ac = Integer.parseInt(scan.next());
			int hp = Integer.parseInt(scan.next());
			int walkingSpeed = Integer.parseInt(scan.next());
			int swimmingSpeed = Integer.parseInt(scan.next());
			int climbingSpeed = Integer.parseInt(scan.next());
			int flyingSpeed = Integer.parseInt(scan.next());
			int str = Integer.parseInt(scan.next());
			int dex = Integer.parseInt(scan.next());
			int con = Integer.parseInt(scan.next());
			int intl = Integer.parseInt(scan.next());
			int wis = Integer.parseInt(scan.next());
			int cha = Integer.parseInt(scan.next());
			String[] saves = scan.next().split(" & ");
			if (saves.length == 0)
				saves = Arrays.asList("").toArray(saves);
			String[] skills = scan.next().split(" & ");
			if (skills.length == 0)
				skills = Arrays.asList("").toArray(skills);
			String[] damageResistences = scan.next().split(" & ");
			if (damageResistences.length == 0)
				damageResistences = Arrays.asList("").toArray(damageResistences);
			String[] damageImmunities = scan.next().split(" & ");
			if (damageImmunities.length == 0)
				damageImmunities = Arrays.asList("").toArray(damageImmunities);
			String[] conditionImmunities = scan.next().split(" & ");
			if (conditionImmunities.length == 0)
				conditionImmunities = Arrays.asList("").toArray(conditionImmunities);
			String[] senses = scan.next().split(" & ");
			if (senses.length == 0)
				senses = Arrays.asList("").toArray(senses);
			String[] languages = scan.next().split(" & ");
			if (languages.length == 0)
				languages = Arrays.asList("").toArray(languages);
			double cr = Double.parseDouble(scan.next());
			String[] properties = scan.next().split(" & ");
			if (properties.length == 0)
				properties = Arrays.asList("").toArray(properties);
			String[] actions = scan.next().split(" & ");
			if (actions.length == 0)
				actions = Arrays.asList("").toArray(actions);
			String[] legendaryActions = scan.next().split(" & ");
			if (legendaryActions.length == 0)
				legendaryActions = Arrays.asList("").toArray(legendaryActions);
			String imgPath = scan.next();
			boolean custom = Boolean.parseBoolean(scan.next());
			String lore = scan.next();
			statBlocks.add(new StatBlock(name, type, alignment, ac, hp, walkingSpeed, swimmingSpeed, climbingSpeed, flyingSpeed, str, dex, con, intl, wis, cha, saves, skills, damageResistences, damageImmunities, conditionImmunities, senses, languages, cr, properties, actions, legendaryActions, imgPath, custom, lore.trim()));
			scan.next();
		}
		statBlocks.sort(new NameComparator());
		return statBlocks;
	}

	public static void toDB(final ObservableLinkedList<StatBlock> list) throws IOException
	{
		File fout = new File("./out/dbOut.txt");
		fout.createNewFile();
		PrintStream ps = new PrintStream(fout);
		ps.append(list.size() + " | ");
		for (StatBlock sb : list)
		{
			ps.append(sb.getName() + " | ");
			ps.append(sb.getType() + " | ");
			ps.append(sb.getAlignment() + " | ");
			ps.append(sb.getAc() + " | ");
			ps.append(sb.getHp() + " | ");
			ps.append(sb.getWalkSpeed() + " | ");
			ps.append(sb.getSwimSpeed() + " | ");
			ps.append(sb.getClimbSpeed() + " | ");
			ps.append(sb.getFlySpeed() + " | ");
			ps.append(sb.getStr() + " | ");
			ps.append(sb.getDex() + " | ");
			ps.append(sb.getCon() + " | ");
			ps.append(sb.getIntl() + " | ");
			ps.append(sb.getWis() + " | ");
			ps.append(sb.getCha() + " | ");
			for (String s : sb.getSaves())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getSkills())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getDamageResistences())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getDamageImmunities())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getConditionImmunities())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getSenses())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getLanguages())
				ps.append(s + " & ");
			ps.append(" | ");
			ps.append(sb.getCr() + " | ");
			for (String s : sb.getProperties())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getActions())
				ps.append(s + " & ");
			ps.append(" | ");
			for (String s : sb.getLegendaryActions())
				ps.append(s + " & ");
			ps.append(" | ");
			ps.append(sb.getImgPath() + " | ");
			ps.append(sb.isCustom() + " | ");
			ps.append(sb.getLore() + " | ");
			ps.append("\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\tEND STAT - " + sb.getName() + "\n\n\n\n\n\n\n\n\n" + " | ");
		}
		ps.close();
	}
}
