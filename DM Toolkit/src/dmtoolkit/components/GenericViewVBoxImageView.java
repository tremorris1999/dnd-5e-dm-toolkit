package dmtoolkit.components;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class GenericViewVBoxImageView<T extends BorderPane> extends ImageView
{
	private GenericViewVBox<T> parent;
	private double width;
	private double height;
	private Image image;

	public GenericViewVBoxImageView(final GenericViewVBox<T> parent, final String path)
	{
		super(new Image(new File(path).toURI().toString()));

		//parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxImageView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewVBoxImageView.this.updateSizes();
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
