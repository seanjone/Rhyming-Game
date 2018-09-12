package rhymes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class AnswerListener implements MouseListener{
	private JButton button;
	private GameModel game;
	private GUI gui;
	public AnswerListener(JButton button, GameModel game, GUI gui) {
		this.button = button;
		this.game = game;
		this.gui = gui;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.button.setForeground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.button.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		this.button.setForeground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.button.setForeground(Color.BLUE);
		game.makeChoice(this.button.getText());
		this.gui.update();
	}

}
