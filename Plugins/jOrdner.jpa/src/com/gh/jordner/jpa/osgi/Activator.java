package com.gh.jordner.jpa.osgi;

import javax.persistence.EntityManagerFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;



public class Activator implements BundleActivator, ServiceTrackerCustomizer<Object, Object> {

	private static BundleContext context;
	 ServiceTracker<?, ?> emfTracker;
	 //Client client;

	public static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	      //client = new Client();
	      System.out.println("Gemini JPA Sample started");

	      /*
	       * We are in the same bundle as the persistence unit so the services should be available when we start up (if
	       * nothing bad happened) and the tracker is really just saving us the lookup, but this is the idea of how you
	       * would listen for a persistence unit coming from another bundle.
	       */
	      emfTracker = new ServiceTracker<Object, Object>(Activator.context, EntityManagerFactory.class.getName(), this);
	      emfTracker.open();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		 emfTracker.close();
	      //client = null;
	      System.out.println("Gemini JPA Sample stopped");
	}

	@Override
	public Object addingService(ServiceReference reference) {
		System.out.println("register service reference");
		Bundle b = reference.getBundle();
	      Object service = b.getBundleContext().getService(reference);
	      String unitName = (String) reference.getProperty(EntityManagerFactoryBuilder.JPA_UNIT_NAME);
	      if (unitName.equals("Accounts")) {
	    	  //TODO
	         //client.run((EntityManagerFactory) service);
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

}
