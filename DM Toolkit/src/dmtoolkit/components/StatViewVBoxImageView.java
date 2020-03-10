package dmtoolkit.components;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StatViewVBoxImageView extends ImageView
{
	private StatViewVBox parent;
	private double width;
	private double height;

	public StatViewVBoxImageView(final StatViewVBox parent, final String path)
	{
		super(new Image(new File(path).toURI().toString()));

		//parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxImageView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewVBoxImageView.this.updateSizes();
			}
		});
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * 0.625;
		this.height = this.parent.getCalcHeight() * 0.4;
		this.setFitWidth(this.width * 0.95);
		this.setFitHeight(this.height * 0.95);
	}
}
