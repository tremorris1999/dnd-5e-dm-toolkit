package dmtoolkit.components;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.VBox;

public class ScaledVBox extends VBox implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public ScaledVBox(final Scalable parent, final double widthPerc, final double heighPerc)
	{
		super();
		this.parent = parent;
		this.widthPerc = widthPerc;
		this.heightPerc = heighPerc;

		// parent setup
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledVBox.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledVBox.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: white; -fx-border-color: black;");
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
