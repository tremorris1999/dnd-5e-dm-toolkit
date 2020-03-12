package dmtoolkit.views;

import java.util.LinkedList;

import dmtoolkit.components.ScaledListView;
import dmtoolkit.entities.StatBlock;
import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;


public class MainView extends BorderPane implements Scalable
{
	private RootView parent;
	private double width;
	private double height;
	public MainView(final RootView parent, final LinkedList<StatBlock> list)
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

		ScaledListView<StatBlock> view = new ScaledListView<StatBlock>(this, 1, 1, new LinkedList<StatBlock>());
		view.getItems().addAll(list);
		this.setCenter(view);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCalcWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCalcHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
