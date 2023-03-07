package main;
import items.MinorHealthPotion;
import weapons.Cutit;
import enemies.Enemies;
import enemies.giantRat;;


public class MainStory {
	
	MainGame game;; 
	UI ui = new UI(); 
	VisibilityManager vm;
	Player player = new Player();
	public static int indexItems = 0;
	public static int indexArmors = 0;
	public static boolean inFight = false;

	SoundEffects curentBgMusic =  new SoundEffects();
	SoundEffects introSea = new SoundEffects(), beach = new SoundEffects(), forest = new SoundEffects(), crossroad = new SoundEffects(), monastery = new SoundEffects(), 
			     banditcamp = new SoundEffects(), harbortown = new SoundEffects(), inFightMusic = new SoundEffects(); 
	
	public MainStory(MainGame g, UI userI, VisibilityManager vManager) {
		game = g; 
		ui = userI;
		vm = vManager;
		
	}
	
	giantRat giantRat1 = new giantRat();
	
	public void defSetup() {
		
		soundInit();
		ui.hpNumberLabel.setText("" + player.getHp());
	    ui.mpNumberLabel.setText("" + player.getMp());
	    ui.lvlLabel.setText("Nivel: " + player.getLVL());
	    ui.expLabel.setText("Exp: " + player.getExp() + "/" + player.getlvlThreshold());
	    ui.weaponNameLabel.setText("" + player.getWeaponName());
	    ui.armorNameLabel.setText("" + player.getArmorName());
	}
	

	boolean inIntroText1 = false; 
	public void introText1() {
		inIntroText1 = true;
		ui.setBackground("");
		curentBgMusic.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/ambientalBg.wav");
		curentBgMusic.play();
		ui.mainTextArea.setText("Din cauza suferintei pe care o indurau oamenii din cauza zeilor, acestia reusesc cumva sa-i alunge din aceasta lume, dar in acest proces altceva a fost eliberat.");
		ui.choice1.setText(" > ");
		ui.choice2.setText("...");
		ui.choice3.setText("...");
		ui.choice4.setText("...");
		game.nextPosition1 = "introText2";
		game.nextPosition2 = ""; 
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	boolean inIntroText2 = false; 
	public void introText2() {
		inIntroText1 = false;
		inIntroText2 = true;
		ui.mainTextArea.setText("Ceva mai vechi decat existenta omului. Titanii...");
		ui.choice1.setText(" > ");
		ui.choice2.setText("...");
		ui.choice3.setText("...");
		ui.choice4.setText("...");
		game.nextPosition1 = "introText3";
		game.nextPosition2 = ""; 
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void introText3() {
		ui.setBackground("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Backgrounds/Intro.gif");
		introSea.play();
		ui.mainTextArea.setText("In acest moment cativa oameni curajosi alaturi de marele inchizitor Mendoza incearca sa captureze unul dintre acesti titani, titanul de apa, Maara. Tu esti unul dintre membrii echipajului.");
		ui.choice1.setText(" > ");
		ui.choice2.setText("...");
		ui.choice3.setText("...");
		ui.choice4.setText("...");
		game.nextPosition1 = "introText4";
		game.nextPosition2 = ""; 
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void introText4() {
		ui.mainTextArea.setText("Dar chiar si cu ajutorul inchizitorului Mendoza, Maara este un adversar de temut. Titanul distruge vasul pe care te aflii si totul se intuneca");
		ui.choice1.setText(" Trezeste-te ");
		ui.choice2.setText("...");
		ui.choice3.setText("...");
		ui.choice4.setText("...");
		game.nextPosition1 = "startGame";
		game.nextPosition2 = ""; 
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	private boolean firstEncounterBeach = false; 
	public void beachStart() {
		introSea.stop();
		inFightMusic.stop();
		forest.stop();
		beach.play();
		ui.setBackground("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Backgrounds/beach.jpg");
		if(!firstEncounterBeach) {
		ui.mainTextArea.setText("Te-ai trezit pe o plaja pustie. In jurul tau vezi doar resturi ale vasului pe care ai fost. Ti-e frig, nu ai nici o arma care sa te apere de pericolele acestei insule.\n\n Ce vei face?");
		ui.choice1.setText("Caut alti supravietuitori");
		ui.choice2.setText("Ma duc inspre padure");
		ui.choice3.setText("Caut printre resturi");
		ui.choice4.setText("...");
		game.nextPosition1 = "CheckSur";
		game.nextPosition2 = "GoForest"; 
		game.nextPosition3 = "CheckDebr";
		game.nextPosition4 = "";
		firstEncounterBeach = true;
		}
		else if(player.getWeaponName() == "Pumni"){
			ui.mainTextArea.setText("Ar trebui sa cauti o arma prin imprejur...\n\n Ce vei face?");
			ui.choice1.setText("Caut alti supravietuitori");
			ui.choice2.setText("Ma duc inspre padure");
			ui.choice3.setText("Caut printre resturi");
			ui.choice4.setText("...");
			game.nextPosition1 = "CheckSur";
			game.nextPosition2 = "GoForest"; 
			game.nextPosition3 = "CheckDebr";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("Ai deja o arma cu care te poti apara, dar inca nu esti in siguranta. Exploreaza zona...\n\n Ce vei face?");
			ui.choice1.setText("Caut alti supravietuitori");
			ui.choice2.setText("Ma duc inspre padure");
			ui.choice3.setText("Caut printre resturi");
			ui.choice4.setText("...");
			game.nextPosition1 = "CheckSur";
			game.nextPosition2 = "GoForest"; 
			game.nextPosition3 = "CheckDebr";
			game.nextPosition4 = "";
		}
		
	}
	
	private int index = 0;
	private boolean visitedSur = false;
	private boolean keyFound = false;
	public void checkSur() {
		if(!visitedSur) {
		forest.stop();
		ui.mainTextArea.setText("Nu ai gasit nici un supravietuitor, dar in schimb, la unul dintre cadavre, ai gasit o cheie");	
		ui.choice1.setText(" > ");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		game.nextPosition1 = "checkedSur";
		visitedSur = true;
		keyFound = true;
		}
		else {
			ui.mainTextArea.setText("Nu exista supravietuitori...");
			ui.choice1.setText(" > ");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "checkedSur";
		}
	}
	
	private int visitedForest = 0;
	public void goForest() {
		beach.stop();
		forest.play();

		if(giantRat1.getHp() <= 0) {
		   visitedForest = 1;
		}
		if(visitedForest == 0) {
		ui.setBackground("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Backgrounds/forest.jpg");
		//player.i.showWInv(ui, cHandler);
		ui.mainTextArea.setText("O carare se iveste prin padure, dar din pacate e blocata de un \n" + giantRat1.getName() + "\n\nHP: " + giantRat1.getHp() + " | DMG:  " + giantRat1.getLvl() * 3 + " | Rezistenta: " + giantRat1.getRes() +"\n\n Ce vei face?");
		ui.choice1.setText("Atac");
		ui.choice2.setText("Fug");
		ui.choice3.setText("...");
		ui.choice4.setText("...");
		game.nextPosition1 = "AtackGiantRat"; 
		game.nextPosition2 = "Run"; 
      
		}
		else {
			ui.setBackground("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Backgrounds/forest.jpg");
			beach.stop();
			forest.play();
			ui.mainTextArea.setText("O carare se iveste prin padure. Drumul este liber." + "\n\n Ce vei face?");
			ui.choice1.setText("Urmaresc cararea");
			ui.choice2.setText("Plec");
			ui.choice3.setText("...");
			ui.choice4.setText("...");
			game.nextPosition1 = "firstForestRoad";
			game.nextPosition2 = "Run"; 
		}
		
	}
	
	private boolean chestOpened = false; 
	public void checkDebr() {
		if(!chestOpened) {
			ui.mainTextArea.setText("Ai gasit un cufar mic printre resturi in nisip. \n\n Ce vei face?");
			ui.choice1.setText(" Deschide cufarul");
			ui.choice2.setText("Pleaca");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "openBeachChest";
			game.nextPosition2 = "leaveBeachDebr"; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			
			ui.mainTextArea.setText("Nu mai este nimic de facut aici...");
			ui.choice1.setText("Pleaca");
		    ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "leaveBeachDebr";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		  }
	}
	

	public void openBeachChest() {

		if(keyFound) {
			Cutit cutit = new Cutit();
			MinorHealthPotion healthPotion = new MinorHealthPotion();
			ui.mainTextArea.setText("Ai deschis cufarul. In cufar se afla un cutit si doua potiuni de viata. \n(Cutitul ar putea fi folosit ca o arma)\n Pentru a echipa arma acceseaza inventarul\n\n Ai primit " + cutit.getName() + " si " + healthPotion.getName() + " x2");
			player.addWeap(cutit, index, ui);
			player.getInventory().showWInv(game.ui, game.cHandler, index++);
			player.addItems(healthPotion, indexItems);
			player.getInventory().showItInv(game.ui, game.cHandler, indexItems++);
			player.addItems(healthPotion, indexItems);
			player.getInventory().showItInv(game.ui, game.cHandler, indexItems++);
			ui.choice1.setText("Pleaca");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "leaveBeachDebr";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			chestOpened = true;
		}
		else {
			ui.mainTextArea.setText("Cufarul este inchis. Ai nevoie de o cheie ca sa-l poti deschide.");
			ui.choice1.setText(" Deschide cufarul");
			ui.choice2.setText("Pleaca");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "openBeachChest";
			game.nextPosition2 = "leaveBeachDebr"; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	

	public void crossRoad() {
		ui.setBackground("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Backgrounds/Crossroad.jpg");
		ui.mainTextArea.setText("Te afli la o rascruce de drumuri. \n\nCe vei face? ");
		ui.choice1.setText("Mergi la nord");
		ui.choice2.setText("Mergi la sud");
		ui.choice3.setText("Mergi la est");
		ui.choice4.setText("Mergi la vest");
		game.nextPosition1 = "goNorth";
		game.nextPosition2 = "goSouth"; 
		game.nextPosition3 = "goEst";
		game.nextPosition4 = "goWest";
 
	}
	
	
	public void crossRoadSouth() {
		beachStart();
	}
	
	public void crossRoadNorth() {
		
	}
	
     public void crossRoadEst() {
		
	}
     
     public void crossRoadWest() {
 		
 	}
	
	public void checkRoundAttack(Enemy e) {
	}
	
	/*
	public void saveGame() {
		try {
			BufferedWriter save = new BufferedWriter(new FileWriter("save.txt"));
			save.write("" + Player.level);
			save.newLine();
			save.write("" + Player.lp);
			save.newLine();
			save.write("" + Player.exp);
			save.newLine();
			save.write("" + Player.lvlThresHold);
			save.newLine();
			save.write("" + Player.baseDmg);
			save.newLine();
			save.write("" + Player.baseDmg);
			save.newLine();
			save.write("" + Player.hp);
			save.newLine();
			save.write("" + Player.mp);
			save.newLine();
			save.write("" + Player.str);
			save.newLine();
			save.write("" + Player.wis);
			save.newLine();
			save.write("" + Player.wis);
			save.newLine();
			save.write("" + Player.phisicalDmg);
			save.newLine();
			save.write("" + Player.magicalDmg);
			save.newLine();
			save.write("" + Player.basePhisRes);
			save.newLine();
			save.write("" + Player.baseMagicalRes);
			save.newLine();
			for(int i = 0; i < Inventory.w.length; i++) {
				if(Inventory.w[i] != null) {
					save.write("" + Inventory.w[i] + " ");
				}
			}
			
			
			ui.mainTextArea.setText("Jocul a fost salvat cu succes!");
			save.close();
			 
		}
		catch(Exception e) {
			ui.mainTextArea.setText("A aparut o eroare in timpul salvarii jocului!");
		}
	}
	
	 
	public void loadGame() {
		try {
			BufferedReader save = new BufferedReader(new FileReader("save.txt"));
			Player.level = Integer.parseInt(save.readLine());
			Player.lp = Integer.parseInt(save.readLine());
			Player.exp = Integer.parseInt(save.readLine());
			Player.lvlThresHold = Integer.parseInt(save.readLine());
			Player.baseDmg = Integer.parseInt(save.readLine());
			Player.hp = Integer.parseInt(save.readLine());
			Player.mp = Integer.parseInt(save.readLine());
	 
			save.close();
			 
		}
		catch(Exception e) {
			ui.mainTextArea.setText("A aparut o eroare in timpul salvarii jocului!");
		}
	}
	*/
	
	
	public void soundInit() {
		beach.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/beach.wav");
		forest.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/forest.wav");
		introSea.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/introS.wav");
	}
	
	
	
	public void enemyAttack(Player pl, UI ui, Enemies e) {
		SoundEffects monsterattack = new SoundEffects();
		monsterattack.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/enemyAttack.wav");
		int enemyDMG = new java.util.Random().nextInt(e.getLvl()*5);
		int dmgdeatl = 0;
		Player.attacked = 0;
		monsterattack.playOnce();
		if(enemyDMG < pl.getBasePhisRes())
			dmgdeatl = 0;
		else
		    dmgdeatl = enemyDMG - (pl.getBasePhisRes());
		
		ui.mainTextArea.setText("Inamicul " +"'" + e.getName() + "'" +  " a provocat " + dmgdeatl + " daune"  + "\n\nHP: " + e.getHp() + " | DMG:  " + e.getLvl() * 3 + " | Rezistenta: " + e.getRes() +"\n\n Ce vei face?");
		pl.setHp(player.getHp() - dmgdeatl);
		ui.hpNumberLabel.setText(""+ pl.getHp());
		player.updateStatusUi(ui);
		if(e.getHp() > 0) {
		ui.choice1.setText("Ataca");
		ui.choice2.setText("Paraseste lupta");
		ui.choice3.setText("");
		ui.choice4.setText("");
		game.nextPosition1 = "AtackGiantRat";
		game.nextPosition2 = "runFrom1stGiantRat"; 
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}
		else {
			ui.choice1.setText("Pleaca");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "runFrom1stGiantRat";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		
		if(player.getHp() <=0) {
			ui.mainTextArea.setText("Ai murit!");
			player = new Player();
			ui.choice1.setText(">");
			ui.choice2.setText("...");
			ui.choice3.setText("...");
			ui.choice4.setText("...");
			game.nextPosition1 = "startGame";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";

		}
	}
	
	public void fight(Player p, UI ui, Enemies e) {
		if(e.getHp() > 0 && inFight == false) {
			inFightMusic.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/inFight.wav");
			inFightMusic.play();
		}
 
		inFight = true;
		if(player.getHp() > 0 || e.getHp() > 0) {
			if(Player.attacked == 0) {
				player.playerAttack(giantRat1, ui, game); 
				inFight = true;
			}
			else {
				enemyAttack(player, ui, giantRat1);
				inFight = true;
			}
		}
		else {
			inFight = false;
		}
	}
	
	
	public void selectPosition(String nextPosition) { 
		switch(nextPosition) {
		 
		case "introText2": introText2(); break;
		case "introText3": introText3(); break;
		case "introText4": introText4(); break;
		case "startGame": beachStart(); vm.showGameCont(); break;
		case "CheckSur": checkSur(); break; 
		case "GoForest": goForest(); break;
		case "CheckDebr": checkDebr(); break;
		case "openBeachChest": openBeachChest(); break;
		case "leaveBeachDebr": beachStart(); break;
		case "checkedSur": beachStart(); break;
		case "AtackGiantRat": fight(player, ui, giantRat1); break;
		case "runFrom1stGiantRat": beachStart();
		case "Run":beachStart(); break;
		case "firstForestRoad": crossRoad(); break;
		case "goSouth": beachStart(); break;
		case "dead": introText1();break;
		}
	}

}


