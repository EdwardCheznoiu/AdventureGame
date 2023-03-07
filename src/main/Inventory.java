package main;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import armors.Armors;
import items.Items;
import weapons.Weapons;


public class Inventory {
	
	public static Weapons w[] = new Weapons[20];
	public static Armors a[] = new Armors[20];
	public static Items it[] = new Items[20];
	public static int indexOfWClicked;
	
	//Verific cate arme am memorate in vectorul de obiecte de tip Weapons
	public int checkItemNr() {
		int nr = 0;
		for(int i = 0; i < w.length; i++) {
			if(w[i]!=null)
				nr++;
		}
		return nr;
	}
	
	
	//Sortez armele dupa nume
	public void sortWByName() {
		int i;
        Weapons temp;
        int len = checkItemNr();
		boolean schimbare = false; 
		do {
			schimbare  = false;
			for(i = 0; i < len; i++) {
				if(w[i] != null && i < len - 1) {
					if(w[i].getName().compareToIgnoreCase(w[i+1].getName()) > 0) {
						  temp = w[i];
						  w[i] = w[i+1];
						  w[i+1] = temp;
						  schimbare = true;
					}
				}
			}
		}while(schimbare);
	}

	//Sortez armele dupa daunele de atac
	public void sortWByAtk() {
		int i;
		Weapons temp;
        int len = checkItemNr();
		boolean schimbare = false; 
		do {
			schimbare  = false;
			for(i = 0; i < len; i++) {
				if(w[i] != null && i < len - 1) {
					if(w[i].getDmg() <= w[i+1].getDmg()) {
						  temp = w[i];
						  w[i] = w[i+1];
						  w[i+1] = temp;
						  schimbare = true;
					}
				}
			}
		}while(schimbare);
		
		
	}
	
	//Sortez armurile dupa nume
	public void sortAByName() {
		int i, j; 
		for(i = 0; i < a.length; i++) {
			for(j = 0; j < a.length-i-1; j++)
				if(a[j] != null) {
				   if(a[j].getName().compareTo(a[j+1].getName()) > 0) {
				      Armors temp = a[j];
					  a[j] = a[j+1];
					  a[j+1] = temp;
				}
			}
		}
	}
	
	
	//Sortez armurile dupa daunele de atac
	public void sortAByHp() {
		int i, j; 
		for(i = 0; i < a.length; i++) {
			for(j = 0; j < a.length-i-1; j++)
				if(a[j] != null) {
				   if(a[j].getHp() > a[j+1].getHp()) {
				      Armors temp = a[j];
					  a[j] = a[j+1];
					  a[j+1] = temp;
				}
			}
		}
	}
	
	
	/*Pentru fiecare arma din vectorul de obiecte de tip Weapons creez un buton care la apasare atribuie
	  arma selectata catre obiectul curentWeapon (arma curenta) din clasa Player*/
	
	
	public void showWInv(UI ui, ChoiceHandlerr cHandler, int index) {
		for (int i = index; i < w.length; i++) {
			if(w[i] != null) {
				ui.weapIButton[i] = new JButton(w[i].getName());
				ui.weapIButton[i].setBackground(Color.black);
				ui.weapIButton[i].setForeground(Color.white);
				ui.weapIButton[i].setFont(ui.normalFont);
				ui.weapIButton[i].setContentAreaFilled(false);
				ui.weapIButton[i].setFocusPainted(false);
				ui.weapInv.add(ui.weapIButton[i]);
				ui.weapIButton[i].addActionListener(cHandler);
				ui.weapIButton[i].setActionCommand("equipW");
			}
		}
	}
	
	
	
	public void showAInv(UI ui, ChoiceHandlerr cHandler, int index) {
		 
		for (int i = index; i < a.length; i++) {
			if(a[i] != null) {
				ui.armorIButton[i] = new JButton(a[i].getName());
				ui.armorIButton[i].setBackground(Color.black);
				ui.armorIButton[i].setForeground(Color.white);
				ui.armorIButton[i].setFont(ui.normalFont);
				ui.armorIButton[i].setContentAreaFilled(false);
				ui.armorIButton[i].setFocusPainted(false);
				ui.armInv.add(ui.armorIButton[i]);
				ui.armorIButton[i].addActionListener(cHandler);
				ui.armorIButton[i].setActionCommand("equipA");
			}
		}
	}
	
	
	public void showItInv(UI ui, ChoiceHandlerr cHandler, int index) {
		for (int i = index; i < it.length; i++) {
			if(it[i] != null) {
				ui.itemIButton[i] = new JButton(it[i].getName() + "\n");
				ui.itemIButton[i].setBackground(Color.black);
				ui.itemIButton[i].setForeground(Color.white);
				ui.itemIButton[i].setFont(ui.normalFont);
				ui.itemIButton[i].setContentAreaFilled(false);
				ui.itemIButton[i].setFocusPainted(false);
				ui.itemsPanel.add(ui.itemIButton[i]);
				ui.itemIButton[i].addActionListener(cHandler);
				ui.itemIButton[i].setActionCommand("useItem");
			}
		}
	}
	
	
	//Reafisez numele armelor din inventar dupa sortare
	public void rewriteWInv(UI ui) {
		int len = checkItemNr();
		for (int i = 0; i < len; i++) {
			if(w[i] != null) {
				ui.weapIButton[i].setText(w[i].getName());
			}
		}
	}
	
	public void rewriteItInv(UI ui) {
		 
		for (int i = 0; i < it.length; i++) {
			if(it[i] != null) {
				ui.weapIButton[i].setText(it[i].getName());
			}
		}
	}
	
	
	
	public void checkButtonClicked(ActionEvent e, UI ui) {
		int len = checkItemNr();
		for(int i = 0; i < len; i++)
			if(w[i] != null)
				if(e.getSource() == ui.weapIButton[i]) {
					indexOfWClicked = i;
				}
		 
	}
	
	public void deleteItem(UI ui) {
 
		
		Items tmp = new Items(); 
		JButton tmpb = new JButton();
		int i;
		for(i = indexOfWClicked; i < it.length; i++) {
		  if(it[i] != null) {
			if(it[i + 1] != null) {
				tmp = it[i + 1];
				it[i + 1] = it[i];
				it[i] = tmp;
				tmpb = ui.itemIButton[i + 1];
				ui.itemIButton[i + 1] = ui.itemIButton[i];
				ui.itemIButton[i] = tmpb;
			}
			else {
				it[i] = null;
				ui.itemIButton[i].setVisible(false);
				ui.itemIButton[i] = null;
				
			}
		  }
		}
		MainStory.indexItems--;
		
	}
 
	
}

 