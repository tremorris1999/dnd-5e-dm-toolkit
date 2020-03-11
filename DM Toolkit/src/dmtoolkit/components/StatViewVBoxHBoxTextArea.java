package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class StatViewVBoxHBoxTextArea extends Label
{
	private StatViewVBoxHBox parent;
	private double width;
	private double height;

	public StatViewVBoxHBoxTextArea(final StatViewVBoxHBox parent, final String text)
	{
		super(text);

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBoxTextArea.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxHBoxTextArea.this.updateSizes();
			}
		});

		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-font-size: 18; -fx-font-weight: bolder;");
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight();
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}
}
