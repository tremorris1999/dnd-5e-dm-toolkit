package dmtoolkit.utility;

import java.util.Collection;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableLinkedList<T extends Comparable<?super T>> extends java.util.LinkedList<T> implements ObservableList<T>
{

	/**
	 *
	 */
	private static final long serialVersionUID = 2257612727485469423L;

	@Override
	public void addListener(final InvalidationListener arg0) {
		//  Auto-generated method stub

	}

	@Override
	public void removeListener(final InvalidationListener arg0) {
		//   Auto-generated method stub

	}

	@Override
	public boolean addAll(@SuppressWarnings("unchecked") final T... arg0) {
		//   Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(final ListChangeListener<? super T> arg0) {
		//   Auto-generated method stub

	}

	@Override
	public void remove(final int arg0, final int arg1) {
		//   Auto-generated method stub

	}

	@Override
	public boolean removeAll(@SuppressWarnings("unchecked") final T... arg0) {
		//   Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(final ListChangeListener<? super T> arg0) {
		//   Auto-generated method stub

	}

	@Override
	public boolean retainAll(@SuppressWarnings("unchecked") final T... arg0) {
		//   Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(@SuppressWarnings("unchecked") final T... arg0) {
		//   Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(final Collection<? extends T> arg0) {
		//   Auto-generated method stub
		return false;
	}

}
