package rhymes;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	public static JFrame runGUI() {
		JFrame gameGUI = new JFrame("Game GUI");

		GameModel gameModel = new GameModel("rhymingDictionary.txt");
		GUI gui = new GUI(gameModel);

		gameGUI.add(gui.getChoicesPanel(), BorderLayout.CENTER);
		gameGUI.add(gui.getScorePanel(), BorderLayout.SOUTH);
		gameGUI.add(gui.getWordPanel(), BorderLayout.NORTH);

		gameGUI.pack();
		gameGUI.setVisible(true);
		gameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return gameGUI;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runGUI();
			}
		});

	}

}
