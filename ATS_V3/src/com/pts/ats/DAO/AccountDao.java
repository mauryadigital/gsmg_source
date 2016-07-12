package com.pts.ats.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("AccountDao")
public class AccountDao {

	private NamedParameterJdbcTemplate jdbc;

	/**
	 * @param jdbc
	 *            the jdbc to set
	 */
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean createAccount(Account account) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(account);
		jdbc.update(
				"insert into users(userName, firstName, lastName, emailId, password, enabled)values(:userName, :firstName, :lastName, :emailId,:password,:enabled)",
				source);
		return jdbc.update(
				"insert into authorities(username, authority)values(:emailId, :authority)",
				source) == 1;
	}

	public boolean exists(String userName) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select count(*) from users where userName= :userName ", new MapSqlParameterSource("userName", userName), Integer.class)>0;
	}
}
