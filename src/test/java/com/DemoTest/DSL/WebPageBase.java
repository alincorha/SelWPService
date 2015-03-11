package com.DemoTest.DSL;

/**
 * Abstract class meant to be extended by all web pages
 * 'Page as a service' model - a page is fully loaded when all it's services are available
 * Created by acorha
 */
public abstract class WebPageBase {

    //abstract class which has to be defined inside all web pages
    //the method (when implemented) will if a certain condition is true or else timeout
    public abstract boolean waitUntilThePageIsLoaded(long time, long period);

}
