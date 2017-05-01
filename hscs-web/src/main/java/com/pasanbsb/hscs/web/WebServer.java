package com.pasanbsb.hscs.web;

import com.pasanbsb.hscs.web.impl.WebServerImpl;

/**
 * Created by Pasan on 5/1/2017.
 */
public interface WebServer {

    /**
     * The constant WEB_SERVER.
     */
    WebServer WEB_SERVER = new WebServerImpl();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    static WebServer getInstance() {
        return WEB_SERVER;
    }

    /**
     * Start.
     */
    void start();
}
