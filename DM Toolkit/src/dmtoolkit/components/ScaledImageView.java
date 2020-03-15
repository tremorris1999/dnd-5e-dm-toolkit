package dmtoolkit.components;

import java.io.File;

import dmtoolkit.interfaces.Scalable;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ScaledImageView extends ImageView implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;

	public ScaledImageView(final Scalable parent, final String path)
	{
		super(new Image(new File(path).toURI().toString()));

		//parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledImageView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ScaledImageView.this.updateSizes();
			}
		});
	}

	@Override
	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * 0.625;
		this.height = this.parent.getCalcHeight() * 0.4;
		//this.setPreserveRatio(true); TODO Fix maybe?
		this.setFitWidth(this.width);
		this.setFitHeight(this.height);
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
	public ReadOnlyDoubleProperty widthProperty()
	{
		return null; // not applicable for this class
	}

	@Override
	public ReadOnlyDoubleProperty heightProperty()
	{
		return null; // not applicable for this class
	}

	@Override
	public int getChildCount()
	{
		return 0; // not applicable for this class
	}
}
