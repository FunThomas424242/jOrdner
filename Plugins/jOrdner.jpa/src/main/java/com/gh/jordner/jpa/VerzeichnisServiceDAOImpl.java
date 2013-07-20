package com.gh.jordner.jpa;

import java.sql.SQLException;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;

import com.gh.jordner.api.Verzeichnis;


@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {


	@Inject
	@GeminiPersistenceContext(unitName = JPAConstants.JPA_UNIT
//	, properties = {
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_USER, value = "sa"),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_PASSWORD, value = ""),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_DRIVER, value = "org.h2.Driver"),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_URL, value = JPAConstants.H2_URL_SERVER),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.LOGGING_LEVEL, value = "FINE"),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING, value = "false"),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING_INTERNAL, value = "false"),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.DDL_GENERATION, value = PersistenceUnitProperties.DROP_AND_CREATE),
//			@GeminiPersistenceProperty(name = PersistenceUnitProperties.DDL_GENERATION_MODE, value = PersistenceUnitProperties.DDL_DATABASE_GENERATION) 
//			}
	)
	private EntityManager em;


	
	public void save(Verzeichnis dataObj) throws SQLException {
		checkConnection();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(dataObj);
		trx.commit();
	}

	@PreDestroy
	public void destroy() {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	
	private void checkConnection() throws SQLException {
		if (em == null) {
			throw new SQLException("EntityManager is null. Not connected to database!");
		}
	}
}
