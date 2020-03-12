package dmtoolkit.entities;

public class StatBlock implements Comparable<StatBlock>
{
	private String name;
	private String type;
	private String alignment;
	private int ac;
	private int hp;
	private int walkSpeed;
	private int swimSpeed;
	private int climbSpeed;
	private int flySpeed;
	private int str;
	private int strAdditive;
	private int dex;
	private int dexAdditive;
	private	int con;
	private int conAdditive;
	private int intl;
	private int intlAdditive;
	private int wis;
	private int wisAdditive;
	private int cha;
	private int chaAdditive;
	private String[] saves;
	private String[] skills;
	private String[] senses;
	private String[] languages;
	private double cr;
	private String[] properties;
	private String[] actions;
	private String[] legendaryActions;
	private String imgPath;
	private boolean custom;
	private String lore;

	public StatBlock(final String name, final String type, final String alignment, final int ac, final int hp, final int walkSpeed, final int swimSpeed, final int climbSpeed, final int flySpeed, final int str, final int dex, final int con, final int intl, final int wis, final int cha, final String[] saves, final String[] skills, final String[] senses, final String[] languages, final double cr, final String[] properties, final String[] actions, final String[] legendaryActions, final String imgPath, final boolean custom, final String lore)
	{
		this.name = name;
		this.type = type;
		this.alignment = alignment;
		this.ac = ac;
		this.hp = hp;
		this.walkSpeed = walkSpeed;
		this.swimSpeed = swimSpeed;
		this.climbSpeed = climbSpeed;
		this.flySpeed = flySpeed;
		this.str = str;
		this.strAdditive = this.calcAdditive(str);
		this.dex = dex;
		this.dexAdditive = this.calcAdditive(dex);
		this.con = con;
		this.conAdditive = this.calcAdditive(con);
		this.intl = intl;
		this.intlAdditive = this.calcAdditive(intl);
		this.wis = wis;
		this.wisAdditive = this.calcAdditive(wis);
		this.cha = cha;
		this.chaAdditive = this.calcAdditive(cha);
		this.saves = saves;
		this.skills = skills;
		this.senses = senses;
		this.languages = languages;
		this.cr = cr;
		this.properties = properties;
		this.actions = actions;
		this.legendaryActions = legendaryActions;
		this.imgPath = imgPath;
		this.custom = custom;
		this.lore = lore;
	}

	public int calcAdditive(final int as)
	{
		switch(as)
		{
		case 1:
			return -5;
		case 2:
			return -4;
		case 3:
			return -4;
		case 4:
			return -3;
		case 5:
			return -3;
		case 6:
			return -2;
		case 7:
			return -2;
		case 8:
			return -1;
		case 9:
			return -1;
		case 10:
			return 0;
		case 11:
			return 0;
		case 12:
			return 1;
		case 13:
			return 1;
		case 14:
			return 2;
		case 15:
			return 2;
		case 16:
			return 3;
		case 17:
			return 3;
		case 18:
			return 4;
		case 19:
			return 4;
		case 20:
			return 5;
		case 21:
			return 5;
		case 22:
			return 6;
		case 23:
			return 6;
		case 24:
			return 7;
		case 25:
			return 7;
		case 26:
			return 8;
		case 27:
			return 8;
		case 28:
			return 9;
		case 29:
			return 9;
		case 30:
			return 10;
		}
		return -100;
	}

	public String fullData()
	{
		String out = "";
		out = out + this.type + ", " + this.alignment + "\n\n\n";
		out = out + "Armor Class: " + this.ac + "\n";
		out = out + "Hit Points: " + this.hp + "\n";
		out = out + "Speed: walk " + this.walkSpeed + " ft., swim " + this.swimSpeed + " ft., climb " + this.climbSpeed + " ft., fly " + this.flySpeed + " ft.\n\n\n";
		out = out + "STR\t\tDEX\t\tCON\t\tINT\t\tWIS\t\tCHA\n";
		out = out + this.modStr() + "\t" + this.modDex() + "\t" + this.modCon() + "\t" + this.modIntl() + "\t" + this.modWis() + "\t" + this.modCha() + "\n\n\n";

		if (this.saves.length != 0)
		{
			out = out + "Saving Throws: ";
			for (int i = 0; i < this.saves.length; i++)
				if (i == this.saves.length - 1)
					out = out + this.saves[i];
				else
					out = out + this.saves[i] + ",";
			out = out + "\n";
		}

		if(this.senses.length != 0)
		{
			out = out + "Senses: ";
			for (int i = 0; i < this.senses.length; i++)
				if (i == this.senses.length - 1)
					out = out + this.senses[i];
				else
					out = out + this.senses[i] + ",";
			out = out + "\n";
		}

		out = out + "\n\nActions:";
		for (String s : this.actions)
			out = out + "\n\t" + s + "\n";
		out = out + "\n";

		out = out + "Legendary Actions: \n";
		for (String s : this.legendaryActions)
			out = out + "\n\t" + s + "\n";
		out = out + "\n";

		return out;
	}


	public String modStr()
	{
		if (this.strAdditive < 0)
			return this.str + "(" + this.strAdditive + ")";
		else
			return this.str + "(+" + this.strAdditive + ")";
	}

	public String modDex()
	{
		if (this.dexAdditive < 0)
			return this.dex + "(" + this.dexAdditive + ")";
		else
			return this.dex + "(+" + this.dexAdditive + ")";
	}

	public String modCon()
	{
		if (this.conAdditive < 0)
			return this.con + "(" + this.conAdditive + ")";
		else
			return this.con + "(+" + this.conAdditive + ")";
	}

	public String modIntl()
	{
		if (this.intlAdditive < 0)
			return this.intl + "(" + this.intlAdditive + ")";
		else
			return this.intl + "(+" + this.intlAdditive + ")";
	}

	public String modWis()
	{
		if (this.wisAdditive < 0)
			return this.wis + "(" + this.wisAdditive + ")";
		else
			return this.wis + "(+" + this.wisAdditive + ")";
	}

	public String modCha()
	{
		if (this.chaAdditive < 0)
			return this.cha + "(" + this.chaAdditive + ")";
		else
			return this.cha + "(+" + this.chaAdditive + ")";
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getAlignment() {
		return this.alignment;
	}

	public void setAlignment(final String alignment) {
		this.alignment = alignment;
	}

	public int getAc() {
		return this.ac;
	}

	public void setAc(final int ac) {
		this.ac = ac;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(final int hp) {
		this.hp = hp;
	}

	public int getWalkSpeed() {
		return this.walkSpeed;
	}

	public void setWalkSpeed(final int walkSpeed) {
		this.walkSpeed = walkSpeed;
	}

	public int getSwimSpeed() {
		return this.swimSpeed;
	}

	public void setSwimSpeed(final int swimSpeed) {
		this.swimSpeed = swimSpeed;
	}

	public int getClimbSpeed() {
		return this.climbSpeed;
	}

	public void setClimbSpeed(final int climbSpeed) {
		this.climbSpeed = climbSpeed;
	}

	public int getFlySpeed() {
		return this.flySpeed;
	}

	public void setFlySpeed(final int flySpeed) {
		this.flySpeed = flySpeed;
	}

	public int getStr() {
		return this.str;
	}

	public void setStr(final int str) {
		this.str = str;
	}

	public int getStrAdditive() {
		return this.strAdditive;
	}

	public void setStrAdditive(final int strAdditive) {
		this.strAdditive = strAdditive;
	}

	public int getDex() {
		return this.dex;
	}

	public void setDex(final int dex) {
		this.dex = dex;
	}

	public int getDexAdditive() {
		return this.dexAdditive;
	}

	public void setDexAdditive(final int dexAdditive) {
		this.dexAdditive = dexAdditive;
	}

	public int getCon() {
		return this.con;
	}

	public void setCon(final int con) {
		this.con = con;
	}

	public int getConAdditive() {
		return this.conAdditive;
	}

	public void setConAdditive(final int conAdditive) {
		this.conAdditive = conAdditive;
	}

	public int getIntl() {
		return this.intl;
	}

	public void setIntl(final int intl) {
		this.intl = intl;
	}

	public int getIntlAdditive() {
		return this.intlAdditive;
	}

	public void setIntlAdditive(final int intlAdditive) {
		this.intlAdditive = intlAdditive;
	}

	public int getWis() {
		return this.wis;
	}

	public void setWis(final int wis) {
		this.wis = wis;
	}

	public int getWisAdditive() {
		return this.wisAdditive;
	}

	public void setWisAdditive(final int wisAdditive) {
		this.wisAdditive = wisAdditive;
	}

	public int getCha() {
		return this.cha;
	}

	public void setCha(final int cha) {
		this.cha = cha;
	}

	public int getChaAdditive() {
		return this.chaAdditive;
	}

	public void setChaAdditive(final int chaAdditive) {
		this.chaAdditive = chaAdditive;
	}

	public String[] getSaves() {
		return this.saves;
	}

	public void setSaves(final String[] saves) {
		this.saves = saves;
	}

	public String[] getSkills() {
		return this.skills;
	}

	public void setSkills(final String[] skills) {
		this.skills = skills;
	}

	public String[] getSenses() {
		return this.senses;
	}

	public void setSenses(final String[] senses) {
		this.senses = senses;
	}

	public String[] getLanguages() {
		return this.languages;
	}

	public void setLanguages(final String[] languages) {
		this.languages = languages;
	}

	public double getCr() {
		return this.cr;
	}

	public void setCr(final double cr) {
		this.cr = cr;
	}

	public String[] getProperties() {
		return this.properties;
	}

	public void setProperties(final String[] properies) {
		this.properties = properies;
	}

	public String[] getActions() {
		return this.actions;
	}

	public void setActions(final String[] actions) {
		this.actions = actions;
	}

	public String[] getLegendaryActions() {
		return this.legendaryActions;
	}

	public void setLegendaryActions(final String[] legendaryActions) {
		this.legendaryActions = legendaryActions;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(final String imgPath) {
		this.imgPath = imgPath;
	}

	public boolean isCustom()
	{
		return this.custom;
	}

	public String getLore() {
		return this.lore;
	}

	public void setLore(final String lore) {
		this.lore = lore;
	}

	@Override
	public int compareTo(final StatBlock that)
	{
		return this.name.compareTo(that.name);
	}
}
