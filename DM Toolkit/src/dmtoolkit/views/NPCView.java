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
import dmtoolkit.utility.NPC;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class NPCView extends BorderPane
{
	private RootView parent;
	private double width;
	private double height;
	private GenericViewLabel<NPCView> statNameLabel;
	private GenericViewScrollPaneTextArea<NPCView> statData;
	private GenericViewVBoxHBoxTextArea[] stats;
	private LinkedList<NPC> statBlocks;
	private GenericViewVBoxImageView<NPCView> statImage;
	private GenericViewVBox<NPCView> rightHolder;
	private GenericViewScrollPaneListView<NPCView, NPC> statList;

	public NPCView(final RootView parent, final LinkedList<NPC> statBlocks)	
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
				NPCView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				NPCView.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: blanchedalmond");


		// left setup
		GenericViewVBox<NPCView> leftHolder = new GenericViewVBox<NPCView>(this, 0.2, 1);

		GenericViewLabel<NPCView> statLabel = new GenericViewLabel<NPCView>(leftHolder, "NPC's");
		GenericViewScrollPane<NPCView> statIndex = new GenericViewScrollPane<NPCView>(leftHolder, 0.9);
		statList = new GenericViewScrollPaneListView<NPCView, NPC>(statIndex, this.statBlocks);
		statIndex.setContent(statList);
		
		leftHolder.getChildren().add(statLabel);
		leftHolder.getChildren().add(statIndex);

		this.setLeft(leftHolder);

		// center setup
		GenericViewVBox<NPCView> centerHolder = new GenericViewVBox<NPCView>(this, .6, 1);
//		StatViewVBox centerHolder = new StatViewVBox(this, 0.6, 1);

		this.statNameLabel = new GenericViewLabel<NPCView>(centerHolder, "");
		statList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<NPC>() {

			@Override
			public void onChanged(final Change<? extends NPC> arg0)
			{
				NPCView.this.setStatNameLabelText(arg0.getList().get(0).name());
				/*
				NPCView2.this.setStatDataText(arg0.getList().get(0).fullData());
				NPCView2.this.setImage(arg0.getList().get(0).getImgPath());
				NPCView2.this.getStats()[0].setText(arg0.getList().get(0).modStr());
				NPCView2.this.getStats()[1].setText(arg0.getList().get(0).modDex());
				NPCView2.this.getStats()[2].setText(arg0.getList().get(0).modCon());
				NPCView2.this.getStats()[3].setText(arg0.getList().get(0).modIntl());
				NPCView2.this.getStats()[4].setText(arg0.getList().get(0).modWis());
				NPCView2.this.getStats()[5].setText(arg0.getList().get(0).modCha());
				*/

			}

		});

		GenericViewScrollPane<NPCView> statDataPane = new GenericViewScrollPane<NPCView>(centerHolder, 0.8);

		this.statData = new GenericViewScrollPaneTextArea<NPCView>(statDataPane);
		this.statData.setWrapText(true);
		this.statData.setEditable(false);

		statDataPane.setContent(this.statData);

		GenericViewVBoxHBox<NPCView> statControls = new GenericViewVBoxHBox<NPCView>(centerHolder, 1, 0.1);

		GenericViewVBoxHBoxButton<NPCView> addInstanceBtn = new GenericViewVBoxHBoxButton<NPCView>(statControls, "Add NPC");
		GenericViewVBoxHBoxButton<NPCView> deleteStatBtn = new GenericViewVBoxHBoxButton<NPCView>(statControls, "Delete First NPC");
		statControls.getChildren().addAll(addInstanceBtn, deleteStatBtn);
		addInstanceBtn.setOnAction(event -> addNPC());
		deleteStatBtn.setOnAction(event -> removeNPC());
		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);
		centerHolder.setAlignment(Pos.CENTER);

		this.setCenter(centerHolder);






		// right setup
		this.rightHolder = new GenericViewVBox<NPCView>(this, 0.2, 1);

		this.statImage = new GenericViewVBoxImageView<NPCView>(this.rightHolder, "./img/placeholder.png");

		this.rightHolder.getChildren().addAll(this.statImage);//, statShort);;
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
		this.statImage = new GenericViewVBoxImageView<NPCView>(this.rightHolder, url);
		this.statImage.updateSizes();
		Node otherNode = this.rightHolder.getChildren().remove(1);
		for (int i = 0; i < this.rightHolder.getChildren().size(); i++)
			this.rightHolder.getChildren().remove(i);
		this.rightHolder.getChildren().addAll(this.statImage, otherNode);
	}
	
	public void addNPC() {
		NPC npc = new NPC();
		statList.getItems().add(npc);
	}
	
	public void removeNPC() {
		if(statList.getItems().size() > 0)
			statList.getItems().remove(0);		
	}
}
