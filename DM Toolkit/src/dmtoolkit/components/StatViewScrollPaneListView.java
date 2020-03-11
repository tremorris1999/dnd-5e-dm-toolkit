package dmtoolkit.components;

import java.util.LinkedList;

import dmtoolkit.entities.StatBlock;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

public class StatViewScrollPaneListView extends ListView<StatBlock> //TODO change to StatBlock once that exists
{
	private StatViewScrollPane parent;
	private double width;
	private double height;
	private LinkedList<StatBlock> statBlocks;

	public StatViewScrollPaneListView(final StatViewScrollPane parent, final LinkedList<StatBlock> statBlocks)
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
				StatViewScrollPaneListView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatViewScrollPaneListView.this.updateSizes();
			}
		});

		// data setup
		for (StatBlock sb : this.statBlocks)
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
