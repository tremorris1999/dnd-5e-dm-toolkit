package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;

public class StatViewScrollPane extends ScrollPane
{
	private StatViewVBox parent;
	private double width;
	private double height;
	private double percentage;

	public StatViewScrollPane(final StatViewVBox parent, final double percentage)
	{
		super();
		this.percentage = percentage;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewScrollPane.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewScrollPane.this.updateSizes();
			}
		});

		//style setup
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * 0.99;
		this.height = this.parent.getCalcHeight() * this.percentage;
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
