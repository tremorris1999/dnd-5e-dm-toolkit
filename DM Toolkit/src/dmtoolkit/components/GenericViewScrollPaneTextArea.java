package dmtoolkit.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class GenericViewScrollPaneTextArea<T extends BorderPane> extends TextArea
{
	private GenericViewScrollPane<T> parent;
	private double width;
	private double height;

	public GenericViewScrollPaneTextArea(final GenericViewScrollPane<T> parent)
	{
		super();

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewScrollPaneTextArea.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewScrollPaneTextArea.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-font-size: 16;");
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * 0.99;
		this.height = this.parent.getCalcHeight() * 0.99;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMinHeight(this.height);
	}
}
