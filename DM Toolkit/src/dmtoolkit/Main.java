package dmtoolkit;

import dmtoolkit.toolbars.MainToolBar;
import dmtoolkit.views.CombatView;
import dmtoolkit.views.ConsoleView;
import dmtoolkit.views.MainView;

import dmtoolkit.views.RootView;
import dmtoolkit.views.NPCView;
import dmtoolkit.views.StatView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
	public double windowWidth = 880;
	public double windowHeight = 495;

	@Override
	public void start(final Stage primaryStage) {
		try {

			RootView root = new RootView(this.windowWidth,this.windowHeight);
			Node[] panes = {new MainView(root), new CombatView(root), new StatView(root), new NPCView()};

			root.setTop(new MainToolBar(root, panes));
			root.setCenter(panes[0]);
			root.setBottom(new ConsoleView(root));
			Scene scene = new Scene(root, 1288, 720);
			primaryStage.setMinWidth(this.windowWidth);
			primaryStage.setMinHeight(this.windowHeight);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dungeon Master's Toolkit v 0.0.1 pre-pre-pre-pre-pre-alpha");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
