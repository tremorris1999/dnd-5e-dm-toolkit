package dmtoolkit.views;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CombatView extends BorderPane
{
	public CombatView()
	{
		super();
		this.setBackground(new Background(new BackgroundFill(Paint.valueOf(Color.GRAY.desaturate().toString()), CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
