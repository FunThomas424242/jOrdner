package com.gh.jordner.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;

import com.gh.jordner.api.Verzeichnis;

@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {

	@Inject
	@GeminiPersistenceContext(unitName = "Accounts")
//	@Inject
//	@GeminiPersistenceContext(unitName = "Accounts" , properties = {
//	@GeminiPersistenceProperty(name=JDBC_DRIVER, value="com.mysql.jdbc.Driver"),
//	@GeminiPersistenceProperty(name=JDBC_URL, value="jdbc:mysql://127.0.0.1/contacts"),
//	@GeminiPersistenceProperty(name=JDBC_USER, value="contact"),
//	@GeminiPersistenceProperty(name=JDBC_PASSWORD, value="contact"),
//	@GeminiPersistenceProperty(name=DDL_GENERATION, value=DROP_AND_CREATE),
//	@GeminiPersistenceProperty(name=DDL_GENERATION_MODE, value=DDL_DATABASE_GENERATION) })
	private EntityManager em;

	public Verzeichnis create(Verzeichnis verzeichnis) {
		System.out.println(verzeichnis);
		if (em != null) {
			em.persist(verzeichnis);
		} else {
			System.out.println("No EntityManager found");
		}
		// EntityManagerFactory emf = Activator.lookupEMF("Accounts");
		// if (emf != null) {
		// EntityManager em = emf.createEntityManager();
		// em.persist(verzeichnis);
		// } else {
		// System.out.println("No EntityManagerFactory found");
		// }
		return verzeichnis;
	}

}
