package dmtoolkit.views;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;

public class RootView extends BorderPane implements Scalable
{
	private double width;
	private double height;

	public RootView(final double windowWidth, final double windowHeight)
	{
		super();
		this.width = windowWidth;
		this.height = windowHeight;

		this.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				RootView.this.calcWidth(newValue);
			}
		});
		this.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				RootView.this.calcHeight(newValue);
			}
		});
	}

	public void calcWidth(final Number newValue)
	{
		this.width = newValue.doubleValue();
	}

	public void calcHeight(final Number newValue)
	{
		this.height = newValue.doubleValue();
	}

	@Override
	public double getCalcWidth()
	{
		return this.width;
	}

	@Override
	public double getCalcHeight()
	{
		return this.height;
	}

	@Override
	public Scalable getScaleParent()
	{
		return null; // not applicable for this class
	}

	@Override
	public void updateSizes()
	{
		return; // not applicable for this class
	}

	@Override
	public int getChildCount()
	{
		return this.getChildren().size();
	}

}
