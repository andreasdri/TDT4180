package oving3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {

	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	private PropertyChangeSupport pcs;
	
	public Person(String name, String dateOfBirth, Gender gender, String email, int height) {
		pcs = new PropertyChangeSupport(this);
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.height = height;
	}


	public Person(String name) {
		pcs = new PropertyChangeSupport(this);
		this.name = name;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		pcs.firePropertyChange("name", oldValue, name);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange("birth", oldValue, dateOfBirth);

	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		Gender oldValue = this.gender;
		this.gender = gender;
		pcs.firePropertyChange("gender", oldValue, gender);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		pcs.firePropertyChange("email", oldValue, email);
	}
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		int oldValue = this.height;
		this.height = height;
		pcs.firePropertyChange("height", oldValue, height);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", email=" + email + ", height="
				+ height + "]";
	}

	
	
	


}
