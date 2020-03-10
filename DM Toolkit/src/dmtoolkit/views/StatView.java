package dmtoolkit.views;

import dmtoolkit.components.StatViewLabel;
import dmtoolkit.components.StatViewScrollPane;
import dmtoolkit.components.StatViewScrollPaneListView;
import dmtoolkit.components.StatViewScrollPaneTextArea;
import dmtoolkit.components.StatViewVBox;
import dmtoolkit.components.StatViewVBoxHBox;
import dmtoolkit.components.StatViewVBoxHBoxButton;
import dmtoolkit.components.StatViewVBoxImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;


public class StatView extends BorderPane
{
	private RootView parent;
	private double width;
	private double height;
	private StatViewLabel statNameLabel;
	private StatViewScrollPaneTextArea statData;

	public StatView(final RootView parent)
	{
		super();

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
		StatViewScrollPaneListView statList = new StatViewScrollPaneListView(statIndex);
		statIndex.setContent(statList);

		leftHolder.getChildren().add(statLabel);
		leftHolder.getChildren().add(statIndex);

		this.setLeft(leftHolder);





		// center setup
		StatViewVBox centerHolder = new StatViewVBox(this, 0.6, 1);

		this.statNameLabel = new StatViewLabel(centerHolder, "");
		statList.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(final Change<? extends String> arg0)
			{
				StatView.this.setStatNameLabelText(arg0.getList().get(0));
				String out = "";
				for (int i = 0; i < Math.random() * 10000; i++)
					out = out + "placeholder text ";
				StatView.this.setStatDataText(out);
			}

		});

		StatViewScrollPane statDataPane = new StatViewScrollPane(centerHolder, 0.8);

		this.statData = new StatViewScrollPaneTextArea(statDataPane);
		this.statData.setWrapText(true);
		this.statData.setEditable(false);

		statDataPane.setContent(this.statData);

		StatViewVBoxHBox statControls = new StatViewVBoxHBox(centerHolder);

		StatViewVBoxHBoxButton addInstanceBtn = new StatViewVBoxHBoxButton(statControls, "Add to Combat");
		StatViewVBoxHBoxButton addStatBtn = new StatViewVBoxHBoxButton(statControls, "New Stat Block");
		StatViewVBoxHBoxButton deleteStatBtn = new StatViewVBoxHBoxButton(statControls, "Delete Stat Block");

		statControls.getChildren().addAll(addInstanceBtn, addStatBtn, deleteStatBtn);


		centerHolder.getChildren().addAll(this.statNameLabel, statDataPane, statControls);
		centerHolder.setAlignment(Pos.CENTER);

		this.setCenter(centerHolder);






		// right setup
		StatViewVBox rightHolder = new StatViewVBox(this, 0.2, 1);

		StatViewVBoxImageView statImage = new StatViewVBoxImageView(rightHolder, "./img/placeholder.png");
		StatViewVBox statShort = new StatViewVBox(this, 0.2, 0.6);

		rightHolder.getChildren().add(statImage);
		rightHolder.getChildren().add(statShort);
		rightHolder.setAlignment(Pos.CENTER);


		this.setRight(rightHolder);


	}

	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth();
		this.height = this.parent.getCalcHeight() * 0.75;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
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
}
