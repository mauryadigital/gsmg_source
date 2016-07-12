package com.pts.ats.DAO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*", message="This doesn't appears to be a valid e-mail")
	private String emailId;
	@NotNull
	private String contact;
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailId
	 * @param contact
	 */
	public User(String firstName, String lastName, String emailId, String contact) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contact = contact;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", contact="
				+ contact + "]";
	}

}
