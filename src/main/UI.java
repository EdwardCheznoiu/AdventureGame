package main;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;


public class UI {
	
	public JFrame window; 
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, 
	healtBarPanel, expPanel, mainInventory, weapInv, armInv, lvlUpMsgPanel, sortWeaponsPanel, sortArmorsPanel, statusPanel, statusHpPanel, statusMpPanel, statusWPanel, statusAPanel,
	statusPhAtPanel, statusMaAtPanel, stausCritPanel, upgradePanel, itemsPanel, questItemPanel, thirdTextPanel, lvlPanel, expsPanel, statusStrPanel, statusWisPanel, statusTextArea,
	statusMagAtPanel, lpPanel; 
	
	public JLabel background,  titleNameLabel, lifeLabel, hpLabel, hpNumberLabel, manaLabel, mpLabel, mpNumberLabel, armorsLabel, armorLabel,
	armorNameLabel, weaponsLabel, weaponLabel, weaponNameLabel, expLabel, lvlLabel, invWeapName, space, invArmName, lvlMsg,
	statusHpLabel, statusHpNrLabel, statusMpLabel, statusMpNrLabel, statusWLabel, statusWNrLabel, statusALabel, statusANrLabel, 
	statusPhAtLabel, statusPhAtNrLabel, invItemName, invQuestItemName, lvlsLabel, lvlsNrLabel, expsLabel, expsNrLabel, statusStrLabel, statusStrNrLabel, statusWisLabel, statusWisNrLabel,
	statusMagAtLabel, statusMagAtNrLabel, lpLabel, lpNrLabel;
	
	public JButton startButton, choice1, choice2, choice3, choice4, inventoryB, statusB, contineB,  exitB, sortWByName, sortWByDmg, sortAByName, sortAByHp, hpUpgrade, mpUpgrade, strUpgrade, wisUpgrade;
	public JButton [] weapIButton = new JButton[15];
	public JButton [] armorIButton = new JButton[15];
	public JButton [] itemIButton = new JButton[15];
	public JButton [] questIButton = new JButton[15];
	public JLabel giantRatImage;
	public JTextArea mainTextArea, secondTextArea, thirdTextArea, statusTTextArea; 

	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	
    Border bntBorder = BorderFactory.createLineBorder(Color.red);
	
     
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
	Font invNameBox = new Font("Times new Roman", Font.BOLD, 28);
	Font upgradeFont = new Font("Times New Roman", Font.BOLD, 20);
	ImageIcon bg = new ImageIcon("C:\\Users\\Eddula\\Desktop\\New folder\\bg.JPG");
	ImageIcon hpImg = new ImageIcon("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Icons/hp.png");
	ImageIcon mpImg = new ImageIcon("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Icons/mp.png");
	ImageIcon swordImg = new ImageIcon("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Icons/sword.png");
	ImageIcon armorImg = new ImageIcon("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Icons/armor.png");
	public Color areasColor = new Color(14, 14, 14);
	SoundEffects waveSound = new SoundEffects();
	String link = "C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/sea.wav";
    
 
	int height = 800, width = 1200; 
	
	public void createUI(ChoiceHandlerr cHandler) {
		
		window = new JFrame();
		window.setSize(width, height);
		window.setBounds((dim.width - width) / 2, (dim.height - height) / 2, width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(areasColor);
		window.setLayout(null);
		window.setTitle("Titan's Island");
		window.setResizable(false);
	    
		titleNamePanel = new JPanel(); 
		titleNamePanel.setBounds((width - 600) / 2,(height - 100) / 4, 600, 100);
		titleNamePanel.setBackground(areasColor);
		titleNamePanel.setOpaque(false);
		titleNameLabel = new JLabel("Insula Titanului");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds((width - 250) / 2, 400, 250,120);
		startButtonPanel.setBackground(areasColor);
		startButtonPanel.setLayout(new GridLayout(3, 1));
		startButton = new JButton("ÎNCEPE JOC NOU");
		startButton.setBackground(areasColor);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButton.setBorder(null);
		startButtonPanel.add(startButton);
	
		contineB = new JButton("CONTINUA JOC");
		contineB.setBackground(areasColor);
		contineB.setForeground(Color.white);
		contineB.setFont(normalFont);
		contineB.setFocusPainted(false);
		contineB.addActionListener(cHandler);
		contineB.setActionCommand("continue");
		contineB.setBorder(null);
		startButtonPanel.add(contineB);
	 
		exitB = new JButton("IESIRE JOC");
		exitB.setBackground(areasColor);
		exitB.setForeground(Color.white);
		exitB.setFont(normalFont);
		exitB.setFocusPainted(false);
		exitB.addActionListener(cHandler);
		exitB.setActionCommand("exit");
		exitB.setBorder(null);
		startButtonPanel.add(exitB);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(150,100,600,200);
		mainTextPanel.setOpaque(false);
		
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(areasColor);
		mainTextArea.repaint();
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(450, 350, 300, 150);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		choiceButtonPanel.setOpaque(false);
		
		choice1 = new JButton("Choice1");
		choice1.setBackground(areasColor);
		choice1.setForeground(Color.white);
		choice1.setFont(upgradeFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice2");
		choice2.setBackground(areasColor);
		choice2.setForeground(Color.white);
		choice2.setFont(upgradeFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice3");
		choice3.setBackground(areasColor);
		choice3.setForeground(Color.white);
		choice3.setFont(upgradeFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice4");
		choice4.setBackground(areasColor);
		choice4.setForeground(Color.white);
		choice4.setFont(upgradeFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(0, 15, 1200, 50); 
		playerPanel.setBorder(new EmptyBorder(10,10,10,10));
		playerPanel.setLayout(new GridLayout(1, 4,  50, 50));
		playerPanel.setOpaque(false);
	
		lifeLabel = new JLabel(); 
		lifeLabel.setLayout(new GridLayout(1, 2, -150, 0));
		lifeLabel.setBackground(new Color(0,0,0, .5f));
		playerPanel.add(lifeLabel);
		hpLabel = new JLabel("", hpImg, JLabel.LEFT);
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		lifeLabel.add(hpLabel);
		hpNumberLabel = new JLabel();
		hpNumberLabel.setForeground(Color.white);
		hpNumberLabel.setFont(normalFont);
		hpNumberLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white)); 
		lifeLabel.add(hpNumberLabel);
		
		manaLabel = new JLabel();
		lifeLabel.setBackground(new Color(0,0,0, .5f));
		manaLabel.setLayout(new GridLayout(1, 2, -150, 0));
		playerPanel.add(manaLabel);
		mpLabel = new JLabel("", mpImg, JLabel.LEFT);
		mpLabel.setFont(normalFont);
		mpLabel.setForeground(Color.white);
		manaLabel.add(mpLabel);
		mpNumberLabel = new JLabel();
		mpNumberLabel.setForeground(Color.white);
		mpNumberLabel.setFont(normalFont);
		mpNumberLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white)); 
		manaLabel.add(mpNumberLabel);
		
		weaponsLabel = new JLabel();
		weaponsLabel.setBackground(Color.black);
		weaponsLabel.setLayout(new GridLayout(1, 2, -120, 0));
		playerPanel.add(weaponsLabel);
		weaponLabel = new JLabel("", swordImg, JLabel.LEFT);
		weaponLabel.setForeground(Color.white);
		weaponLabel.setFont(normalFont);
		weaponsLabel.add(weaponLabel);
		weaponNameLabel = new JLabel();
		weaponNameLabel.setForeground(Color.white);
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white)); 
		weaponsLabel.add(weaponNameLabel);
		
		lvlUpMsgPanel = new JPanel();
		lvlUpMsgPanel.setBounds((width - 400) / 2, 240, 400, 100);
		lvlUpMsgPanel.setBackground(Color.black);
		lvlUpMsgPanel.setOpaque(false);
		
		secondTextArea = new JTextArea();
		secondTextArea.setBounds((width - 400) / 2, 240, 400, 100);
		secondTextArea.setBackground(areasColor);
		secondTextArea.setForeground(Color.white);
		secondTextArea.setLineWrap(true);
		secondTextArea.setFont(normalFont);
		secondTextArea.setWrapStyleWord(true);
		secondTextArea.setEditable(false);
		lvlUpMsgPanel.add(secondTextArea);
		
		thirdTextPanel = new JPanel();
		thirdTextPanel.setBounds((width - 450) / 2, 440, 450, 100);
		thirdTextPanel.setBackground(Color.black);
		thirdTextPanel.setVisible(false);
		thirdTextPanel.setOpaque(false);
		
		thirdTextArea = new JTextArea();
		thirdTextArea.setBounds((width - 450) / 2, 440, 450, 100);
		thirdTextArea.setBackground(areasColor);
		thirdTextArea.setForeground(Color.white);
		thirdTextArea.setLineWrap(true);
		thirdTextArea.setFont(normalFont);
		thirdTextArea.setWrapStyleWord(true);
		thirdTextArea.setEditable(false);
		thirdTextPanel.add(thirdTextArea);
		
		
		statusTextArea = new JPanel();
		statusTextArea.setBounds((width - 500) / 2,  140, 500, 50);
		statusTextArea.setBackground(Color.black);
		statusTextArea.setVisible(false);
		statusTextArea.setOpaque(false);
		
		statusTTextArea = new JTextArea();
		statusTTextArea.setBounds((width - 500) / 2,  140, 500, 50);
		statusTTextArea.setBackground(areasColor);
		statusTTextArea.setForeground(Color.white);
		statusTTextArea.setLineWrap(true);
		statusTTextArea.setFont(normalFont);
		statusTTextArea.setWrapStyleWord(true);
		statusTTextArea.setEditable(false);
		statusTextArea.add(statusTTextArea);
		
		armorsLabel = new JLabel();
		armorsLabel.setBackground(Color.black);
		armorsLabel.setLayout(new GridLayout(1, 2, -100, 0));
		playerPanel.add(armorsLabel);
		armorLabel = new JLabel("", armorImg, JLabel.LEFT);
		armorLabel.setForeground(Color.white);
		armorLabel.setFont(normalFont);
		armorsLabel.add(armorLabel);
		armorNameLabel = new JLabel();
		armorNameLabel.setForeground(Color.white);
		armorNameLabel.setFont(normalFont);
		armorsLabel.add(armorNameLabel);
		
		window.add(playerPanel);		
		
		expPanel = new TransparentPanel();
		expPanel.setBounds(0, 700, 1200, 50);
		expPanel.setBackground(new Color(255, 0, 0, 10));
		expPanel.setLayout(new GridLayout(1, 4));
 
		
		lvlLabel = new JLabel("Nivel: ");
		lvlLabel.setForeground(new Color(230, 77, 0));
		lvlLabel.setFont(normalFont);
		lvlLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white)); 
		expPanel.add(lvlLabel);
		
		expLabel = new JLabel("Exp: ");
		expLabel.setForeground(Color.white);
		expLabel.setFont(normalFont);
		expLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		expPanel.add(expLabel); 
		
		
		statusB = new JButton("Status");
		statusB.setContentAreaFilled(false);
		statusB.setForeground(Color.white);
		statusB.setFont(normalFont);
		statusB.setFocusPainted(false);
		statusB.addActionListener(cHandler);
		statusB.setActionCommand("status");

		expPanel.add(statusB);

		statusPanel = new JPanel();
		statusPanel.setBounds((width - 400) / 2, (height - 300) / 2 - 50, 400, 300);
		statusPanel.setBackground(areasColor);
		statusPanel.setLayout(new GridLayout(12, 2));
		statusPanel.setVisible(false);
		statusPanel.setOpaque(false);
		
		lvlPanel = new JPanel();
		lvlPanel.setBackground(areasColor);
		lvlPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(lvlPanel);
		lvlsLabel = new JLabel("Nivel: ");
		lvlsLabel.setBackground(areasColor);
		lvlsLabel.setForeground(Color.white);
		lvlPanel.add(lvlsLabel);
		lvlsNrLabel = new JLabel();
		lvlsNrLabel.setBackground(Color.black);
		lvlsNrLabel.setForeground(Color.white);
		lvlPanel.add(lvlsNrLabel);
		
		lpPanel = new JPanel();
		lpPanel.setBackground(areasColor);
		lpPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(lpPanel);
		lpLabel = new JLabel("LP: ");
		lpLabel.setBackground(areasColor);
		lpLabel.setForeground(Color.white);
		lpPanel.add(lpLabel);
		lpNrLabel = new JLabel();
		lpNrLabel.setBackground(Color.black);
		lpNrLabel.setForeground(Color.white);
		lpPanel.add(lpNrLabel);
		
		expsPanel = new JPanel();
		expsPanel.setBackground(areasColor);
		expsPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(expsPanel);
		expsLabel = new JLabel("Experienta: ");
		expsLabel.setBackground(areasColor);
		expsLabel.setForeground(Color.white);
		expsPanel.add(expsLabel);
		expsNrLabel = new JLabel();
		expsNrLabel.setBackground(Color.black);
		expsNrLabel.setForeground(Color.white);
		expsPanel.add(expsNrLabel);
		
		statusHpPanel = new JPanel();
		statusHpPanel.setBackground(areasColor);
		statusHpPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusHpPanel);
		statusHpLabel = new JLabel("HP: ");
		statusHpLabel.setBackground(areasColor);
		statusHpLabel.setForeground(Color.white);
		statusHpPanel.add(statusHpLabel);
		statusHpNrLabel = new JLabel();
		statusHpNrLabel.setBackground(areasColor);
		statusHpNrLabel.setForeground(Color.white);
		statusHpPanel.add(statusHpNrLabel);
		
		statusMpPanel = new JPanel();
		statusMpPanel.setBackground(areasColor);
		statusMpPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusMpPanel);
		statusMpLabel = new JLabel("MP: ");
		statusMpLabel.setBackground(areasColor);
		statusMpLabel.setForeground(Color.white);
		statusMpPanel.add(statusMpLabel);
		statusMpNrLabel = new JLabel();
		statusMpNrLabel.setBackground(areasColor);
		statusMpNrLabel.setForeground(Color.white);
		statusMpPanel.add(statusMpNrLabel);
		
		statusStrPanel = new JPanel();
		statusStrPanel.setBackground(areasColor);
		statusStrPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusStrPanel);
		statusStrLabel = new JLabel("STR: ");
		statusStrLabel.setBackground(areasColor);
		statusStrLabel.setForeground(Color.white);
		statusStrPanel.add(statusStrLabel);
		statusStrNrLabel = new JLabel();
		statusStrNrLabel.setBackground(areasColor);
		statusStrNrLabel.setForeground(Color.white);
		statusStrPanel.add(statusStrNrLabel);
		
		statusWisPanel = new JPanel();
		statusWisPanel.setBackground(areasColor);
		statusWisPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusWisPanel);
		statusWisLabel = new JLabel("WIS: ");
		statusWisLabel.setBackground(areasColor);
		statusWisLabel.setForeground(Color.white);
		statusWisPanel.add(statusWisLabel);
		statusWisNrLabel = new JLabel();
		statusWisNrLabel.setBackground(areasColor);
		statusWisNrLabel.setForeground(Color.white);
		statusWisPanel.add(statusWisNrLabel);
		
		statusWPanel = new JPanel();
		statusWPanel.setBackground(areasColor);
		statusWPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusWPanel);
		statusWLabel = new JLabel("Arma: ");
		statusWLabel.setBackground(areasColor);
		statusWLabel.setForeground(Color.white);
		statusWPanel.add(statusWLabel);
		statusWNrLabel = new JLabel();
		statusWNrLabel.setBackground(Color.black);
		statusWNrLabel.setForeground(Color.white);
		statusWPanel.add(statusWNrLabel);
		
		statusAPanel = new JPanel();
		statusAPanel.setBackground(areasColor);
		statusAPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusAPanel);
		statusALabel = new JLabel("Armura: ");
		statusALabel.setBackground(areasColor);
		statusALabel.setForeground(Color.white);
		statusAPanel.add(statusALabel);
		statusANrLabel = new JLabel();
		statusANrLabel.setBackground(Color.black);
		statusANrLabel.setForeground(Color.white);
		statusAPanel.add(statusANrLabel);
		
		statusPhAtPanel = new JPanel();
		statusPhAtPanel.setBackground(areasColor);
		statusPhAtPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusPhAtPanel);
		statusPhAtLabel = new JLabel("Daune fizice: ");
		statusPhAtLabel.setBackground(Color.black);
		statusPhAtLabel.setForeground(Color.white);
		statusPhAtPanel.add(statusPhAtLabel);
		statusPhAtNrLabel = new JLabel();
		statusPhAtNrLabel.setBackground(Color.black);
		statusPhAtNrLabel.setForeground(Color.white);
		statusPhAtPanel.add(statusPhAtNrLabel);
		
		statusMagAtPanel = new JPanel();
		statusMagAtPanel.setBackground(areasColor);
		statusMagAtPanel.setLayout(new GridLayout(1, 2));
		statusPanel.add(statusMagAtPanel);
		statusMagAtLabel = new JLabel("Daune magice: ");
		statusMagAtLabel.setBackground(Color.black);
		statusMagAtLabel.setForeground(Color.white);
		statusMagAtPanel.add(statusMagAtLabel);
		statusMagAtNrLabel = new JLabel();
		statusMagAtNrLabel.setBackground(Color.black);
		statusMagAtNrLabel.setForeground(Color.white);
		statusMagAtPanel.add(statusMagAtNrLabel);
		
		window.add(statusPanel);
		
		upgradePanel = new JPanel();
		upgradePanel.setBounds((width - 800) / 2 , ((height - 50) / 4) * 3, 800, 50);
		upgradePanel.setBackground(Color.black);
		upgradePanel.setLayout(new GridLayout(1, 4));
		upgradePanel.setVisible(false);
		
		hpUpgrade = new JButton("HP ++");
		hpUpgrade.setBackground(new Color(255, 51, 51));
		hpUpgrade.setBorder(BorderFactory.createEmptyBorder());
		hpUpgrade.setFocusPainted(false);
		hpUpgrade.setForeground(Color.white);
		hpUpgrade.setFont(upgradeFont);
		hpUpgrade.addActionListener(cHandler);
		hpUpgrade.setActionCommand("hpUpgrade");
		upgradePanel.add(hpUpgrade);
		
		mpUpgrade = new JButton("MP ++");
		mpUpgrade.setBackground(new Color(51, 153, 255));
		mpUpgrade.setBorder(BorderFactory.createEmptyBorder());
		mpUpgrade.setFocusPainted(false);
		mpUpgrade.setForeground(Color.white);
		mpUpgrade.setFont(upgradeFont);
		mpUpgrade.addActionListener(cHandler);
		mpUpgrade.setActionCommand("mpUpgrade");
		upgradePanel.add(mpUpgrade);
		
		strUpgrade = new JButton("STR ++");
		strUpgrade.setBackground(new Color(255, 153, 51));
		strUpgrade.setBorder(BorderFactory.createEmptyBorder());
		strUpgrade.setFocusPainted(false);
		strUpgrade.setForeground(Color.white);
		strUpgrade.setFont(upgradeFont);
		strUpgrade.addActionListener(cHandler);
		strUpgrade.setActionCommand("strUpgrade");
		upgradePanel.add(strUpgrade);
		
		wisUpgrade = new JButton("WIS ++");
		wisUpgrade.setBackground(new Color(204, 102, 255));
		wisUpgrade.setBorder(BorderFactory.createEmptyBorder());
		wisUpgrade.setFocusPainted(false);
		wisUpgrade.setForeground(Color.white);
		wisUpgrade.setFont(upgradeFont);
		wisUpgrade.addActionListener(cHandler);
		wisUpgrade.setActionCommand("wisUpgrade");
		upgradePanel.add(wisUpgrade);
		
		
		
		
		window.add(upgradePanel);
		
		
		inventoryB = new JButton("Inventar");
	 
		inventoryB.setContentAreaFilled(false);
		inventoryB.setForeground(Color.white);
		inventoryB.addActionListener(cHandler);
		inventoryB.setActionCommand("inventory");
		inventoryB.setFont(normalFont);
		//inventoryB.setBorder(BorderFactory.createEmptyBorder());
		inventoryB.setFocusPainted(false);
		expPanel.add(inventoryB);
		window.add(expPanel);
		 
		mainInventory = new JPanel();
		mainInventory.setBounds((width - 700) / 2, (height - 630) / 2, 700, 610);
		mainInventory.setBackground(new Color(26, 26, 26));
		mainInventory.setLayout(new GridLayout(2, 2, 50, 50));
		mainInventory.setVisible(false);
		mainInventory.setOpaque(false);
		
		 
		weapInv = new JPanel();
		weapInv.setBackground(areasColor);
		weapInv.setBorder(BorderFactory.createLineBorder(Color.white));
		weapInv.setLayout(new GridLayout(15, 1)); 
		mainInventory.add(weapInv);
		invWeapName = new JLabel ("                  Arme" + "\n\n");
		invWeapName.setForeground(Color.white);
		invWeapName.setFont(invNameBox);
		space = new JLabel();
		weapInv.add(invWeapName);
		weapInv.add(space);
		
		armInv = new JPanel();
		armInv.setBackground(areasColor);
		armInv.setBorder(BorderFactory.createLineBorder(Color.white));
		armInv.setLayout(new GridLayout(15, 1));
		mainInventory.add(armInv);
		invArmName = new JLabel ("                 Armuri" + "\n\n");
		invArmName.setForeground(Color.white);
		invArmName.setFont(invNameBox);
		space = new JLabel();
		armInv.add(invArmName);
		armInv.add(space);
		
		itemsPanel = new JPanel();
		itemsPanel.setBackground(areasColor);
		itemsPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		itemsPanel.setLayout(new GridLayout(15, 1));
		mainInventory.add(itemsPanel);
		invItemName = new JLabel("                 Obiecte");
		invItemName.setForeground(Color.white);
		invItemName.setFont(invNameBox);
		space = new JLabel();
		itemsPanel.add(invItemName);
		itemsPanel.add(space);
		
		
		questItemPanel = new JPanel();
		questItemPanel.setBackground(areasColor);
		questItemPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		questItemPanel.setLayout(new GridLayout(15, 1));
		mainInventory.add(questItemPanel);
		invQuestItemName = new JLabel("          Obiecte misiuni");
		invQuestItemName.setForeground(Color.white);
		space = new JLabel();
		invQuestItemName.setFont(invNameBox);
		questItemPanel.add(invQuestItemName);
		questItemPanel.add(space);
		
		window.add(mainInventory);
		
       //Panou pentru butoanele de sortare pentru arme
		sortWeaponsPanel = new JPanel();
		sortWeaponsPanel.setBounds(20, (height-300) / 4, 210, 300);
		sortWeaponsPanel.setBackground(Color.black);
		sortWeaponsPanel.setVisible(false);
		sortWeaponsPanel.setOpaque(false);
		//sortWeaponsPanel.setBorder(BorderFactory.createLineBorder(Color.white));
	    window.add(sortWeaponsPanel);
	    sortWByName = new JButton("Sortare dupa nume");
	    sortWByName.setBackground(areasColor);
	    sortWByName.setForeground(Color.white);
	    sortWByName.setContentAreaFilled(false);
	    sortWByName.setFocusPainted(false);
	    sortWByName.setFont(normalFont);
	    sortWByName.addActionListener(cHandler);
	    sortWByName.setActionCommand("sortWByName");
	    sortWeaponsPanel.add(sortWByName);
	    sortWByDmg = new JButton("Sortare dupa daune");
	    sortWByDmg.setBackground(Color.black);
	    sortWByDmg.setForeground(Color.white);
	    sortWByDmg.setContentAreaFilled(false);
	    sortWByDmg.setFocusPainted(false);
	    sortWByDmg.setFont(normalFont);
	    sortWByDmg.addActionListener(cHandler);
	    sortWByDmg.setActionCommand("sortWByDmg");
	    sortWeaponsPanel.add(sortWByDmg);
	 
	  
	 /*
	    sortArmorsPanel = new JPanel();
	    sortArmorsPanel.setBounds(950, (height-300) / 2, 210, 300);
	    sortArmorsPanel.setBackground(Color.black);
	    sortArmorsPanel.setVisible(false);
	    sortArmorsPanel.setOpaque(false);
	   sortArmorsPanel.setBorder(BorderFactory.createLineBorder(Color.white));
	    window.add(sortArmorsPanel);
	    sortAByName = new JButton("Sortare dupa nume");
	    sortAByName.setBackground(Color.black);
	    sortAByName.setForeground(Color.white);
	    sortAByName.setContentAreaFilled(false);
	    sortAByName.setFocusPainted(false);
	    sortAByName.setFont(normalFont);
	    sortAByName.addActionListener(cHandler);
	    sortAByName.setActionCommand("sortAByName");
	    sortArmorsPanel.add(sortAByName);
	    sortAByHp = new JButton("Sortare dupa hp");
	    sortAByHp.setBackground(Color.black);
	    sortAByHp.setForeground(Color.white);
	    sortAByHp.setContentAreaFilled(false);
	    sortAByHp.setFocusPainted(false);
	    sortAByHp.setFont(normalFont);
	    sortAByHp.addActionListener(cHandler);
	    sortAByHp.setActionCommand("sortAByHp");
	    sortArmorsPanel.add(sortAByHp);
	    */
 
	   
 
	    
	    
	    
	    background = new JLabel("", bg, JLabel.CENTER);
		background.setBounds(0, 0, width, height);
		window.add(background);
 
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		window.add(mainTextPanel);
		window.add(statusTextArea);
		window.add(choiceButtonPanel);
		window.add(lvlUpMsgPanel);
		window.add(thirdTextPanel);
		window.setVisible(true);
		
	}
	
 
	
	
	public void setBackground(String l) {
		ImageIcon bg = new ImageIcon(l);
		window.remove(background);
		SwingUtilities.updateComponentTreeUI(window);
		background = new JLabel("", bg, JLabel.CENTER);
		background.setBounds(0, 0, width, height);
		
		window.add(background);
	}
	
	 
}
