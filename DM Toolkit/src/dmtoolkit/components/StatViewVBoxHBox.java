package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.HBox;

public class StatViewVBoxHBox extends HBox
{
	private StatViewVBox parent;
	private double width;
	private double height;

	public StatViewVBoxHBox(final StatViewVBox parent)
	{
		super();

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBox.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBox.this.updateSizes();
			}
		});
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.1;
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
