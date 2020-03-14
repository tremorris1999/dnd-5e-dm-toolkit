package dmtoolkit.toolbars;

import dmtoolkit.components.ScaledButton;
import dmtoolkit.interfaces.Scalable;
import dmtoolkit.views.RootView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;

public class MainToolBar extends ToolBar implements Scalable
{
	private Scalable parent;
	@SuppressWarnings("unused")
	private Node[] panes;
	private ObservableList<Node> items;
	private double width;
	private double height;
	private int size;

	public MainToolBar(final RootView parent, final Node[] panes)
	{
		super();
		this.parent = parent;
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

		double children = 1.0/6.0; // CHANGE THIS DENOMINATOR IF YOU ADD MORE BUTTONS

		ScaledButton mainBtn = new ScaledButton(this, "Main", children, 1), combatBtn = new ScaledButton(this,"Combat Tracker", children, 1);
		ScaledButton statBtn = new ScaledButton(this, "Stat Blocks", children, 1), xpBtn = new ScaledButton(this, "XP Manager", children, 1);
		ScaledButton npcBtn = new ScaledButton(this, "NPC Manager", children, 1), prefBtn = new ScaledButton(this, "Preferences", children, 1);

		//this.items.add(mainBtn);
		//this.items.add(combatBtn);
		this.items.add(statBtn);
		//this.items.add(xpBtn);
		//this.items.add(npcBtn);
		//this.items.add(prefBtn);
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

		npcBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				parent.setCenter(panes[3]);
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

	@Override
	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.05;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}

	@Override
	public double getCalcWidth()
	{
		return this.width;
	}

	@Override
	public double getCalcHeight()
	{
		return this.height;
	}

	@Override
	public int getChildCount()
	{
		return this.size;
	}

	@Override
	public Scalable getScaleParent()
	{
		return this.parent;
	}
}
