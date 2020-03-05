package dmtoolkit;

import dmtoolkit.toolbars.MainToolBar;
import dmtoolkit.views.CombatView;
import dmtoolkit.views.MainView;
import dmtoolkit.views.StatView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(final Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Node[] panes = {new MainView(), new CombatView(), new StatView()};

			root.setTop(new MainToolBar(root, panes));
			Scene scene = new Scene(root, 1600, 900);
			//primaryStage.setMaximized(true);
			primaryStage.setResizable(false);
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
