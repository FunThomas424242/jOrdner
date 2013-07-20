package com.gh.jordner.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.gemini.ext.di.GeminiPersistenceProperty;
import org.eclipse.gemini.ext.di.GeminiPersistenceUnit;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.gh.jordner.api.Verzeichnis;

@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {

	// @Inject
	// @GeminiPersistenceContext(unitName = "Accounts" , properties = {
	// @GeminiPersistenceProperty(name=JDBC_DRIVER,
	// value="com.mysql.jdbc.Driver"),
	// @GeminiPersistenceProperty(name=JDBC_URL,
	// value="jdbc:mysql://127.0.0.1/contacts"),
	// @GeminiPersistenceProperty(name=JDBC_USER, value="contact"),
	// @GeminiPersistenceProperty(name=JDBC_PASSWORD, value="contact"),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_DRIVER,
	// valuePref = @Preference("jdbc_driver")),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_URL,
	// valuePref = @Preference("jdbc_url")),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.LOGGING_LEVEL, value = "FINE"),
	// @GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING,
	// value = "false"),
	// @GeminiPersistenceProperty(name =
	// PersistenceUnitProperties.WEAVING_INTERNAL, value = "false")
	// @GeminiPersistenceProperty(name=DDL_GENERATION, value=DROP_AND_CREATE),
	// @GeminiPersistenceProperty(name=DDL_GENERATION_MODE,
	// value=DDL_DATABASE_GENERATION) })

	@Inject
	@GeminiPersistenceUnit(unitName = JPAConstants.JPA_UNIT, properties = {
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_USER, value = "sa"),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_PASSWORD, value = ""),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_DRIVER, value = "org.h2.Driver"),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.JDBC_URL, value = JPAConstants.H2_URL_EMBEDDED),
			 @GeminiPersistenceProperty(name =
			 PersistenceUnitProperties.DDL_GENERATION, value =
			 PersistenceUnitProperties.DROP_AND_CREATE),
			 @GeminiPersistenceProperty(name =
			 PersistenceUnitProperties.DDL_GENERATION_MODE, value =
			 PersistenceUnitProperties.DDL_DATABASE_GENERATION),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING, value = "false"),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.WEAVING_INTERNAL, value = "false"),
			@GeminiPersistenceProperty(name = PersistenceUnitProperties.LOGGING_LEVEL, value = "FINE")

	})
	private EntityManager em;

	public Verzeichnis create(Verzeichnis verzeichnis) {
		System.out.println(verzeichnis);
		EntityManager entityManager = em;
		boolean isSelfCreated = false;

		try {

			if (entityManager != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(verzeichnis);
				entityManager.getTransaction().commit();
				entityManager.clear();
			} else {
				System.out.println("No Injected EntityManager  found");
			}

		} finally {
			if (isSelfCreated && entityManager != null) {
				entityManager.close();
			}
		}
		return verzeichnis;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// public static EntityManagerFactory lookupEMF(String unitName) {
	// BundleContext context = Activator.getContext();
	// ServiceReference refs[] = null;
	// try {
	// refs = context.getServiceReferences(
	// EntityManagerFactory.class.getName(), "(osgi.unit.name="
	// + unitName + ")");
	// } catch (InvalidSyntaxException isEx) {
	// throw new RuntimeException("Filter error", isEx);
	// }
	// return (refs == null) ? null : (EntityManagerFactory) context
	// .getService(refs[0]);
	// }
	//
	// public EntityManagerFactory getEMF(String unitName,
	// Map<String, String> props) {
	// ServiceReference[] refs = null;
	// EntityManagerFactoryBuilder emfb = null;
	// BundleContext context = Activator.getContext();
	//
	// try {
	// refs = context.getServiceReferences(
	// EntityManagerFactoryBuilder.class.getName(),
	// "(osgi.unit.name=" + unitName + ")");
	// } catch (InvalidSyntaxException isEx) {
	// throw new RuntimeException("Filter error", isEx);
	// }
	// if (refs != null)
	// emfb = (EntityManagerFactoryBuilder) context.getService(refs[0]);
	// return (emfb == null) ? null : emfb.createEntityManagerFactory(props);
	// }

}
