package dmtoolkit.toolbars;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class MainToolBar extends ToolBar
{
	BorderPane root;
	Node[] panes;
	ObservableList<Node> items;

	public MainToolBar(final BorderPane root, final Node[] panes)
	{
		super();
		this.root = root;
		this.panes = panes;

		Button mainBtn = new Button("Main"), combatBtn = new Button("Combat Tracker");
		Button statBtn = new Button("Stat Blocks"), xpBtn = new Button("XP Manager");
		Button prefBtn = new Button("Preferences");

		this.items = this.getItems();
		this.items.add(mainBtn);
		this.items.add(combatBtn);
		this.items.add(statBtn);
		this.items.add(xpBtn);
		this.items.add(prefBtn);

		mainBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("main pressed");
				root.setCenter(panes[0]);
			}
		});

		combatBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("combat pressed");
				root.setCenter(panes[1]);
			}
		});

		statBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				System.out.println("stats pressed");
				root.setCenter(panes[2]);
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
}
