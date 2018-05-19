package rhymes;

import java.awt.BorderLayout;

import javax.swing.*;

public class Main {

	public static void runGUI() {
		
		JFrame frame = new JFrame("Game GUI");
		frame.pack();
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		String filename ="src/rhymingDictionary.txt";
		
		GameModel gameModel = new GameModel(filename);
		GUI gui = new GUI(gameModel);
		frame.getContentPane().add(gui.getWordPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(gui.getChoicesPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(gui.getScorePanel(), BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				runGUI();
			}
			
		});
		
	}
	
	
}
