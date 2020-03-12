package dmtoolkit.components;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.HBox;

public class ScaledHBox extends HBox implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public ScaledHBox(final Scalable parent, final double widthPerc, final double heightPerc)
	{
		super();
		this.widthPerc = widthPerc;
		this.heightPerc = heightPerc;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledHBox.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledHBox.this.updateSizes();
			}
		});
	}

	@Override
	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * this.widthPerc;
		this.height = this.parent.getCalcHeight() * this.heightPerc;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
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
		return this.parent;
	}

	@Override
	public int getChildCount()
	{
		return this.getChildren().size();
	}
}