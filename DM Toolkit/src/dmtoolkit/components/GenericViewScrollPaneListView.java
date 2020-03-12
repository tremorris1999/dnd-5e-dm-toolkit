package dmtoolkit.components;

import java.util.LinkedList;

import dmtoolkit.entities.StatBlock;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class GenericViewScrollPaneListView<T extends BorderPane, U>extends ListView<U> //TODO change to StatBlock once that exists
{
	private GenericViewScrollPane<T>parent;
	private double width;
	private double height;
	private LinkedList<U> statBlocks;

	public GenericViewScrollPaneListView(final GenericViewScrollPane<T> parent, final LinkedList<U> statBlocks)
	{
		super();
		this.statBlocks = statBlocks;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewScrollPaneListView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				GenericViewScrollPaneListView.this.updateSizes();
			}
		});

		// data setup
	
		for (U sb : this.statBlocks)
			this.getItems().add(sb);

	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * 0.99;
		this.height = this.parent.getCalcHeight() * 0.99;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}
}
