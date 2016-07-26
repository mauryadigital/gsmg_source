package com.pts.ats.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pts.ats.DAO.Account;
import com.pts.ats.service.AccountService;

@Controller
public class LoginController {

	private AccountService accountService;

	/**
	 * @param accountService
	 *            the accountService to set
	 */
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/loggedOut")
	public String showLoggedout() {
		return "loggedOut";
	}
	
	@RequestMapping("/createAccount")
	public String showCreateAccount(Model model) {
		model.addAttribute("account", new Account());
		return "createAccount";
	}

	@RequestMapping("/accountCreated")
	public String showCreatedAccount() {
		return "accountCreated";
	}

	@RequestMapping(value = "/accountCreated", method = RequestMethod.POST)
	public String createAccount(Model model, @Valid Account account, BindingResult result) {

		if (result.hasErrors()) {
			return "createAccount";
		}
		System.out.println("Creating Account..");
		account.setAuthority("account");
		account.setEnabled(true);
		if(accountService.exists(account.getUserName())){
			System.out.println("Duplicate UserName exists");
			result.rejectValue("userName", "DuplicateUserName.account.userName", "This userName already Exists!");
			return "createAccount";
		}
		try {
			accountService.createAccount(account);
		} catch (DuplicateKeyException e) {
			// TODO: handle exception
			result.rejectValue("userName", "DuplicateUserName.account.userName", "This userName already Exists!");
			return "createAccount";
		}
		return "accountCreated";
	}
}
