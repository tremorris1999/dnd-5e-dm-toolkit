package dmtoolkit.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;


public class StatView extends BorderPane
{
	private RootView parent;
	private double width;
	private double height;

	public StatView(final RootView parent)
	{
		super();

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatView.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: blanchedalmond");
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.75;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}
}
