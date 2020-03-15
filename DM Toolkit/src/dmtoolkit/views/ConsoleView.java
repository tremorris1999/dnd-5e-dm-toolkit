package dmtoolkit.views;

import java.text.SimpleDateFormat;
import java.util.Date;

import dmtoolkit.components.ScaledLabel;
import dmtoolkit.components.ScaledTextArea;
import dmtoolkit.interfaces.Scalable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class ConsoleView extends BorderPane implements Scalable
{
	private Scalable parent;
	private double width;
	private double height;
	private double widthPerc;
	private double heightPerc;
	private ScaledTextArea consoleOut;

	public ConsoleView(final Scalable parent, final double widthPerc, final double heightPerc)
	{
		super();
		this.widthPerc = widthPerc;
		this.heightPerc = heightPerc;

		// parent setup
		this.parent = parent;
		this.parent.widthProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ConsoleView.this.updateSizes();
			}
		});
		this.parent.heightProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(final ObservableValue<? extends Number> value, final Number oldValue, final Number newValue)
			{
				ConsoleView.this.updateSizes();
			}
		});

		// style setup
		this.setStyle("-fx-background-color: black; -fx-border-color: white;");


		// top setup
		ScaledLabel consoleTitle = new ScaledLabel(this, "-----\tConsole:\t -----", 1, 0.1);
		consoleTitle.setStyle("-fx-font-size: 14; -fx-text-fill: white;");
		consoleTitle.setAlignment(Pos.TOP_LEFT);

		this.setTop(consoleTitle);

		// center setup
		this.consoleOut = new ScaledTextArea(this, "", 1, 0.89);
		this.consoleOut.setWrapText(true);
		this.consoleOut.setStyle("-fx-text-fill: white; -fx-control-inner-background: black;");
		this.consoleOut.setEditable(false);

		this.setCenter(this.consoleOut);
	}

	public void log(final String text)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		this.consoleOut.appendText(formatter.format(date) + "\t-\t" + text);
	}

	@Override
	public void updateSizes()
	{
		this.width = this.parent.getCalcWidth() * this.widthPerc;
		this.height = this.parent.getCalcHeight() * this.heightPerc;
		this.setMinWidth(this.width);
		this.setMinHeight(this.height);
		this.setMaxWidth(this.width);
		this.setMaxHeight(this.height);
	}

	@Override
	public Scalable getScaleParent()
	{
		return this.parent;
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

	@Override
	public int getChildCount()
	{
		return this.getChildren().size();
	}
}
