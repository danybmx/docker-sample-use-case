package org.vigojug.dockerspringbootsample.model;

/**
 * A model class for the GreetingMessage.
 */
public class GreetingMessage {

    /**
     * The server in which the request was processed.
     */
    private String server;

    /**
     * A simple message.
     */
    private String message;

    /**
     * Add the counter.
     */
    private int count;

    /**
     * Default constructor.
     * @param server the server value.
     * @param message the message value.
     */
    public GreetingMessage(String server, String message, int count) {
        this.server = server;
        this.message = message;
        this.count = count;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
