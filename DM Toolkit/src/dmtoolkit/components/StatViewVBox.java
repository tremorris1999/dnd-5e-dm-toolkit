package dmtoolkit.components;

import dmtoolkit.views.StatView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.VBox;

public class StatViewVBox extends VBox
{
	private StatView parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public StatViewVBox(final StatView parent, final double widthPerc, final double heighPerc)
	{
		super();
		this.widthPerc = widthPerc;
		this.heightPerc = heighPerc;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBox.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBox.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: white; -fx-border-color: black;");
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * this.widthPerc;
		this.height = this.parent.getCalcHeight() * this.heightPerc;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
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
