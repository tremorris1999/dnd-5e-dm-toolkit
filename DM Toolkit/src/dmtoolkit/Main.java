package dmtoolkit;

import dmtoolkit.toolbars.MainToolBar;
import dmtoolkit.views.CombatView;
import dmtoolkit.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(final Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Pane[] panes = {new MainView(), new CombatView()};

			root.setTop(new MainToolBar(root, panes));
			Scene scene = new Scene(root,400,400);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
