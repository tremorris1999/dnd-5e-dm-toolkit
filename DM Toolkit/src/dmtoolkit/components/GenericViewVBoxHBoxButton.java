package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GenericViewVBoxHBoxButton<T extends BorderPane> extends Button
{
	private GenericViewVBoxHBox<T> parent;
	private double width;
	private double height;

	public GenericViewVBoxHBoxButton(final GenericViewVBoxHBox<T> parent, final String text)
	{
		super(text);

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxHBoxButton.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxHBoxButton.this.updateSizes();
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
