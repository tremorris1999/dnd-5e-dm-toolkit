package dmtoolkit.views;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import dmtoolkit.utility.*;


public class NPCView extends BorderPane
{
	public NPCView()
	{
		super();
		this.setStyle("-fx-background-color: black");

		// left
		Label leftLabel = new Label("NPC's");
		leftLabel.setStyle("-fx-background-color: white; -fx-font-size: 24; -fx-alignment: center;");
		leftLabel.setMinSize(300, 50);

		HBox npcMenu = new HBox();
		npcMenu.setStyle("-fx-background-color: white;");		

		ScrollPane statList = new ScrollPane();
		statList.setMinSize(300, 850);
		
		FlowPane npcListContainer = new FlowPane();
		npcListContainer.setStyle("-fx-background-color: white;");
		npcListContainer.setMaxSize(300, 850);
		npcListContainer.setMinSize(300, 850);		
		
		Button createNPCBtn = new Button("Create NPC");
		Button deleteLastBtn = new Button("Delete Last");
		
		npcMenu.getChildren().addAll(createNPCBtn, deleteLastBtn);
		
		// center
		// main container for center
		VBox npcContent = new VBox();
		npcContent.setStyle("-fx-background-color: white;");
		
		LinkedList<Button, NPC> ButtonList = new LinkedList<Button, NPC>();
		
		createNPCBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				Button newNPCBtn = new Button("NPC Name");
				NPC npc = new NPC();
				newNPCBtn.setOnAction(e -> showNPC(npc, npcContent));
				ButtonList.add(new Node<Button, NPC>(newNPCBtn, npc));
				npcListContainer.getChildren().add(newNPCBtn);
			}
		});
		
		deleteLastBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				npcListContainer.getChildren().remove(ButtonList.remove().element());
			}
		});
		
		VBox leftHolder = new VBox(leftLabel, npcMenu, npcListContainer);
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
	
	public void reRollNPC(NPC e, String trait, VBox npcContent) {
		e.reRoll(trait);
		showNPC(e, npcContent);
	}
	
	public void showNPC(NPC e, VBox npcContent) {
		npcContent.getChildren().clear();		
		HBox name= new HBox();
		Label nameLabel = new Label("Name: ");
		nameLabel.setStyle("-fx-font-size: 24;");
		name.getChildren().addAll(nameLabel);
		
		HBox appearance = new HBox();
		Label appearanceLabel = new Label("Appearance: ");
		appearanceLabel.setStyle("-fx-font-size: 24;");
		Button reRollApperanceBtn = new Button("reroll");			
		reRollApperanceBtn.setOnAction(event -> reRollNPC(e, "appearance", npcContent));		
		Label appearanceDescription = new Label(e.appearance());
		appearance.getChildren().addAll(appearanceLabel, appearanceDescription, reRollApperanceBtn);
		
		HBox highAbility= new HBox();
		Label highAbilityLabel = new Label("High Ability: ");
		highAbilityLabel.setStyle("-fx-font-size: 24;");
		Label highAbilityDescription = new Label(e.highAbility());
		Button reRollHighAbilityBtn = new Button("reroll");					
		reRollHighAbilityBtn.setOnAction(event -> reRollNPC(e, "highAbility", npcContent));
		highAbility.getChildren().addAll(highAbilityLabel, highAbilityDescription, reRollHighAbilityBtn);
		
		HBox lowAbility= new HBox();
		Label lowAbilityLabel = new Label("Low Ability: ");
		lowAbilityLabel.setStyle("-fx-font-size: 24;");
		Label lowAbilityDescription = new Label(e.lowAbility());
		Button reRollLowAbilityBtn = new Button("reroll");				
		reRollLowAbilityBtn.setOnAction(event -> reRollNPC(e, "lowAbility", npcContent));
		lowAbility.getChildren().addAll(lowAbilityLabel, lowAbilityDescription, reRollLowAbilityBtn);
		
		HBox talents = new HBox();
		Label talentsLabel = new Label("Talents: ");
		talentsLabel.setStyle("-fx-font-size: 24;");
		Label talentsDescription = new Label(e.talents());
		Button reRollTalentsBtn = new Button("reroll");							
		reRollTalentsBtn.setOnAction(event -> reRollNPC(e, "talents", npcContent));
		talents.getChildren().addAll(talentsLabel, talentsDescription, reRollTalentsBtn);
		
		HBox manerisms = new HBox();
		Label manerismsLabel = new Label("Manerisms: ");
		manerismsLabel.setStyle("-fx-font-size: 24;");
		Label manerismsDescription = new Label(e.manerisms());
		Button reRollManerismsBtn = new Button("reroll");						
		reRollManerismsBtn.setOnAction(event -> reRollNPC(e, "manerisms", npcContent));
		manerisms.getChildren().addAll(manerismsLabel, manerismsDescription, reRollManerismsBtn);
	
		HBox interactionTrait = new HBox();
		Label interactionTraitLabel = new Label("Interaction Traits: ");
		interactionTraitLabel.setStyle("-fx-font-size: 24;");
		Label interactionTraitDescription = new Label(e.interactionTraits());
		Button reRollinteractionTraitBtn = new Button("reroll");						
		reRollinteractionTraitBtn.setOnAction(event -> reRollNPC(e, "interactionTraits", npcContent));
		interactionTrait.getChildren().addAll(interactionTraitLabel, interactionTraitDescription, reRollinteractionTraitBtn);
		
		HBox ideas = new HBox();
		Label ideasLabel = new Label("Ideas: ");
		ideasLabel.setStyle("-fx-font-size: 24;");
		Label ideasDescription = new Label(e.ideas());
		Button reRollideasBtn = new Button("reroll");				
		reRollideasBtn.setOnAction(event -> reRollNPC(e, "ideas", npcContent));
		ideas.getChildren().addAll(ideasLabel, ideasDescription, reRollideasBtn);
		
		HBox bonds = new HBox();
		Label bondsLabel = new Label("Bonds: ");
		bondsLabel.setStyle("-fx-font-size: 24;");
		Label bondsDescription = new Label(e.bonds());
		Button reRollBondsBtn = new Button("reroll");
		reRollBondsBtn.setOnAction(event -> reRollNPC(e, "bonds", npcContent));
		bonds.getChildren().addAll(bondsLabel, bondsDescription, reRollBondsBtn);
		
		HBox flawsSecerets= new HBox();
		Label flawsSeceretsLabel = new Label("Flaws n Secerets: ");
		flawsSeceretsLabel.setStyle("-fx-font-size: 24;");
		Label flawsSeceretsDescription = new Label(e.flawsNSecrets());
		Button reRollFlawsSeceretsBtn = new Button("reroll");		
		reRollFlawsSeceretsBtn.setOnAction(event -> reRollNPC(e, "flawsNSecrets", npcContent));
		flawsSecerets.getChildren().addAll(flawsSeceretsLabel, flawsSeceretsDescription, reRollFlawsSeceretsBtn);
		

		npcContent.getChildren().addAll(name, appearance, highAbility, lowAbility, talents, manerisms, interactionTrait, ideas, bonds, flawsSecerets);
		this.setCenter(npcContent);
	}
}
