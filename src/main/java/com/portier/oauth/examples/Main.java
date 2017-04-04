package com.portier.oauth.examples;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Main class running jetty and loading rest endpoints.
 * @author p
 *
 */
public class Main {
     /**
      ** the main function for the class.
      ** @param args function arguments.
      ** @throws Exception any exception.
      **/
    public static void main(String[] args) throws Exception {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/oauthpoc");
        Server jettyServer = new Server(8081);
        jettyServer.setHandler(context);
        context.setBaseResource(Resource.newResource("src/main/webapp"));
        context.setExtraClasspath("src/main/resources");       
        try {
            jettyServer.start();
           java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://localhost:8081/oauthpoc/api/oauthgoogle"));
           jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
   }
}
