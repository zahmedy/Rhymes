package rhymes;

import javax.swing.*;

public class GUI {


	private GameModel gameModel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel label;
	private JLabel label1;


	public GUI(GameModel gameModel) {
		this.gameModel = gameModel;
		this.button1 = new JButton();
		this.button2 = new JButton();
		this.button3 = new JButton();
		this.button4 = new JButton();
		this.label1 = new JLabel();
		this.label = new JLabel();

	}


	public JPanel getWordPanel() {
		JPanel panel = new JPanel();
		label.setText(this.gameModel.getGivenWord());
		panel.add(label);
		return panel;
	}

	public JPanel getChoicesPanel() {
		JPanel panel = new JPanel();

		button1.setText(this.gameModel.getChoices().get(0));
		button1.addMouseListener(new AnswerListener(button1,this.gameModel,this));
		button2.setText(this.gameModel.getChoices().get(1));
		button2.addMouseListener(new AnswerListener(button2,this.gameModel,this));
		button3.setText(this.gameModel.getChoices().get(2));
		button3.addMouseListener(new AnswerListener(button3,this.gameModel,this));
		button4.setText(this.gameModel.getChoices().get(3));
		button4.addMouseListener(new AnswerListener(button4,this.gameModel,this));

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		return panel;
	}

	public JPanel getScorePanel() {
		JPanel panel = new JPanel();
		label1.setText("Score: " + this.gameModel.getScore());

		panel.add(label1);

		return panel;
	}

	public void update() {
		button1.setText(this.gameModel.getChoices().get(0));
		button2.setText(this.gameModel.getChoices().get(1));
		button3.setText(this.gameModel.getChoices().get(2));
		button4.setText(this.gameModel.getChoices().get(3));
		label.setText(this.gameModel.getGivenWord());
		label1.setText("Score: " + this.gameModel.getScore());
	}


}
