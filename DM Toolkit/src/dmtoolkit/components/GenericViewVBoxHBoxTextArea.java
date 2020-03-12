package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class GenericViewVBoxHBoxTextArea<T extends BorderPane> extends Label
{
	private GenericViewVBoxHBox<T> parent;
	private double width;
	private double height;

	public GenericViewVBoxHBoxTextArea(final GenericViewVBoxHBox<T> parent, final String text)
	{
		super(text);

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxHBoxTextArea.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxHBoxTextArea.this.updateSizes();
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
