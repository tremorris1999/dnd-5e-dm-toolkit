package dmtoolkit.views;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MainView extends BorderPane
{
	public MainView()
	{
		super();
		this.setBackground(new Background(new BackgroundFill(Paint.valueOf(Color.CADETBLUE.desaturate().desaturate().toString()), CornerRadii.EMPTY, new Insets(0))));
	}
}
