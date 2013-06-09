package com.gh.jordner.jpa.osgi;

import java.util.Map;

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

	private static BundleContext context;
	ServiceTracker emfTracker;

	// Client client;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		// client = new Client();
		System.out.println("Gemini JPA Sample started");

		/*
		 * We are in the same bundle as the persistence unit so the services
		 * should be available when we start up (if nothing bad happened) and
		 * the tracker is really just saving us the lookup, but this is the idea
		 * of how you would listen for a persistence unit coming from another
		 * bundle.
		 */
		emfTracker = new ServiceTracker(Activator.context,
				EntityManagerFactory.class.getName(), this);
		emfTracker.open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		emfTracker.close();
		// client = null;
		System.out.println("Gemini JPA Sample stopped");
	}

	@Override
	public Object addingService(ServiceReference reference) {
		System.out.println("register service reference");
		Bundle b = reference.getBundle();
		Object service = b.getBundleContext().getService(reference);
		String unitName = (String) reference
				.getProperty(EntityManagerFactoryBuilder.JPA_UNIT_NAME);
		if (unitName.equals(JPAConstants.JPA_UNIT)) {
			// TODO
			// client.run((EntityManagerFactory) service);
			System.out.println("save called");
		}
		return service;
	}

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub

	}

	/**
	 * User defined methods
	 */

	public static EntityManagerFactory lookupEMF(String unitName) {
		BundleContext context = Activator.getContext();
		ServiceReference refs[] = null;
		try {
			refs = context.getServiceReferences((String)null, (String)null);
			refs = context.getServiceReferences(
					EntityManagerFactory.class.getName(), "(osgi.unit.name="
							+ unitName + ")");
		} catch (InvalidSyntaxException isEx) {
			throw new RuntimeException("Filter error", isEx);
		}
		return (refs == null) ? null : (EntityManagerFactory) context
				.getService(refs[0]);
	}

	public EntityManagerFactory getEMF(String unitName,
			Map<String, String> props) {
		ServiceReference[] refs = null;
		EntityManagerFactoryBuilder emfb = null;

		try {
			refs = context.getServiceReferences(
					EntityManagerFactoryBuilder.class.getName(),
					"(osgi.unit.name=" + unitName + ")");
		} catch (InvalidSyntaxException isEx) {
			throw new RuntimeException("Filter error", isEx);
		}
		if (refs != null)
			emfb = (EntityManagerFactoryBuilder) context.getService(refs[0]);
		return (emfb == null) ? null : emfb.createEntityManagerFactory(props);
	}

}
