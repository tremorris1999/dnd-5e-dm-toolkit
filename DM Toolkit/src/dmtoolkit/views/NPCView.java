package dmtoolkit.views;

import dmtoolkit.components.ScaledButton;
import dmtoolkit.components.ScaledHBox;
import dmtoolkit.components.ScaledImageView;
import dmtoolkit.components.ScaledLabel;
import dmtoolkit.components.ScaledListView;
import dmtoolkit.components.ScaledScrollPane;
import dmtoolkit.components.ScaledTextArea;
import dmtoolkit.components.ScaledVBox;
import dmtoolkit.interfaces.Scalable;
import dmtoolkit.utility.NPC;
import dmtoolkit.utility.ObservableLinkedList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class NPCView extends BorderPane implements Scalable
{
	private RootView parent;
	private double width;
	private double height;
	private ScaledLabel statNameLabel;
	private ScaledTextArea statData;
	private ScaledTextArea[] stats;
	private ObservableLinkedList<NPC> statBlocks;
	private ScaledImageView statImage;
	private ScaledVBox rightHolder;
	private ScaledListView<NPC> statList;

	public NPCView(final RootView parent, final ObservableLinkedList<NPC> statBlocks)
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
		ScaledVBox leftHolder = new ScaledVBox(this, 0.2, 1);

		ScaledLabel statLabel = new ScaledLabel(leftHolder, "NPC's", 1, 0.1);
		statLabel.setAlignment(Pos.CENTER);

		ScaledScrollPane statIndex = new ScaledScrollPane(leftHolder, 1, 0.9);

		for (int i = 0; i < 3; i++)
			this.statBlocks.add(new NPC());

		this.statList = new ScaledListView<NPC>(statIndex, 0.99, 0.99, this.statBlocks);

		this.statBlocks.add(new NPC()); // FOR ADDING TO LISTVIEW

		this.statList = new ScaledListView<NPC>(statIndex, 0.99, 0.99, this.statBlocks); // YOU HAVE TO RECONSTRUCT AFTER ADDING

		statIndex.setContent(this.statList);

		leftHolder.getChildren().add(statLabel);
		leftHolder.getChildren().add(statIndex);

		this.setLeft(leftHolder);



		// center setup
		ScaledVBox centerHolder = new ScaledVBox(this, 0.6, 1);
		centerHolder.setAlignment(Pos.CENTER);

		this.statNameLabel = new ScaledLabel(centerHolder, "", 1, 0.1);

		this.statList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<NPC>() {

			@Override
			public void onChanged(final Change<? extends NPC> arg0)
			{
				NPCView.this.setStatNameLabelText(arg0.getList().get(0).name());
			}

		});

		ScaledScrollPane statDataPane = new ScaledScrollPane(centerHolder, 1, 0.8);

		this.statData = new ScaledTextArea(statDataPane, "", 1, 1);
		this.statData.setWrapText(true);
		this.statData.setEditable(false);

		statDataPane.setContent(this.statData);

		ScaledHBox statControls = new ScaledHBox(centerHolder, 1, 0.1);

		ScaledButton addInstanceBtn = new ScaledButton(statControls, "Add NPC", 1.0 / 2.0, 1);
		ScaledButton deleteStatBtn = new ScaledButton(statControls, "Delete First NPC", 1.0 / 2.0, 1);
		statControls.getChildren().addAll(addInstanceBtn, deleteStatBtn);
		addInstanceBtn.setOnAction(event -> this.addNPC());
		deleteStatBtn.setOnAction(event -> this.removeNPC());
		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);
		centerHolder.setAlignment(Pos.CENTER);

		this.setCenter(centerHolder);






		// right setup
		this.rightHolder = new ScaledVBox(this, 0.2, 1);

		this.statImage = new ScaledImageView(this.rightHolder, "./img/placeholder.png");

		this.rightHolder.getChildren().addAll(this.statImage);//, statShort);;
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

	public void setStatNameLabelText(final String text)
	{
		this.statNameLabel.setText(text);
	}

	public void setStatDataText(final String text)
	{
		this.statData.setText(text);
	}

	public ScaledTextArea[] getStats()
	{
		return this.stats;
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

	public void addNPC() {
		NPC npc = new NPC();
		this.statList.getItems().add(npc);
	}

	public void removeNPC() {
		if(this.statList.getItems().size() > 0)
			this.statList.getItems().remove(0);
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
