package oving3;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PersonPanel extends JPanel implements PropertyChangeListener {
	
	private Person model ;//new Person("Andreas", "01.02.1993", Gender.male, "a@dr.com", 173);
	protected JTextField nameField;
	protected JTextField birthdayField;
	protected JTextField mailField;
	protected JSlider heightSlider;
	protected JComboBox genderPicker;
	
	public PersonPanel() {
		//gui
		JLabel nameLabel = new JLabel("Name:");
		JLabel dateOfBirthLabel = new JLabel("Birthday:");
		JLabel genderLabel = new JLabel("Gender:");
		JLabel emailLabel = new JLabel("E-mail:");
		JLabel heightLabel = new JLabel("Height:");
		nameField = new JTextField(20);
		mailField = new JTextField(20);
		birthdayField = new JTextField(20);
		genderPicker = new JComboBox(Gender.values()); 
		heightSlider = new JSlider(JSlider.HORIZONTAL, 120, 220, 170);
		heightSlider.setMajorTickSpacing(10);
		heightSlider.setMinorTickSpacing(5);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		Dimension d = heightSlider.getPreferredSize();  
		heightSlider.setPreferredSize(new Dimension(d.width+50,d.height));  
		
		setLayout(new GridBagLayout());
        Insets in = new Insets(4,12,4,12); //padding
        int anc = GridBagConstraints.WEST; //elementene holder seg til venstre
      // GridBagConstraints c = new GridBagConstraints();
       // c.gridy = 0;
       // add(, c)
       // c.gridy++;
        
        /*GridBagConstraints(int gridx, int gridy, int gridwidth, 
        int gridheight, double weightx, double weighty, int anchor, 
        int fill, Insets insets, int ipadx, int ipady*/
		add(nameLabel, new GridBagConstraints(0,0,1,1,1,1,anc,0,in, 0, 0));
		add(emailLabel, new GridBagConstraints(0,1,1,1,1,1,anc,0,in, 0, 0));
		add(dateOfBirthLabel, new GridBagConstraints(0,2,1,1,1,1,anc,0,in, 0, 0));
		add(genderLabel, new GridBagConstraints(0,3,1,1,1,1,anc,0,in, 0, 0));
		add(heightLabel, new GridBagConstraints(0,4,1,1,1,1,anc,0,in, 0, 0));
		add(nameField, new GridBagConstraints(1,0,1,1,1,1,anc,0,in, 0, 0));
		add(mailField, new GridBagConstraints(1,1,1,1,1,1,anc,0,in, 0, 0));
		add(birthdayField, new GridBagConstraints(1,2,1,1,1,1,anc,0,in, 0, 0));
		add(genderPicker, new GridBagConstraints(1,3,1,1,1,1,anc,0,in, 0, 0));
		add(heightSlider, new GridBagConstraints(1,4,3,1,1,1,anc,0,in, 0, 0));
		
		//slik at testene finner komponentene
		nameField.setName("NamePropertyComponent");
		mailField.setName("EmailPropertyComponent");
		birthdayField.setName("DateOfBirthPropertyComponent");
		genderPicker.setName("GenderPropertyComponent");
		heightSlider.setName("HeightPropertyComponent");

		addListeners();
	}
	
	private void addListeners() {
		//lytter etter endringer på tektfelt, "velger" og slider
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if(model == null) return;
				updateModel();
			}
		};
		nameField.addActionListener(listener);
		mailField.addActionListener(listener);
		birthdayField.addActionListener(listener);
		genderPicker.addActionListener(listener);
		heightSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent evt) {
				if(model == null) return;
				updateModel();
			}
			
		}) ;
	}

	public void updateModel() {
		model.setDateOfBirth(birthdayField.getText());
		model.setEmail(mailField.getText());
		model.setGender((Gender) genderPicker.getSelectedItem());
		model.setHeight(heightSlider.getValue());
		model.setName(nameField.getText());
	}
	
	public Person getModel() {
		return model;
	}

	public void setModel(Person model) {
		this.model = model;
		nameField.setText(model.getName());
		heightSlider.setValue(model.getHeight());
		mailField.setText(model.getEmail());
		birthdayField.setText(model.getDateOfBirth());
		genderPicker.setSelectedItem(model.getGender());
		this.model.addPropertyChangeListener(this);


	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == "name") {
			nameField.setText(model.getName());
		}
		else if(evt.getPropertyName() == "birth") {
			birthdayField.setText(model.getDateOfBirth());
		}
		else if(evt.getPropertyName() == "email") {
			mailField.setText(model.getEmail());
		}
		else if(evt.getPropertyName() == "gender") {
			genderPicker.setSelectedItem(model.getGender());
		}
		else if(evt.getPropertyName() == "height") {
			heightSlider.setValue(model.getHeight());
		}

	}
	

}
