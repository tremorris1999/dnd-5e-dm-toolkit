package dmtoolkit;

import dmtoolkit.entities.StatBlock;
import dmtoolkit.toolbars.MainToolBar;
import dmtoolkit.utility.NPC;
import dmtoolkit.utility.ObservableLinkedList;
import dmtoolkit.utility.StatIO;
import dmtoolkit.views.CombatView;
import dmtoolkit.views.ConsoleView;
import dmtoolkit.views.MainView;
import dmtoolkit.views.NPCView;
import dmtoolkit.views.RootView;
import dmtoolkit.views.StatView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
	public double windowWidth = 800;
	public double windowHeight = 450;

	@Override
	public void start(final Stage primaryStage)
	{
		try
		{
			RootView root = new RootView(this.windowWidth,this.windowHeight);
			root.setBottom(new ConsoleView(root, 1, 0.195));


			// setup stat blocks
			ObservableLinkedList<StatBlock> statBlocks = new ObservableLinkedList<StatBlock>();
			try { statBlocks = StatIO.buildStats(root.getDBPath());
			root.getConsole().log("SUCCESS - Loaded Stat Blocks from '" + root.getDBPath() + "'.\n\n");
			} catch(Exception statError ) {
				root.getConsole().log("FATAL FAIURE - No stat blocks loaded. THREAD SUSPENDED INDEFINITELY\n\n");
				root.setDisable(true);
			}
			ObservableLinkedList<NPC> npcBlocks = new ObservableLinkedList<NPC>();
			Node[] panes = {new MainView(root, statBlocks), new CombatView(root), new StatView(root, statBlocks), new NPCView(root, npcBlocks)};

			root.setTop(new MainToolBar(root, panes));
			root.setCenter(panes[2]);

			Scene scene = new Scene(root, 1288, 720);
			primaryStage.setMinWidth(this.windowWidth);
			primaryStage.setMinHeight(this.windowHeight);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dungeon Master's Toolkit v 0.0.1 pre-pre-pre-pre-pre-alpha");
			primaryStage.show();
			//StatIO.toDB(statBlocks);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
