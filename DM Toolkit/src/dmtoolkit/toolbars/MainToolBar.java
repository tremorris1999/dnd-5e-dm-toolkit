package dmtoolkit.toolbars;

import dmtoolkit.components.MainToolBarButton;
import dmtoolkit.views.RootView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public class MainToolBar extends ToolBar
{
	private RootView parent;
	private Node[] panes;
	private ObservableList<Node> items;
	private double width;
	private double height;
	private int size;

	public MainToolBar(final RootView parent, final Node[] panes)
	{
		super();
		this.parent = parent;
		this.panes = panes;
		this.items = this.getItems();
		this.size = 0;

		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainToolBar.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				MainToolBar.this.updateSizes();
			}
		});

		MainToolBarButton mainBtn = new MainToolBarButton("Main", this), combatBtn = new MainToolBarButton("Combat Tracker", this);
		MainToolBarButton statBtn = new MainToolBarButton("Stat Blocks", this), xpBtn = new MainToolBarButton("XP Manager", this);
		MainToolBarButton prefBtn = new MainToolBarButton("Preferences", this);

		this.items.add(mainBtn);
		this.items.add(combatBtn);
		this.items.add(statBtn);
		this.items.add(xpBtn);
		this.items.add(prefBtn);
		this.size = this.getItems().size();

		mainBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("main pressed");
				parent.setCenter(panes[0]);
			}
		});

		combatBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("combat pressed");
				parent.setCenter(panes[1]);
			}
		});

		statBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("stats pressed");
				parent.setCenter(panes[2]);
			}
		});

		xpBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("xp pressed");
			}
		});

		prefBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("pref presses");
			}
		});
	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.05;
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

	public double getChildCount()
	{
		return 1.0 / this.size;
	}
}
