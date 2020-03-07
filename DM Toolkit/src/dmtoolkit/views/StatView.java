package dmtoolkit.views;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;


public class StatView extends BorderPane
{
	private BorderPane root;

	public StatView(final BorderPane root)
	{
		super();
		this.root = root;
		this.setStyle("-fx-background-color: blanchedalmond");

		// left
		Label leftLabel = new Label("Stat Block Index");
		leftLabel.setMinSize(300, 40);
		leftLabel.setMaxSize(300, 40);
		leftLabel.setStyle("-fx-background-color: white; -fx-font-size: 24; -fx-alignment: center;");

		ScrollPane statList = new ScrollPane();
		statList.setMinSize(300, 555);
		statList.setMaxSize(300, 555);

		VBox leftHolder = new VBox(leftLabel,statList);
		leftHolder.setStyle("-fx-border-color: black;");
		leftHolder.setMinSize(300, 595);
		leftHolder.setMinSize(300, 595);
		this.setLeft(leftHolder);

		//center
		TextArea info = new TextArea();
		info.setEditable(false);
		info.appendText("Placeholder for stat block information: \n");
		info.setMinSize(840, 543);
		info.setWrapText(true);

		ScrollPane infoHolder = new ScrollPane(info);
		infoHolder.setMinSize(840, 545);
		infoHolder.setMaxSize(840, 545);
		infoHolder.setHbarPolicy(ScrollBarPolicy.NEVER);
		infoHolder.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		Label statName = new Label("Placeholder name:");
		statName.setMinSize(840, 50);
		statName.setMaxSize(840, 50);
		statName.setTextAlignment(TextAlignment.CENTER);
		statName.setStyle("-fx-background-color: white; -fx-font-size: 24; -fx-alignment: center;");

		VBox centerHolder = new VBox(statName, infoHolder);
		centerHolder.setMinSize(840, 595);
		centerHolder.setMaxSize(840, 595);
		this.setCenter(centerHolder);

		//right
		Image statPic = new Image(new File("img/placeholder.png").toURI().toString());
		ImageView iv = new ImageView(statPic);
		iv.setFitHeight(175);
		iv.setFitWidth(175);
		iv.setPreserveRatio(true);

		VBox ivHolder = new VBox(iv);
		ivHolder.setAlignment(Pos.CENTER);
		ivHolder.setMinSize(200, 200);
		ivHolder.setMaxSize(200, 200);

		TextArea placeholder = new TextArea("Placeholder");
		placeholder.setMinSize(300, 390);
		placeholder.setMaxSize(300, 390);

		VBox rightHolder = new VBox(ivHolder, placeholder);
		rightHolder.setAlignment(Pos.CENTER);
		rightHolder.setMaxSize(300, 595);
		rightHolder.setMinSize(300, 595);
		rightHolder.setStyle("-fx-background-color: white; -fx-border-color: black;");

		this.setRight(rightHolder);

	}
}
