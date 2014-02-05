package oving3;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonPanelProgram extends JPanel {
	
	private PersonPanel personPanel;
	private PassivePersonPanel passivePersonPanel;
	private Person model;
	
	public PersonPanelProgram() {
		model = new Person("Andreas Drivenes", "02.03.1993", Gender.male, "andreas.drivenes@gmail.com", 180);
		personPanel = new PersonPanel();
		passivePersonPanel = new PassivePersonPanel();
		personPanel.setModel(model);
		passivePersonPanel.setModel(model);
		add(personPanel);
		add(passivePersonPanel);
		
	}

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Oving 3 MMI");
		frame.getContentPane().add(new PersonPanelProgram());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


	}

}
