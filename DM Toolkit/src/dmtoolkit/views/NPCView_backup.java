package dmtoolkit.views;

import javafx.scene.layout.BorderPane;


public class NPCView_backup extends BorderPane
{
	/* TODO new comment marker
	public NPCView_backup()
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

		/* Linked list of element type button and object type NPC
	 * This allows a button to be attached to a class of information */ /* TODO new comment marker
		LinkedList<Button, NPC> ButtonList = new LinkedList<Button, NPC>();

		/* Creates a new NPC button and Class and adds it to the ButtonList for managment */ /* TODO new comment marker
		createNPCBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				Button newNPCBtn = new Button("NPC Name");
				NPC npc = new NPC();
				/* when the button is clicked update the content on the page with current button object */ /*T TODO new comment marker
				newNPCBtn.setOnAction(e -> showNPC(npc, npcContent));
				ButtonList.add(new Node<Button, NPC>(newNPCBtn, npc));
				npcListContainer.getChildren().add(newNPCBtn);
			}
		});

		/* Remove a button element from the list and remove it from the container */ /* TODO new comment marker
		deleteLastBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(final ActionEvent arg0)
			{
				if(ButtonList.size() > 0)
					npcListContainer.getChildren().remove(ButtonList.remove().element());
			}
		});

		VBox leftHolder = new VBox(leftLabel, npcMenu, npcListContainer);
		leftHolder.setStyle("-fx-border-color: black;");

		this.setLeft(leftHolder);


		//right
		GenericViewVBox<NPCView_backup> rightHolder = new GenericViewVBox<NPCView_backup>(this, .2, 1);
		GenericViewVBoxImageView<NPCView_backup>statImage = new GenericViewVBoxImageView<NPCView_backup>(rightHolder, "./img/placeholder.png");
		/*
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
		 */
	/*
		VBox rightHolder = new VBox(ivHolder, placeholder);
		rightHolder.setMaxSize(300, 900);
		rightHolder.setMinSize(300, 900);
		rightHolder.setStyle("-fx-background-color: white; -fx-border-color: black;");
	 */ /* TODO new comment marker
	rightHolder.getChildren().add(statImage);
	this.setRight(rightHolder);

}

/* re-roll specific trait and re draw the content view */ /* TODO new comment marker
	public void reRollNPC(NPC object, String trait, VBox npcContent) {
		object.reRoll(trait);
		showNPC(object, npcContent);
	}

	/* show the specified object in the content view */ /* TODO new comment marker
	public void showNPC(NPC object, VBox npcContent) {
		npcContent.getChildren().clear();
		HBox name= new HBox();
		Label nameLabel = new Label("Name: ");
		nameLabel.setStyle("-fx-font-size: 24;");
		name.getChildren().addAll(nameLabel);

		/* Appearance block */ /* TODO new comment marker
		HBox appearance = new HBox();
		Label appearanceLabel = new Label("Appearance: ");
		appearanceLabel.setStyle("-fx-font-size: 24;");
		Button reRollApperanceBtn = new Button("reroll");
		reRollApperanceBtn.setOnAction(event -> reRollNPC(object, "appearance", npcContent));
		Label appearanceDescription = new Label(object.appearance());
		appearance.getChildren().addAll(appearanceLabel, appearanceDescription, reRollApperanceBtn);

		/* High Ability block */ /* TODO new comment marker
		HBox highAbility= new HBox();
		Label highAbilityLabel = new Label("High Ability: ");
		highAbilityLabel.setStyle("-fx-font-size: 24;");
		Label highAbilityDescription = new Label(object.highAbility());
		Button reRollHighAbilityBtn = new Button("reroll");
		reRollHighAbilityBtn.setOnAction(event -> reRollNPC(object, "highAbility", npcContent));
		highAbility.getChildren().addAll(highAbilityLabel, highAbilityDescription, reRollHighAbilityBtn);

		/* Low Ability block */ /*TODO new comment marker
		HBox lowAbility= new HBox();
		Label lowAbilityLabel = new Label("Low Ability: ");
		lowAbilityLabel.setStyle("-fx-font-size: 24;");
		Label lowAbilityDescription = new Label(object.lowAbility());
		Button reRollLowAbilityBtn = new Button("reroll");
		reRollLowAbilityBtn.setOnAction(event -> reRollNPC(object, "lowAbility", npcContent));
		lowAbility.getChildren().addAll(lowAbilityLabel, lowAbilityDescription, reRollLowAbilityBtn);

		/* Talents block */ /* TODO new comment marker
		HBox talents = new HBox();
		Label talentsLabel = new Label("Talents: ");
		talentsLabel.setStyle("-fx-font-size: 24;");
		Label talentsDescription = new Label(object.talents());
		Button reRollTalentsBtn = new Button("reroll");
		reRollTalentsBtn.setOnAction(event -> reRollNPC(object, "talents", npcContent));
		talents.getChildren().addAll(talentsLabel, talentsDescription, reRollTalentsBtn);

		/* Manerisms block */ /* TODO new comment marker
		HBox manerisms = new HBox();
		Label manerismsLabel = new Label("Manerisms: ");
		manerismsLabel.setStyle("-fx-font-size: 24;");
		Label manerismsDescription = new Label(object.manerisms());
		Button reRollManerismsBtn = new Button("reroll");
		reRollManerismsBtn.setOnAction(event -> reRollNPC(object, "manerisms", npcContent));
		manerisms.getChildren().addAll(manerismsLabel, manerismsDescription, reRollManerismsBtn);

		/* Interaction Trait block */ /* TODO new comment marker
		HBox interactionTrait = new HBox();
		Label interactionTraitLabel = new Label("Interaction Traits: ");
		interactionTraitLabel.setStyle("-fx-font-size: 24;");
		Label interactionTraitDescription = new Label(object.interactionTraits());
		Button reRollinteractionTraitBtn = new Button("reroll");
		reRollinteractionTraitBtn.setOnAction(event -> reRollNPC(object, "interactionTraits", npcContent));
		interactionTrait.getChildren().addAll(interactionTraitLabel, interactionTraitDescription, reRollinteractionTraitBtn);

		/* Ideas block */ /* TODO new comment marker
		HBox ideas = new HBox();
		Label ideasLabel = new Label("Ideas: ");
		ideasLabel.setStyle("-fx-font-size: 24;");
		Label ideasDescription = new Label(object.ideas());
		Button reRollideasBtn = new Button("reroll");
		reRollideasBtn.setOnAction(event -> reRollNPC(object, "ideas", npcContent));
		ideas.getChildren().addAll(ideasLabel, ideasDescription, reRollideasBtn);

		/* Bonds block */ /* TODO new comment marker
		HBox bonds = new HBox();
		Label bondsLabel = new Label("Bonds: ");
		bondsLabel.setStyle("-fx-font-size: 24;");
		Label bondsDescription = new Label(object.bonds());
		Button reRollBondsBtn = new Button("reroll");
		reRollBondsBtn.setOnAction(event -> reRollNPC(object, "bonds", npcContent));
		bonds.getChildren().addAll(bondsLabel, bondsDescription, reRollBondsBtn);

		/* Flaws and Secrets block */ /* TODO new comment marker
		HBox flawsSecerets= new HBox();
		Label flawsSeceretsLabel = new Label("Flaws n Secerets: ");
		flawsSeceretsLabel.setStyle("-fx-font-size: 24;");
		Label flawsSeceretsDescription = new Label(object.flawsNSecrets());
		Button reRollFlawsSeceretsBtn = new Button("reroll");
		reRollFlawsSeceretsBtn.setOnAction(event -> reRollNPC(object, "flawsNSecrets", npcContent));
		flawsSecerets.getChildren().addAll(flawsSeceretsLabel, flawsSeceretsDescription, reRollFlawsSeceretsBtn);

		/* update the content view and set to center */ /* TODO new comment marker
		npcContent.getChildren().addAll(name, appearance, highAbility, lowAbility, talents, manerisms, interactionTrait, ideas, bonds, flawsSecerets);
		this.setCenter(npcContent);
	} */
}
