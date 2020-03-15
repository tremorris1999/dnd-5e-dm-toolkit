package dmtoolkit.views;

import dmtoolkit.components.ScaledButton;
import dmtoolkit.components.ScaledHBox;
import dmtoolkit.components.ScaledImageView;
import dmtoolkit.components.ScaledLabel;
import dmtoolkit.components.ScaledListView;
import dmtoolkit.components.ScaledScrollPane;
import dmtoolkit.components.ScaledTextArea;
import dmtoolkit.components.ScaledVBox;
import dmtoolkit.entities.StatBlock;
import dmtoolkit.interfaces.Scalable;
import dmtoolkit.utility.ObservableLinkedList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class StatView extends BorderPane implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private ScaledLabel statNameLabel;
	private ScaledLabel statData;
	private ScaledLabel[] stats;
	private ObservableLinkedList<StatBlock> statBlocks;
	private ScaledImageView statImage;
	private ScaledVBox rightHolder;
	private ScaledListView<StatBlock> statList;
	private ScaledButton deleteStatBtn;
	private ScaledTextArea searchBar;

	public StatView(final RootView parent, final ObservableLinkedList<StatBlock> statBlocks)
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
		ScaledVBox leftHolder = new ScaledVBox(this, 0.2, 1);

		ScaledLabel statLabel = new ScaledLabel(leftHolder, "Stat Block Index", 0.99, 0.10);
		statLabel.setAlignment(Pos.CENTER);
		statLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-font-style: italic;");

		ScaledHBox sbHolder = new ScaledHBox(leftHolder, 1, 0.05);
		sbHolder.setStyle("-fx-border-color: black;");

		ScaledVBox iconHolder = new ScaledVBox(sbHolder, 0.10, 0.99);

		ScaledImageView icon = new ScaledImageView(iconHolder, "./img/searchicon.png");

		iconHolder.getChildren().add(icon);
		iconHolder.setAlignment(Pos.CENTER);

		this.searchBar = new ScaledTextArea(sbHolder, "Search...", 0.88, 0.99);

		sbHolder.getChildren().addAll(iconHolder, this.searchBar);

		ScaledScrollPane statIndex = new ScaledScrollPane(leftHolder, 1, 0.849);
		statIndex.setStyle("-fx-border-color: black;");

		this.statList = new ScaledListView<StatBlock>(statIndex, 0.99, 0.99, this.statBlocks);

		statIndex.setContent(this.statList);

		leftHolder.getChildren().addAll(statLabel, sbHolder, statIndex);

		this.setLeft(leftHolder);

		this.searchBar.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(final ObservableValue<? extends String> observed, final String oldS, final String newS)
			{
				ObservableLinkedList<StatBlock> searchList = new ObservableLinkedList<StatBlock>();
				for (StatBlock sb : StatView.this.statBlocks)
				{
					if (sb.getName().toLowerCase().contains(newS.toLowerCase()))
						searchList.add(sb);
				}
				if (searchList.size() != 0)
					StatView.this.statList.setItems(searchList);
				else
					StatView.this.statList.setItems(new ObservableLinkedList<StatBlock>());
			}

		});





		// center setup
		ScaledVBox centerHolder = new ScaledVBox(this, 0.6, 1);
		centerHolder.setAlignment(Pos.CENTER);

		this.statNameLabel = new ScaledLabel(centerHolder, "", 1, 0.1);

		ScaledScrollPane statDataPane = new ScaledScrollPane(centerHolder, 1, 0.8);

		this.statData = new ScaledLabel(statDataPane, "", 0.95, 1);
		this.statData.setWrapText(true);
		this.statData.setStyle("-fx-font-size: 16");

		statDataPane.setContent(this.statData);
		statDataPane.setPannable(true);

		this.statList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<StatBlock>() {

			@Override
			public void onChanged(final Change<? extends StatBlock> arg0)
			{
				if (arg0.getList().size() != 0)
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

					if (arg0.getList().get(0).isCustom())
						StatView.this.setDeletable(false);
					else
						StatView.this.setDeletable(true);
				}

			}

		});

		ScaledHBox statControls = new ScaledHBox(centerHolder, 1, 0.1);

		ScaledButton addInstanceBtn = new ScaledButton(statControls, "Add to Combat", 1.0 / 3.0 , 1);
		ScaledButton addStatBtn = new ScaledButton(statControls, "New Stat Block", 1.0 / 3.0 , 1);
		this.deleteStatBtn = new ScaledButton(statControls, "Delete Stat Block", 1.0 / 3.0 , 1);

		statControls.getChildren().addAll(addInstanceBtn, addStatBtn, this.deleteStatBtn);

		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);

		this.setCenter(centerHolder);






		// right setup
		this.rightHolder = new ScaledVBox(this, 0.2, 1);

		this.statImage = new ScaledImageView(this.rightHolder, "./img/placeholder.png");

		ScaledVBox statShort = new ScaledVBox(this, 0.2, 0.60);

		ScaledHBox statASL1 = new ScaledHBox(statShort, 0.5, 1.0/6.0);
		ScaledHBox statAS1 = new ScaledHBox(statShort, 0.5, 1.0/6.0);
		ScaledHBox statASL2 = new ScaledHBox(statShort, 0.5, 1.0/6.0);
		ScaledHBox statAS2 = new ScaledHBox(statShort, 0.5, 1.0/6.0);
		ScaledHBox statASL3 = new ScaledHBox(statShort, 0.5, 1.0/6.0);
		ScaledHBox statAS3 = new ScaledHBox(statShort, 0.5, 1.0/6.0);

		ScaledLabel str = new ScaledLabel(statAS1, "", 1, 1);
		str.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		ScaledLabel dex = new ScaledLabel(statAS1, "", 1, 1);
		dex.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		ScaledLabel con = new ScaledLabel(statAS2, "", 1, 1);
		con.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		ScaledLabel intl = new ScaledLabel(statAS2, "", 1, 1);
		intl.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		ScaledLabel wis = new ScaledLabel(statAS3, "", 1, 1);
		wis.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		ScaledLabel cha = new ScaledLabel(statAS3, "", 1, 1);
		cha.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");

		this.stats = new ScaledLabel[6];
		this.stats[0] = str;
		this.stats[1] = dex;
		this.stats[2] = con;
		this.stats[3] = intl;
		this.stats[4] = wis;
		this.stats[5] = cha;

		statASL1.getChildren().addAll(new ScaledLabel(statASL1, "STR", 1, 1), new ScaledLabel(statAS1, "DEX", 1, 1));
		statAS1.getChildren().addAll(str, dex);
		statASL2.getChildren().addAll(new ScaledLabel(statASL1, "CON", 1 , 1), new ScaledLabel(statAS1, "INT", 1, 1));
		statAS2.getChildren().addAll(con, intl);
		statASL3.getChildren().addAll(new ScaledLabel(statASL1, "WIS", 1, 1), new ScaledLabel(statAS1, "CHA", 1, 1));
		statAS3.getChildren().addAll(wis, cha);

		statShort.getChildren().addAll(statASL1, statAS1, statASL2, statAS2, statASL3, statAS3);

		this.rightHolder.getChildren().addAll(this.statImage, statShort);;
		this.rightHolder.setAlignment(Pos.CENTER);

		this.setRight(this.rightHolder);


	}

	@Override
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

	@Override
	public double getCalcWidth()
	{
		return this.width;
	}

	@Override
	public double getCalcHeight()
	{
		return this.height;
	}

	public void setStatList(final ObservableLinkedList<StatBlock> list)
	{
		Scalable parent = this.statList.getScaleParent();
		this.statList = new ScaledListView<StatBlock>(parent, 0.99, 0.99, new ObservableLinkedList<StatBlock>());
	}

	public void setStatNameLabelText(final String text)
	{
		this.statNameLabel.setText(text);
	}

	public void setStatDataText(final String text)
	{
		this.statData.setText(text);
	}

	public ScaledLabel[] getStats()
	{
		return this.stats;
	}

	public void setDeletable(final boolean b)
	{
		this.deleteStatBtn.setDisable(b);
	}

	public void setImage(final String url)
	{
		this.statImage = new ScaledImageView(this.rightHolder, url);
		this.statImage.updateSizes();
		Node otherNode = this.rightHolder.getChildren().remove(1);
		for (int i = 0; i < this.rightHolder.getChildren().size(); i++)
			this.rightHolder.getChildren().remove(i);
		this.rightHolder.getChildren().addAll(this.statImage, otherNode);
	}

	@Override
	public Scalable getScaleParent()
	{
		return this.parent;
	}

	@Override
	public int getChildCount()
	{
		return this.getChildren().size();
	}
}
