package main;
public class VisibilityManager {
	
	UI ui = new UI();
	Inventory i = new Inventory();
	ChoiceHandlerr c; 
	public VisibilityManager(UI userI) {
		ui = userI;
	}
	
	
	//Setez ecranul de start. Se va vedea doar titlul jocului si cele trei butoane de INCEPE JOC, CONTINUA JOC, IESIRE JOC
	public void showTitleScreen() {
		
		ui.titleNamePanel.setVisible(true);
		ui.startButton.setVisible(true);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.expPanel.setVisible(false);
		ui.lvlUpMsgPanel.setVisible(false);
		 
	}
	
	
	//Setez ecranul de in-game. Se va vedea zona de text, cele doua bari de informatii ale jucatorului si cele 4 butoane de alegeri
	public void startIntro() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
	}
	
	public void showGameCont() {
		ui.titleNamePanel.setVisible(false);
		ui.startButton.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		ui.expPanel.setVisible(true);	
		ui.mainInventory.setVisible(false);
		ui.sortWeaponsPanel.setVisible(false);
		//ui.sortArmorsPanel.setVisible(false);
		ui.statusPanel.setVisible(false);
		ui.upgradePanel.setVisible(false);
	}
	
	//Metoda pentru a iesi din jocul la apasarea butonul IESIRE JOC
	public void exit() {
		ui.window.dispose();
	} 
	
	//Setez true vizibilitatea inventarului, celelalte fiind trecute ca si false(nu se vor mai vedea)
	int isPressedI = 0;
	public void showInventory() {
		
		if(isPressedI == 1) {
			showGameCont();
			isPressedI = 0; 
		}
		else {
			ui.mainTextPanel.setVisible(false);
			ui.choiceButtonPanel.setVisible(false);
			ui.mainInventory.setVisible(true);
			ui.sortWeaponsPanel.setVisible(true);
			//ui.sortArmorsPanel.setVisible(true);
			isPressedI = 1;
		}
	}
	
	int isPressedS = 0; 
	public void showStatus() {
		
		if(isPressedS == 1) {
			showGameCont();
			isPressedS = 0; 
		}
		
		else if(isPressedI == 1 && isPressedS == 0) {
			ui.mainInventory.setVisible(false);
			ui.sortWeaponsPanel.setVisible(false);
			ui.statusPanel.setVisible(true);
			ui.upgradePanel.setVisible(true);
			isPressedS = 1;
			isPressedI = 0;
		}
		
		else if(isPressedI == 0 && isPressedS == 1) {
			ui.mainInventory.setVisible(true);
			ui.sortWeaponsPanel.setVisible(true);
			ui.statusPanel.setVisible(false);
			ui.upgradePanel.setVisible(false);
			isPressedS = 0;
			isPressedI = 1;
		}
		
		else if(isPressedI == 1 && isPressedS == 1) {
			ui.mainInventory.setVisible(false);
			ui.sortWeaponsPanel.setVisible(false);
			ui.statusPanel.setVisible(true);
			ui.upgradePanel.setVisible(true);
		}
		
		else {
			ui.mainTextPanel.setVisible(false);
			ui.choiceButtonPanel.setVisible(false);
			ui.statusPanel.setVisible(true);
			ui.upgradePanel.setVisible(true);
			isPressedS = 1; 
		}
	}
	
}
