package dmtoolkit.components;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ScaledButton extends Button implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public ScaledButton(final Scalable parent, final String text, final double widthPerc, final double heightPerc)
	{
		super(text);
		this.parent = parent;
		this.widthPerc = widthPerc;
		this.heightPerc = heightPerc;
		this.setAlignment(Pos.CENTER);

		parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledButton.this.updateSizes();
			}
		});
		parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledButton.this.updateSizes();
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
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
	}

	@Override
	public Scalable getScaleParent()
	{
		return this.parent;
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
	public int getChildCount()
	{
		return this.getChildren().size();
	}

}
