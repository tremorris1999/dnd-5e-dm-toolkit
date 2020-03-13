package dmtoolkit.views;

import dmtoolkit.entities.StatBlock;
import dmtoolkit.interfaces.Scalable;
import dmtoolkit.utility.ObservableLinkedList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;


public class MainView extends BorderPane implements Scalable
{
	private RootView parent;
	private double width;
	private double height;
	public MainView(final RootView parent, final ObservableLinkedList<StatBlock> list)
	{
		super();

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainView.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: cadetblue;");

	}

	@Override
	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.75;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}

	@Override
	public Scalable getScaleParent() {
		//   Auto-generated method stub
		return null;
	}

	@Override
	public double getCalcWidth() {
		//   Auto-generated method stub
		return 0;
	}

	@Override
	public double getCalcHeight() {
		//   Auto-generated method stub
		return 0;
	}

	@Override
	public int getChildCount() {
		//   Auto-generated method stub
		return 0;
	}
}
