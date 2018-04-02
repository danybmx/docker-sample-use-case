package org.vigojug.dockerspringbootsample.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vigojug.dockerspringbootsample.model.GreetingMessage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Greetings controller.
 */
@RestController
@RequestMapping("/greeting")
public class Greetings {

    /**
     * The logger.
     */
    private Logger LOGGER = Logger.getLogger(Greetings.class.getName());

    /**
     * Just a delay that avoid ha-proxy to use the same instance.
     */
    private int sleepTime = 150;

    /**
     * An static counter.
     */
    private static int counter = 0;

    /**
     * Machine hostname.
     */
    private String hostname;

    /**
     * Default constructor.
     */
    public Greetings() {
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            this.hostname = "Unknown host";
        }
    }

    /**
     * Greetings web service.
     * @return the "Hello World" :).
     * @throws InterruptedException if the sleep was interrupted.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GreetingMessage getGreeting() throws InterruptedException {
        LOGGER.info("I got this one!");
        Thread.sleep(sleepTime);
        return new GreetingMessage(this.hostname, "Hello world!", ++counter);
    }

}
