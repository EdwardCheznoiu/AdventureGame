package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandlerr implements ActionListener {
	
	MainGame game; 
	Player player = new Player();
	UI ui = new UI();
	CountDown c = new CountDown();
	
    public ChoiceHandlerr(MainGame g) {
    	game = g;
    }

	public void actionPerformed(ActionEvent e) {
		
		String yChoice = e.getActionCommand();
		
		switch(yChoice) {
		
		case "start": game.vm.startIntro(); game.story.player.updateStatusUi(game.ui); game.story.introText1(); break;
		case "c1": game.story.selectPosition(game.nextPosition1); break;
		case "c2": game.story.selectPosition(game.nextPosition2); break;
		case "c3": game.story.selectPosition(game.nextPosition3); break;
		case "c4": game.story.selectPosition(game.nextPosition4); break;
		case "hpUpgrade": player.hpUpgrade(game.ui); break;
		case "mpUpgrade": player.mpUpgrade(game.ui); break;
		case "strUpgrade": player.strUpgrade(game.ui); break;
		case "wisUpgrade": player.wisUpgrade(game.ui); break;
		case "inventory": game.vm.showInventory(); break;
		case "status": game.vm.showStatus(); break;
		case "equipW": player.getInventory().checkButtonClicked(e, game.ui); game.story.player.asignWeapon(game.ui); break;
		case "equipA": player.getInventory().checkButtonClicked(e, game.ui); game.story.player.asignArmor(game.ui); break;
		case "useItem": player.getInventory().checkButtonClicked(e, game.ui); game.story.player.potionUsed(game.ui);
		case "sortWByName": player.getInventory().sortWByName(); player.getInventory().rewriteWInv(game.ui); break;
		case "sortWByDmg": player.getInventory().sortWByAtk(); player.getInventory().rewriteWInv(game.ui); break;
		case "exit": game.vm.exit(); break;
		//case "save": game.story.saveGame(); break;
		//case "continue": game.vm.startIntro(); game.story.introText1(); game.story.loadGame(); break;
		}
	}
}
 