package dmtoolkit.components;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class ScaledLabel extends Label implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public ScaledLabel(final Scalable parent, final String text, final double widthPerc, final double heightPerc)
	{
		super(text);
		this.parent = parent;
		this.widthPerc = widthPerc;
		this.heightPerc = heightPerc;
		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-font-weight: bolder; -fx-font-size: 20;");

		// parent setup
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledLabel.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledLabel.this.updateSizes();
			}
		});
	}

	@Override
	public void updateSizes()
	{
		if (this.parent.getClass() == ScaledScrollPane.class)
		{
			this.width = this.parent.getCalcWidth() * this.widthPerc;
			this.setMinWidth(this.width);
			this.setMaxWidth(this.width);
			this.setMinHeight(this.parent.getCalcHeight());
		}
		else
		{
			this.width = this.parent.getCalcWidth() * this.widthPerc;
			this.height = this.parent.getCalcHeight() * this.heightPerc;
			this.setMinWidth(this.width);
			this.setMinHeight(this.height);
			this.setMaxWidth(this.width);
			this.setMaxHeight(this.height);
		}
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
