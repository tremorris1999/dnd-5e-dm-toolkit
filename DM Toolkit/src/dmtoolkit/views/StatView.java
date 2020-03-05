package dmtoolkit.views;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class StatView extends BorderPane
{
	public StatView()
	{
		super();
		this.setBackground(new Background(new BackgroundFill(Paint.valueOf(Color.BLANCHEDALMOND.desaturate().desaturate().toString()), CornerRadii.EMPTY, Insets.EMPTY)));


		// left
		Label leftLabel = new Label("Stat Block Index");
		leftLabel.setBackground(new Background(new BackgroundFill(Paint.valueOf(Color.WHITE.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
		leftLabel.setFont(new Font(24));
		leftLabel.setMinSize(300, 50);
		leftLabel.setAlignment(Pos.CENTER);

		ScrollPane statList = new ScrollPane();
		statList.setMinSize(300, 850);

		VBox leftHolder = new VBox(leftLabel, statList);
		leftHolder.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setLeft(leftHolder);

		//right
		Image statPic = new Image(new File("img/placeholder.png").toURI().toString());
		ImageView iv = new ImageView(statPic);
		iv.setFitHeight(250);
		iv.setFitWidth(250);
		iv.setPreserveRatio(true);

		VBox ivHolder = new VBox(iv);
		ivHolder.setAlignment(Pos.CENTER);
		ivHolder.setMinSize(300, 300);

		TextArea placeholder = new TextArea("Placeholder");
		placeholder.setMinSize(300, 600);
		placeholder.setMaxSize(300, 600);

		VBox rightHolder = new VBox(ivHolder, placeholder);
		rightHolder.setMaxSize(300, 900);
		rightHolder.setMinSize(300, 900);
		rightHolder.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		rightHolder.setBackground(new Background(new BackgroundFill(Paint.valueOf(Color.WHITE.toString()), CornerRadii.EMPTY, Insets.EMPTY)));

		this.setRight(rightHolder);

	}
}
