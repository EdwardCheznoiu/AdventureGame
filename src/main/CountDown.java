package main;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import enemies.Enemies;


public class CountDown {
    public void closeTab(JPanel jp) {
    	SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>(){

			@Override
			protected Boolean doInBackground() throws Exception {
				for(int i = 0; i < 3; i++) {
					Thread.sleep(1000);
				}
				return true;
			}
			 
			@Override
			protected void done() {
				jp.setVisible(false);
			}
    	};
    	
    	worker.execute();
    }
    
    public void isEnemyAlive(Enemies e) {
    	SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>(){

			@Override
			protected Boolean doInBackground() throws Exception {
				while(e.getHp() > 0) {
					if(e.getHp() <= 0)
						break;
				}
				return true;
			}
			 
			@Override
			protected void done() {
				e.setAlive(false);
			}
    	};
    	
    	worker.execute();
    }
    
 
    
}
