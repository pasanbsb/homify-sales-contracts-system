package com.pasanbsb.hscs.web.impl;

import com.pasanbsb.hscs.web.WebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pasan on 5/1/2017.
 *
 * WebServerImpl is responsible for starting a standalone Jetty Server and deploy Jersey web services in com.pasanbsb.hscs.web.model package
 */
public class WebServerImpl implements WebServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServerImpl.class);

    public void start() {

        Server jettyServer = new Server(8085);


        ServletContextHandler servContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servContext.setContextPath("/customerservice");
        ServletHolder jerseyServlet = servContext.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.pasanbsb.hscs.web.model");
        jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        jettyServer.setHandler(servContext);
        try {

            try {
                jettyServer.start();
                LOGGER.info("server started");
                jettyServer.join();
            } catch (Exception e) {
                LOGGER.error("Error occurred", e);
            }
        } finally {
            jettyServer.destroy();
        }

    }
}
