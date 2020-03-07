package dmtoolkit.views;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ConsoleView extends BorderPane
{
	public ConsoleView()
	{
		super();
		this.setMinSize(1440, 175);
		this.setMaxSize(1440, 175);
		this.setStyle("-fx-background-color: black; -fx-border-color: white;");

		Label consoleLabel = new Label("Console:");
		consoleLabel.setStyle(" -fx-font-size: 16; -fx-font-color: white;");
		this.setTop(consoleLabel);
	}
}
