package com.portier.oauth;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class TestOAuth {
	public static void main(String[] args) throws Exception {
		WebAppContext context = new WebAppContext();
		context.setContextPath("/oauthpoc");
		Server jettyServer = new Server(8081);
		jettyServer.setHandler(context);
	    context.setBaseResource(Resource.newResource("src/main/webapp"));
	    context.setExtraClasspath("src/main/resources");
	       
	        
		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}
}