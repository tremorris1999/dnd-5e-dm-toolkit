package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

public class StatViewVBoxHBoxButton extends Button
{
	private StatViewVBoxHBox parent;
	private double width;
	private double height;

	public StatViewVBoxHBoxButton(final StatViewVBoxHBox parent, final String text)
	{
		super(text);

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBoxButton.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBoxButton.this.updateSizes();
			}
		});
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() / this.parent.getChildren().size();
		this.height = this.parent.getCalcHeight();
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}
}
