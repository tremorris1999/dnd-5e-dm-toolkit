package dmtoolkit.views;

import java.util.LinkedList;

import dmtoolkit.components.StatViewLabel;
import dmtoolkit.components.StatViewScrollPane;
import dmtoolkit.components.StatViewScrollPaneListView;
import dmtoolkit.components.StatViewScrollPaneTextArea;
import dmtoolkit.components.StatViewVBox;
import dmtoolkit.components.StatViewVBoxHBox;
import dmtoolkit.components.StatViewVBoxHBoxButton;
import dmtoolkit.components.StatViewVBoxHBoxTextArea;
import dmtoolkit.components.StatViewVBoxImageView;
import dmtoolkit.entities.StatBlock;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class StatView extends BorderPane
{
	private RootView parent;
	private double width;
	private double height;
	private StatViewLabel statNameLabel;
	private StatViewScrollPaneTextArea statData;
	private StatViewVBoxHBoxTextArea[] stats;
	private LinkedList<StatBlock> statBlocks;
	private StatViewVBoxImageView statImage;
	private StatViewVBox rightHolder;

	public StatView(final RootView parent, final LinkedList<StatBlock> statBlocks)
	{
		super();
		this.statBlocks = statBlocks;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				StatView.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: blanchedalmond");





		// left setup
		StatViewVBox leftHolder = new StatViewVBox(this, 0.2, 1);

		StatViewLabel statLabel = new StatViewLabel(leftHolder, "Stat Block Index");
		StatViewScrollPane statIndex = new StatViewScrollPane(leftHolder, 0.9);
		StatViewScrollPaneListView statList = new StatViewScrollPaneListView(statIndex,this.statBlocks);
		statIndex.setContent(statList);

		leftHolder.getChildren().add(statLabel);
		leftHolder.getChildren().add(statIndex);

		this.setLeft(leftHolder);





		// center setup
		StatViewVBox centerHolder = new StatViewVBox(this, 0.6, 1);

		this.statNameLabel = new StatViewLabel(centerHolder, "");
		statList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<StatBlock>() {

			@Override
			public void onChanged(final Change<? extends StatBlock> arg0)
			{
				StatView.this.setStatNameLabelText(arg0.getList().get(0).getName());
				StatView.this.setStatDataText(arg0.getList().get(0).fullData());
				StatView.this.setImage(arg0.getList().get(0).getImgPath());
				StatView.this.getStats()[0].setText(arg0.getList().get(0).modStr());
				StatView.this.getStats()[1].setText(arg0.getList().get(0).modDex());
				StatView.this.getStats()[2].setText(arg0.getList().get(0).modCon());
				StatView.this.getStats()[3].setText(arg0.getList().get(0).modIntl());
				StatView.this.getStats()[4].setText(arg0.getList().get(0).modWis());
				StatView.this.getStats()[5].setText(arg0.getList().get(0).modCha());

			}

		});

		StatViewScrollPane statDataPane = new StatViewScrollPane(centerHolder, 0.8);

		this.statData = new StatViewScrollPaneTextArea(statDataPane);
		this.statData.setWrapText(true);
		this.statData.setEditable(false);

		statDataPane.setContent(this.statData);

		StatViewVBoxHBox statControls = new StatViewVBoxHBox(centerHolder, 1, 0.1);

		StatViewVBoxHBoxButton addInstanceBtn = new StatViewVBoxHBoxButton(statControls, "Add to Combat");
		StatViewVBoxHBoxButton addStatBtn = new StatViewVBoxHBoxButton(statControls, "New Stat Block");
		StatViewVBoxHBoxButton deleteStatBtn = new StatViewVBoxHBoxButton(statControls, "Delete Stat Block");

		statControls.getChildren().addAll(addInstanceBtn, addStatBtn, deleteStatBtn);


		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);
		centerHolder.setAlignment(Pos.CENTER);

		this.setCenter(centerHolder);






		// right setup
		this.rightHolder = new StatViewVBox(this, 0.2, 1);

		this.statImage = new StatViewVBoxImageView(this.rightHolder, "./img/placeholder.png");

		StatViewVBox statShort = new StatViewVBox(this, 0.2, 0.60);

		StatViewVBoxHBox statASL1 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);
		StatViewVBoxHBox statAS1 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);
		StatViewVBoxHBox statASL2 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);
		StatViewVBoxHBox statAS2 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);
		StatViewVBoxHBox statASL3 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);
		StatViewVBoxHBox statAS3 = new StatViewVBoxHBox(statShort, 0.5, 1.0/6.0);

		StatViewVBoxHBoxTextArea str = new StatViewVBoxHBoxTextArea(statAS1, "");
		str.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		StatViewVBoxHBoxTextArea dex = new StatViewVBoxHBoxTextArea(statAS1, "");
		dex.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		StatViewVBoxHBoxTextArea con = new StatViewVBoxHBoxTextArea(statAS2, "");
		con.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		StatViewVBoxHBoxTextArea intl = new StatViewVBoxHBoxTextArea(statAS2, "");
		intl.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		StatViewVBoxHBoxTextArea wis = new StatViewVBoxHBoxTextArea(statAS3, "");
		wis.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		StatViewVBoxHBoxTextArea cha = new StatViewVBoxHBoxTextArea(statAS3, "");
		cha.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");

		this.stats = new StatViewVBoxHBoxTextArea[6];
		this.stats[0] = str;
		this.stats[1] = dex;
		this.stats[2] = con;
		this.stats[3] = intl;
		this.stats[4] = wis;
		this.stats[5] = cha;

		statASL1.getChildren().addAll(new StatViewVBoxHBoxTextArea(statASL1, "STR"), new StatViewVBoxHBoxTextArea(statAS1, "DEX"));
		statAS1.getChildren().addAll(str, dex);
		statASL2.getChildren().addAll(new StatViewVBoxHBoxTextArea(statASL1, "CON"), new StatViewVBoxHBoxTextArea(statAS1, "INT"));
		statAS2.getChildren().addAll(con, intl);
		statASL3.getChildren().addAll(new StatViewVBoxHBoxTextArea(statASL1, "WIS"), new StatViewVBoxHBoxTextArea(statAS1, "CHA"));
		statAS3.getChildren().addAll(wis, cha);

		statShort.getChildren().addAll(statASL1, statAS1, statASL2, statAS2, statASL3, statAS3);

		this.rightHolder.getChildren().addAll(this.statImage, statShort);;
		this.rightHolder.setAlignment(Pos.CENTER);

		this.setRight(this.rightHolder);


	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.75;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
		this.rightHolder.setPadding(new Insets(this.height * 0.02, 0, 0, 0));
	}

	public double getCalcWidth()
	{
		return this.width;
	}

	public double getCalcHeight()
	{
		return this.height;
	}

	public void setStatNameLabelText(final String text)
	{
		this.statNameLabel.setText(text);
	}

	public void setStatDataText(final String text)
	{
		this.statData.setText(text);
	}

	public StatViewVBoxHBoxTextArea[] getStats()
	{
		return this.stats;
	}

	public void setImage(final String url)
	{
		this.statImage = new StatViewVBoxImageView(this.rightHolder, url);
		this.statImage.updateSizes();
		Node otherNode = this.rightHolder.getChildren().remove(1);
		for (int i = 0; i < this.rightHolder.getChildren().size(); i++)
			this.rightHolder.getChildren().remove(i);
		this.rightHolder.getChildren().addAll(this.statImage, otherNode);
	}
}
