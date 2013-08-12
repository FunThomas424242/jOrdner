package com.gh.jordner.jpa.filesystem;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;

@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {

	@Inject
	@GeminiPersistenceContext(unitName = JPAConstants.JPA_UNIT
	// , properties = {
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_USER,
	// value = "sa"),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.JDBC_PASSWORD, value = ""),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_DRIVER,
	// value = "org.h2.Driver"),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_URL,
	// value = JPAConstants.H2_URL_SERVER),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.LOGGING_LEVEL, value = "FINE"),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING,
	// value = "false"),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.WEAVING_INTERNAL, value = "false"),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.DDL_GENERATION, value =
	// PersistenceUnitProperties.DROP_AND_CREATE),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.DDL_GENERATION_MODE, value =
	// PersistenceUnitProperties.DDL_DATABASE_GENERATION)
	// }
	)
	private EntityManager em;

	@Override
	public void save(Verzeichnis dataObj) throws SQLException {
		checkConnection();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(dataObj);
		trx.commit();
	}

	@Override
	public List<Verzeichnis> allEntries() {
		// HINT:
		// http://www.adam-bien.com/roller/abien/entry/selecting_all_jpa_entities_as
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Verzeichnis> cq = cb
				.createQuery(Verzeichnis.class);
		Root<Verzeichnis> rootEntry = cq.from(Verzeichnis.class);
		CriteriaQuery<Verzeichnis> all = cq.select(rootEntry);
		TypedQuery<Verzeichnis> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	@PreDestroy
	public void destroy() {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	private void checkConnection() throws SQLException {
		if (em == null) {
			throw new SQLException(
					"EntityManager is null. Not connected to database!");
		}
	}
}
