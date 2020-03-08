package dmtoolkit.utility;

import java.io.File;
import java.util.Scanner;

public class NPC {
	private String apperance, highAbility, lowAbility, talents, manerisms, 
				   interactionTraits, ideas, bonds, flawsNSecrets;
	
	public NPC() {
		this.apperance = random("InputFiles/npc-appearance.txt");
		this.highAbility = random("InputFiles/npc-abilities-high.txt");
		this.lowAbility = random("InputFiles/npc-abilities-low.txt");
		this.talents = random("InputFiles/npc-talents.txt");
		this.manerisms = random("InputFiles/npc-manerisms.txt");
		this.interactionTraits = random("InputFiles/npc-interaction-traits.txt");
		this.ideas = null; //random("InputFiles/npc-ideas.txt");
		this.bonds = random("InputFiles/npc-bonds.txt");
		this.flawsNSecrets = random("InputFiles/npc-flaws-secrets.txt");
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
	
	public void reRoll(String trait) {
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
		this.apperance = random("InputFiles/npc-appearance.txt");
	}
	public void highAbilityReRoll() {
		this.highAbility = random("InputFiles/npc-abilities-high.txt");
	}
	public void lowAbilityrReRoll() {
		this.lowAbility = random("InputFiles/npc-abilities-low.txt");
	}
	public void talentsReRoll() {
		this.talents = random("InputFiles/npc-talents.txt");
	}
	public void manerismsReRoll() {
		this.manerisms = random("InputFiles/npc-manerisms.txt");
	}
	public void interactionTraitsReRoll() {
		this.interactionTraits = random("InputFiles/npc-interaction-traits.txt");
	}
	public void ideasReRoll() {
		this.ideas = null; //random("InputFiles/npc-ideas.txt");
	}
	public void bondsReRoll() {
		this.bonds = random("InputFiles/npc-bonds.txt");
	}
	public void flawsNSecretsReRoll() {
		this.flawsNSecrets = random("InputFiles/npc-flaws-secrets.txt");
	}
	
	private String random(String fin) {
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
}

