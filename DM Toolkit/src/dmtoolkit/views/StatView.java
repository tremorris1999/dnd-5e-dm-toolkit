package dmtoolkit.views;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class StatView extends BorderPane
{
	public StatView()
	{
		super();
		this.setStyle("-fx-background-color: blanchedalmond");

		// left
		Label leftLabel = new Label("Stat Block Index");
		leftLabel.setStyle("-fx-background-color: white; -fx-font-size: 24; -fx-alignment: center;");
		leftLabel.setMinSize(300, 50);

		ScrollPane statList = new ScrollPane();
		statList.setMinSize(300, 850);

		VBox leftHolder = new VBox(leftLabel, statList);
		leftHolder.setStyle("-fx-border-color: black;");

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
		rightHolder.setStyle("-fx-background-color: white; -fx-border-color: black;");

		this.setRight(rightHolder);

	}
}
