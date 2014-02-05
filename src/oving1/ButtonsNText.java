package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


public class ButtonsNText extends JPanel {
	
	private JTextField TextLine;
	private JToggleButton UpperCaseButton;
	private JToggleButton LowerCaseButton;
	private JCheckBox ContinuousButton;
	
	public ButtonsNText(){
		addTextField();
		addButtons();
		addCheckbox();
		
		TextLine.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent evt) {
				int pos = TextLine.getCaretPosition();
				
				if(evt.getKeyChar() == KeyEvent.VK_ENTER && TextLine.isFocusable()) {
					setUpperOrLower();
				}
				TextLine.setCaretPosition(pos);
				
			}
			
			@Override
			public void keyReleased(KeyEvent evt) {
				int pos = TextLine.getCaretPosition();

				if(ContinuousButton.isSelected()) {
					setUpperOrLower();
				}
				TextLine.setCaretPosition(pos);

			}
			
			@Override
			public void keyTyped(KeyEvent evt) {
			}
			
		});
		UpperCaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TextLine.setText(TextLine.getText().toUpperCase());
			}
		});
		LowerCaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TextLine.setText(TextLine.getText().toLowerCase());
			}
		});
			
		
		
        TextLine.setName("TextLine");
        UpperCaseButton.setName("UpperCaseButton");
        LowerCaseButton.setName("LowerCaseButton");
        ContinuousButton.setName("ContinuousButton");

		
	}
	
	private void setUpperOrLower() {
		String content = TextLine.getText();
		if(UpperCaseButton.isSelected()){
			content = content.toUpperCase();
		}
		if(LowerCaseButton.isSelected()) {
			content = content.toLowerCase();
		}
		TextLine.setText(content);
	}
	
	private void addCheckbox() {
		ContinuousButton = new JCheckBox("Continuous?");
		add(ContinuousButton);
		
	}

	private void addButtons() {
		UpperCaseButton = new JToggleButton("Upper case");
		LowerCaseButton = new JToggleButton("Lower case");
		ButtonGroup group = new ButtonGroup();
		group.add(UpperCaseButton);
		group.add(LowerCaseButton);
		add(UpperCaseButton);
		add(LowerCaseButton);
		
	}

	private void addTextField() {
		final int FIELD_WIDTH = 10;
		TextLine = new JTextField(FIELD_WIDTH);
		add(TextLine);
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Oving 1 MMI");
		JPanel mainPanel = new ButtonsNText();
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);


	}

}
