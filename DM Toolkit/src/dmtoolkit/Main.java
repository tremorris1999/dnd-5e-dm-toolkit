package dmtoolkit;

import dmtoolkit.toolbars.MainToolBar;
import dmtoolkit.views.CombatView;
import dmtoolkit.views.ConsoleView;
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
			Node[] panes = {new MainView(), new CombatView(), new StatView(root)};
			root.setTop(new MainToolBar(root, panes));
			root.setCenter(panes[0]);
			root.setBottom(new ConsoleView());
			Scene scene = new Scene(root, 1440, 810);

			primaryStage.setResizable(false);
			primaryStage.setMinWidth(1440);
			primaryStage.setMinHeight(810);
			primaryStage.setMaxHeight(1440);
			primaryStage.setMaxWidth(810);



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
