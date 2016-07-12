package com.pts.ats.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("UserDao")
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;

	/**
	 * @param jdbc
	 *            the jdbc to set
	 */
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<User> getUsers() {

		return jdbc.query("select * from user", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailId(rs.getString("emailId"));
				user.setContact(rs.getString("contact"));
				return user;
			}
		});
	}

	public boolean deleteUser(String email) {
		MapSqlParameterSource map = new MapSqlParameterSource("emailId", email);
		return jdbc.update("delete from user where emailId=:email", map) == 1;

	}

	public boolean createUser(User user) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
		return jdbc.update(
				"insert into user(firstName, lastName, emailId, contact)values(:firstName, :lastName, :emailId, :contact)",
				source) == 1;
	}

	public boolean updateUser(User user) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
		return jdbc.update(
				"update user set firstName =:firstName, lastName=:lastName, emailId=:emailId, contact=:contact",
				source) == 1;
	}
}
