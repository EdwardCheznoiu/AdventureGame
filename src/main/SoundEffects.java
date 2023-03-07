package main;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffects {
	Clip clip = null;
	
	public void setFile(String soundFileName) {
		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e){
			System.out.println("Ceva nu a mers bine la redarea sunetului" + e);
		}
	}
	
	public void play() {
		try {
		clip.setFramePosition(0);
        clip.loop(-1);
		clip.start();
		}
		catch(Exception e){
			System.out.println("Ceva nu a mers bine la redarea sunetului");
		}
	  
	}
	
	public void playOnce() {
		try {
			clip.setFramePosition(0);
	        clip.loop(0);
			clip.start();
			}
			catch(Exception e){
				System.out.println("Ceva nu a mers bine la redarea sunetului");
			}
	}
	
	public void stop() {
		try {
			clip.stop();
		}
		catch(Exception e) {}
		
	}

}
