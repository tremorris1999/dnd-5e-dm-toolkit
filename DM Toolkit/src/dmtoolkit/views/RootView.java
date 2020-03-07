package dmtoolkit.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;

public class RootView extends BorderPane
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
				calcWidth(newValue);
			}
		});
		this.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				calcHeight(newValue);
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

	public double getCalcWidth()
	{
		return this.width;
	}

	public double getCalcHeight()
	{
		return this.height;
	}

}
