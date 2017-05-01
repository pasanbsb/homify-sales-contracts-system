package com.pasanbsb.hscs.app;

import com.pasanbsb.hscs.web.WebServer;

/**
 * Hello world!
 */
public class App
{
    /**
     * The entry point of application.
     * Starts jetty server and deploy web services
     * @param args the input arguments
     */
    public static void main( String[] args )
    {
        WebServer webServer = WebServer.getInstance();
        webServer.start();

    }
}
