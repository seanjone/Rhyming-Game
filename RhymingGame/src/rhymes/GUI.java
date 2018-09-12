package rhymes;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	private JButton choice1;
	private JButton choice2;
	private JButton choice3;
	private JButton choice4;
	private JLabel scoreLabel;
	private JLabel wordLabel;
	private GameModel game;

	public GUI(GameModel game) {
		this.game = game;
		this.choice1 = new JButton(this.game.getChoices().get(0));
		this.choice2 = new JButton(this.game.getChoices().get(1));
		this.choice3 = new JButton(this.game.getChoices().get(2));
		this.choice4 = new JButton(this.game.getChoices().get(3));
		this.scoreLabel = new JLabel("Score: " + this.game.getScore());
		this.wordLabel = new JLabel(this.game.getGivenWord());
	}

	public JPanel getWordPanel() {
		JPanel panel = new JPanel();
		panel.add(this.wordLabel);
		return panel;
	}

	public JPanel getChoicesPanel() {
		JPanel panel = new JPanel();
		this.choice1.addMouseListener(new AnswerListener(this.choice1, this.game, this));
		this.choice2.addMouseListener(new AnswerListener(this.choice2, this.game, this));
		this.choice3.addMouseListener(new AnswerListener(this.choice3, this.game, this));
		this.choice4.addMouseListener(new AnswerListener(this.choice4, this.game, this));
		panel.add(this.choice1);
		panel.add(this.choice2);
		panel.add(this.choice3);
		panel.add(this.choice4);
		return panel;
	}

	public JPanel getScorePanel() {
		JPanel panel = new JPanel();
		panel.add(this.scoreLabel);
		return panel;
	}

	public void update() {
		this.choice1.setText(this.game.getChoices().get(0));
		this.choice2.setText(this.game.getChoices().get(1));
		this.choice3.setText(this.game.getChoices().get(2));
		this.choice4.setText(this.game.getChoices().get(3));
		this.scoreLabel.setText("Score: " + this.game.getScore());
		this.wordLabel.setText(this.game.getGivenWord());
	}
}
