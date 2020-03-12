package dmtoolkit.views;

import java.util.LinkedList;

import dmtoolkit.components.GenericViewLabel;
import dmtoolkit.components.GenericViewScrollPane;
import dmtoolkit.components.GenericViewScrollPaneListView;
import dmtoolkit.components.GenericViewScrollPaneTextArea;
import dmtoolkit.components.GenericViewVBox;
import dmtoolkit.components.GenericViewVBoxHBox;
import dmtoolkit.components.GenericViewVBoxHBoxButton;
import dmtoolkit.components.GenericViewVBoxHBoxTextArea;
import dmtoolkit.components.GenericViewVBoxImageView;
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
	private GenericViewLabel<StatView> statNameLabel;
	private GenericViewScrollPaneTextArea<StatView> statData;
	private GenericViewVBoxHBoxTextArea[] stats;
	private LinkedList<StatBlock> statBlocks;
	private GenericViewVBoxImageView<StatView> statImage;
	private GenericViewVBox<StatView> rightHolder;

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
		GenericViewVBox<StatView> leftHolder = new GenericViewVBox<StatView>(this, 0.2, 1);

		GenericViewLabel<StatView> statLabel = new GenericViewLabel<StatView>(leftHolder, "Stat Block Index");
		GenericViewScrollPane<StatView> statIndex = new GenericViewScrollPane<StatView>(leftHolder, 0.9);
		GenericViewScrollPaneListView<StatView, StatBlock> statList = new GenericViewScrollPaneListView<StatView, StatBlock>(statIndex,this.statBlocks);
		statIndex.setContent(statList);

		leftHolder.getChildren().add(statLabel);
		leftHolder.getChildren().add(statIndex);

		this.setLeft(leftHolder);





		// center setup
		GenericViewVBox<StatView> centerHolder = new GenericViewVBox<StatView>(this, .6, 1);
//		StatViewVBox centerHolder = new StatViewVBox(this, 0.6, 1);

		this.statNameLabel = new GenericViewLabel<StatView>(centerHolder, "");
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

		GenericViewScrollPane<StatView> statDataPane = new GenericViewScrollPane<StatView>(centerHolder, 0.8);

		this.statData = new GenericViewScrollPaneTextArea<StatView>(statDataPane);
		this.statData.setWrapText(true);
		this.statData.setEditable(false);

		statDataPane.setContent(this.statData);

		GenericViewVBoxHBox<StatView> statControls = new GenericViewVBoxHBox<StatView>(centerHolder, 1, 0.1);

		GenericViewVBoxHBoxButton<StatView> addInstanceBtn = new GenericViewVBoxHBoxButton<StatView>(statControls, "Add to Combat");
		GenericViewVBoxHBoxButton<StatView> addStatBtn = new GenericViewVBoxHBoxButton<StatView>(statControls, "New Stat Block");
		GenericViewVBoxHBoxButton<StatView> deleteStatBtn = new GenericViewVBoxHBoxButton<StatView>(statControls, "Delete Stat Block");

		statControls.getChildren().addAll(addInstanceBtn, addStatBtn, deleteStatBtn);


		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);
		centerHolder.setAlignment(Pos.CENTER);

		this.setCenter(centerHolder);






		// right setup
		this.rightHolder = new GenericViewVBox<StatView>(this, 0.2, 1);

		this.statImage = new GenericViewVBoxImageView<StatView>(this.rightHolder, "./img/placeholder.png");

		GenericViewVBox<StatView> statShort = new GenericViewVBox<StatView>(this, 0.2, 0.60);

		GenericViewVBoxHBox<StatView> statASL1 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);
		GenericViewVBoxHBox<StatView> statAS1 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);
		GenericViewVBoxHBox<StatView> statASL2 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);
		GenericViewVBoxHBox<StatView> statAS2 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);
		GenericViewVBoxHBox<StatView> statASL3 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);
		GenericViewVBoxHBox<StatView> statAS3 = new GenericViewVBoxHBox<StatView>(statShort, 0.5, 1.0/6.0);

		GenericViewVBoxHBoxTextArea<StatView> str = new GenericViewVBoxHBoxTextArea<StatView>(statAS1, "");
		str.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		GenericViewVBoxHBoxTextArea<StatView> dex = new GenericViewVBoxHBoxTextArea<StatView>(statAS1, "");
		dex.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		GenericViewVBoxHBoxTextArea<StatView> con = new GenericViewVBoxHBoxTextArea<StatView>(statAS2, "");
		con.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		GenericViewVBoxHBoxTextArea<StatView> intl = new GenericViewVBoxHBoxTextArea<StatView>(statAS2, "");
		intl.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		GenericViewVBoxHBoxTextArea<StatView> wis = new GenericViewVBoxHBoxTextArea<StatView>(statAS3, "");
		wis.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");
		GenericViewVBoxHBoxTextArea<StatView> cha = new GenericViewVBoxHBoxTextArea<StatView>(statAS3, "");
		cha.setStyle("-fx-font-size: 18; -fx-font-weight: normal;");

		this.stats = new GenericViewVBoxHBoxTextArea[6];
		this.stats[0] = str;
		this.stats[1] = dex;
		this.stats[2] = con;
		this.stats[3] = intl;
		this.stats[4] = wis;
		this.stats[5] = cha;

		statASL1.getChildren().addAll(new GenericViewVBoxHBoxTextArea<StatView>(statASL1, "STR"), new GenericViewVBoxHBoxTextArea<StatView>(statAS1, "DEX"));
		statAS1.getChildren().addAll(str, dex);
		statASL2.getChildren().addAll(new GenericViewVBoxHBoxTextArea<StatView>(statASL1, "CON"), new GenericViewVBoxHBoxTextArea<StatView>(statAS1, "INT"));
		statAS2.getChildren().addAll(con, intl);
		statASL3.getChildren().addAll(new GenericViewVBoxHBoxTextArea<StatView>(statASL1, "WIS"), new GenericViewVBoxHBoxTextArea<StatView>(statAS1, "CHA"));
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

	public GenericViewVBoxHBoxTextArea[] getStats()
	{
		return this.stats;
	}

	public void setImage(final String url)
	{
		this.statImage = new GenericViewVBoxImageView<StatView>(this.rightHolder, url);
		this.statImage.updateSizes();
		Node otherNode = this.rightHolder.getChildren().remove(1);
		for (int i = 0; i < this.rightHolder.getChildren().size(); i++)
			this.rightHolder.getChildren().remove(i);
		this.rightHolder.getChildren().addAll(this.statImage, otherNode);
	}
}
