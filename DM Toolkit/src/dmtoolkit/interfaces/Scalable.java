package dmtoolkit.interfaces;

import javafx.beans.property.ReadOnlyDoubleProperty;

public interface Scalable
{
	public abstract Scalable getScaleParent(); // returns the scalable parent of the scalable component
	public abstract double getCalcWidth(); // returns the width of the scalable component
	public abstract double getCalcHeight(); // returns the height of the scalable component
	public abstract void updateSizes(); // updates the size of the scalable component
	public abstract ReadOnlyDoubleProperty widthProperty(); // readable width property
	public abstract ReadOnlyDoubleProperty heightProperty(); // readable height property
	public abstract int getChildCount(); // counts children
}
