package com.gh.jordner.jpa.osgi;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.gh.jordner.jpa.JPAConstants;

public class Activator implements BundleActivator, ServiceTrackerCustomizer {

	private static ServiceTracker emfTracker;
	private static BundleContext bundleContext;

	public void start(BundleContext context) {
		emfTracker = new ServiceTracker(context,
				EntityManagerFactory.class.getName(), null);
		emfTracker.open();
		System.out.println("Gemini JPA Sample started");
	}

	public void stop(BundleContext context) {
		this.bundleContext = context;
		emfTracker.close();
		emfTracker = null;
		System.out.println("Gemini JPA Sample stopped");
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = null;
		if (emfTracker == null) {
			return null;
		}
		final Object service = emfTracker.getService();

		if (service != null) {
			EntityManagerFactory emf = (EntityManagerFactory) service;
			if (emf != null) {
				entityManager = emf.createEntityManager();
			}
		}

		return entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	// public void start(BundleContext bundleContext) throws Exception {
	// Activator.context = bundleContext;
	// // client = new Client();
	// System.out.println("Gemini JPA Sample started");
	//
	// /*
	// * We are in the same bundle as the persistence unit so the services
	// * should be available when we start up (if nothing bad happened) and
	// * the tracker is really just saving us the lookup, but this is the idea
	// * of how you would listen for a persistence unit coming from another
	// * bundle.
	// */
	// emfTracker = new ServiceTracker(Activator.context,
	// EntityManagerFactory.class.getName(), this);
	// emfTracker.open();
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	// public void stop(BundleContext bundleContext) throws Exception {
	// Activator.context = null;
	// emfTracker.close();
	// // client = null;
	// System.out.println("Gemini JPA Sample stopped");
	// }

	// @Override
	// public Object addingService(ServiceReference reference) {
	// System.out.println("register service reference");
	// Bundle b = reference.getBundle();
	// Object service = b.getBundleContext().getService(reference);
	// String unitName = (String) reference
	// .getProperty(EntityManagerFactoryBuilder.JPA_UNIT_NAME);
	// if (unitName.equals(JPAConstants.JPA_UNIT)) {
	// // TODO
	// // client.run((EntityManagerFactory) service);
	// System.out.println("save called");
	// }
	// return service;
	// }

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
		System.out.println("modified Service");

	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		System.out.println("removed Service");

	}

	@Override
	public Object addingService(ServiceReference reference) {
		System.out.println("add Service");
		return null;
	}

	public BundleContext getBundleContext() {
		return bundleContext;
	}

	// public void bindEntityManagerFactoryBuilder(EntityManagerFactoryBuilder
	// emfBuilder, Map properties){
	//
	// }

}
