package dmtoolkit.components;

import dmtoolkit.toolbars.MainToolBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MainToolBarButton extends Button
{
	private MainToolBar parent;
	private double width;
	private double height;

	public MainToolBarButton(final String text, final MainToolBar parent)
	{
		super(text);
		this.parent = parent;
		this.updateSizes();
		this.setAlignment(Pos.CENTER);

		parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainToolBarButton.this.updateSizes();
			}
		});
		parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainToolBarButton.this.updateSizes();
			}
		});
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * this.parent.getChildCount();
		this.height = this.parent.getCalcHeight();
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
	}

}
