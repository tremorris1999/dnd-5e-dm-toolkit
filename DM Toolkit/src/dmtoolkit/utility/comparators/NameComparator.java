package dmtoolkit.utility.comparators;

import java.util.Comparator;

import dmtoolkit.entities.StatBlock;

public class NameComparator implements Comparator<StatBlock>
{

	@Override
	public int compare(final StatBlock s1, final StatBlock s2)
	{
		return s1.compareTo(s2);
	}

}
