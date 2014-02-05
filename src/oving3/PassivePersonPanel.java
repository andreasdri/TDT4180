package oving3;

public class PassivePersonPanel extends PersonPanel {

	public PassivePersonPanel() {
		super();
		nameField.setEditable(false);
		mailField.setEditable(false);
		heightSlider.setEnabled(false);
		genderPicker.setEnabled(false);
		birthdayField.setEditable(false);
		
	}

}
