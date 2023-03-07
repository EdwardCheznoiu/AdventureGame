package main;
import java.awt.event.ActionEvent;


public class MainGame {
	
	
	ChoiceHandlerr cHandler = new ChoiceHandlerr(this);
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	ActionEvent e;
	MainStory story = new MainStory(this, ui, vm);
	public String nextPosition1, nextPosition2, nextPosition3, nextPosition4; 

	public static void main(String[] args) { 
		
		newGame();
	}
	
	public static void newGame() {
		new MainGame();
	}
	
	public MainGame() {
		
		ui.createUI(cHandler);
		story.defSetup();
		vm.showTitleScreen();
	}
	
}
