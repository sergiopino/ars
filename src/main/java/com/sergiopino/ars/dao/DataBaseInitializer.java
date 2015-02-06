package com.sergiopino.ars.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sergiopino.ars.dao.account.AccountDao;
import com.sergiopino.ars.dao.company.CompanyDao;
import com.sergiopino.ars.dao.newsentry.NewsEntryDao;
import com.sergiopino.ars.dao.relationship.RelationshipDao;
import com.sergiopino.ars.dao.user.UserDao;
import com.sergiopino.ars.entity.Account;
import com.sergiopino.ars.entity.Company;
import com.sergiopino.ars.entity.NewsEntry;
import com.sergiopino.ars.entity.Relationship;
import com.sergiopino.ars.entity.User;

/**
 * Initialize the database with some test entries.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
@Service
public class DataBaseInitializer {

	@Autowired
	private NewsEntryDao newsEntryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private RelationshipDao relationshipDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	protected DataBaseInitializer() {
		/* Default constructor for reflection instantiation */
	}

	public DataBaseInitializer(UserDao userDao, NewsEntryDao newsEntryDao,
			PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.newsEntryDao = newsEntryDao;
		this.passwordEncoder = passwordEncoder;
	}

	public void initDataBase() {
		addUser();

		addAdminUser();

		addNewsBulk();

		addCompanyRelationshipAndAccount("A", 10, 10);
		addCompanyRelationshipAndAccount("B", 10, 10);
		addCompanyRelationshipAndAccount("C", 10, 10);
		addCompanyRelationshipAndAccount("D", 10, 10);
		addCompanyRelationshipAndAccount("E", 10, 10);
	}

	private void addCompanyRelationshipAndAccount(String name,
			int totalRelationships, int totalAccountsByRelationship) {
		Company company = new Company();
		company.setName("COMPANY " + name);
		company.setReferenceCompany(null);
		company.setAddress("Address " + name);
		this.companyDao.persist(company);

		for (int i = 0; i < totalRelationships; i++) {
			// save relationship
			Relationship relationship = new Relationship();
			relationship.setType(company.getName() + i);
			relationship.setCompany(company);
			this.relationshipDao.persist(relationship);

			for (int j = 0; j < totalAccountsByRelationship; j++) {
				addAccount(name, relationship, j);
			}

		}

	}

	private void addAccount(String name, Relationship relationship, int j) {
		Account account = new Account();
		account.setRelationship(relationship);
		account.setBalance(BigDecimal.ONE);
		account.setName("ACCOUNT " + name + j);
		account.setCurrency("EUR");
		account.setOwner("OWNER " + name + j);
		this.accountDao.persist(account);
	}

	private void addNewsBulk() {
		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			addNews(timestamp, i);
			timestamp += 1000 * 60 * 60;
		}
	}

	private void addNews(long timestamp, int i) {
		NewsEntry newsEntry = new NewsEntry();
		newsEntry.setContent("This is example content " + i);
		newsEntry.setDate(new Date(timestamp));
		this.newsEntryDao.save(newsEntry);
	}

	private void addAdminUser() {
		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userDao.save(adminUser);
	}

	private void addUser() {
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.userDao.save(userUser);
	}

}