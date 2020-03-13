package dmtoolkit.utility;

import java.io.File;
import java.util.Scanner;

public class NPC implements Comparable<NPC>{
	private String name, apperance, highAbility, lowAbility, talents, manerisms,
	interactionTraits, ideas, bonds, flawsNSecrets;

	public NPC() {
		this.name = "Default Name";
		this.apperance = this.random("InputFiles/npc-appearance.txt");
		this.highAbility = this.random("InputFiles/npc-abilities-high.txt");
		this.lowAbility = this.random("InputFiles/npc-abilities-low.txt");
		this.talents = this.random("InputFiles/npc-talents.txt");
		this.manerisms = this.random("InputFiles/npc-manerisms.txt");
		this.interactionTraits = this.random("InputFiles/npc-interaction-traits.txt");
		this.ideas = null; //random("InputFiles/npc-ideas.txt");
		this.bonds = this.random("InputFiles/npc-bonds.txt");
		this.flawsNSecrets = this.random("InputFiles/npc-flaws-secrets.txt");
	}
	public String name() {
		return this.name;
	}
	@Override
	public String toString()
	{
		return this.name;
	}

	public String appearance() {
		return this.apperance;
	}
	public String highAbility() {
		return this.highAbility;
	}
	public String lowAbility() {
		return this.lowAbility;
	}
	public String talents() {
		return this.talents;
	}
	public String manerisms() {
		return this.manerisms;
	}
	public String interactionTraits() {
		return this.interactionTraits;
	}
	public String ideas() {
		return this.ideas;
	}
	public String bonds() {
		return this.bonds;
	}
	public String flawsNSecrets() {
		return this.flawsNSecrets;
	}

	public void reRoll(final String trait) {
		switch(trait) {
		case "appearance":
			this.appearanceReRoll();
			break;
		case "highAbility":
			this.highAbilityReRoll();
			break;
		case "lowAbility":
			this.lowAbilityrReRoll();
			break;
		case "talents":
			this.talentsReRoll();
			break;
		case "manerisms":
			this.manerismsReRoll();
			break;
		case "interactionTraits":
			this.interactionTraitsReRoll();
			break;
		case "ideas":
			this.ideasReRoll();
			break;
		case "bonds":
			this.bondsReRoll();
			break;
		case "flawsNSecrets":
			this.flawsNSecretsReRoll();
			break;
		}
	}

	public void appearanceReRoll() {
		this.apperance = this.random("InputFiles/npc-appearance.txt");
	}
	public void highAbilityReRoll() {
		this.highAbility = this.random("InputFiles/npc-abilities-high.txt");
	}
	public void lowAbilityrReRoll() {
		this.lowAbility = this.random("InputFiles/npc-abilities-low.txt");
	}
	public void talentsReRoll() {
		this.talents = this.random("InputFiles/npc-talents.txt");
	}
	public void manerismsReRoll() {
		this.manerisms = this.random("InputFiles/npc-manerisms.txt");
	}
	public void interactionTraitsReRoll() {
		this.interactionTraits = this.random("InputFiles/npc-interaction-traits.txt");
	}
	public void ideasReRoll() {
		this.ideas = null; //random("InputFiles/npc-ideas.txt");
	}
	public void bondsReRoll() {
		this.bonds = this.random("InputFiles/npc-bonds.txt");
	}
	public void flawsNSecretsReRoll() {
		this.flawsNSecrets = this.random("InputFiles/npc-flaws-secrets.txt");
	}

	private String random(final String fin) {
		File file = null;
		Scanner buffer = null;

		try {
			file = new File(fin);
			if(!file.exists())
				return null;

			buffer = new Scanner(file);
			int count = buffer.nextInt();
			buffer.nextLine();
			int rollCount = (int)(Math.random() * count);

			for(int i = 0; i < count && buffer.hasNext(); i++, buffer.nextLine()) {
				if(i == rollCount)
					return buffer.nextLine();
			}

		}catch(Exception e) {
			System.out.printf("Exception opening or reading file: %s\n", e);
		}finally {
			if(buffer != null) {
				buffer.close();
				buffer = null;
			}
			if(file != null)
			{
				file = null;
			}
		}

		return null;
	}

	@Override
	public int compareTo(final NPC that)
	{
		int diff = this.hashCode() - that.hashCode();

		if (diff < 0)
			return -1;
		else if (diff > 0)
			return 1;
		else return 0;
	}
}

