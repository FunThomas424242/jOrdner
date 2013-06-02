package com.gh.jordner.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import com.gh.jordner.api.Verzeichnis;

@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {

	public EntityManagerFactory lookupEMF(String unitName) {
		BundleContext context = com.gh.jordner.jpa.osgi.Activator.getContext();
		ServiceReference[] refs = null;
		try {
			refs = context.getServiceReferences(
					EntityManagerFactory.class.getName(), "(osgi.unit.name="
							+ unitName + ")");
		} catch (InvalidSyntaxException isEx) {
			throw new RuntimeException("Filter error", isEx);
		}
		return (refs == null) ? null : (EntityManagerFactory) context
				.getService(refs[0]);
	}

	public Verzeichnis create(Verzeichnis verzeichnis) {
		System.out.println(verzeichnis);
		EntityManagerFactory emf = lookupEMF("Accounts");
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			em.persist(verzeichnis);
		}else{
			System.out.println("No EntityManagerFactory found");
		}
		return verzeichnis;
	}

}
