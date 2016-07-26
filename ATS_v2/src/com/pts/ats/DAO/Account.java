package com.pts.ats.DAO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Account {

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
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
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 
	 */
	public Account() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param emailId
	 * @param password
	 * @param enabled
	 * @param authority
	 */
	public Account(String userName, String firstName, String lastName, String emailId, String password, boolean enabled,
			String authority) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

	@NotBlank(message="UserName Can't be Empty")
	@Size(min=1, max =15)
	//@Pattern(regexp="^\\w{8,}$", message="UserName Can only consists numbers, letters and UnderScore")
	private String userName;
	private String firstName;
	private String lastName;
	@Email(message="This email seems to be doesn't valid")
	private String emailId;
	@NotBlank(message="Password Can't be Empty")
	@Pattern(regexp="^\\S+$")
	@Size(min=3, max =15)
	private String password;
	private boolean enabled = false;
	private String authority;

}
