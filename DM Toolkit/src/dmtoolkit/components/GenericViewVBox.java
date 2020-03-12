package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GenericViewVBox<T extends BorderPane> extends VBox
{
	private T parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;

	public GenericViewVBox(final T parent, final double widthPerc, final double heighPerc)
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
				GenericViewVBox.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBox.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: white; -fx-border-color: black;");
	}

	public void updateSizes()
	{
		this.width = this.parent.getWidth() * this.widthPerc;
		this.height = this.parent.getHeight() * this.heightPerc;
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
