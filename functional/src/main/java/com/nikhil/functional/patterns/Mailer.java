package com.nikhil.functional.patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class Mailer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Mailer.class.getName());

    private String to;
    private String cc;
    private String subject;
    private String body;
    private int metrics;

    public static Mailer INSTANCE;

    public Mailer to(String toAddress) {
        this.to = toAddress;
        return this;
    }

    public Mailer cc(String ccAddress) {
        this.cc = ccAddress;
        return this;
    }

    public Mailer subject(String subject) {
        this.subject = subject;
        return this;
    }

    public Mailer body(String body) {
        this.body = body;
        return this;
    }

    public Mailer gatherMetrics(int timeToCompose) {
        this.metrics = timeToCompose;
        return this;
    }

    public void init() {
        LOGGER.info("Setting up the connection");
    }

    public void send() {
        LOGGER.info("Sending out the mail {}", this.toString());
    }

    public void close() {
        LOGGER.info("Closing the mail");
    }

    public static void sendMail(Consumer<Mailer> block, Consumer<Mailer> chain) {
        Mailer mail = INSTANCE;

        try {
            // Initialize
            mail.init();

            // pass the initialized mail object to the provided function so it can do
            // whatever it wants to it.
            // Compose a chain of consumers so that they will be automatically called
            // one after the other.
            block.andThen(chain).accept(mail);

            // Send out the mail.
            mail.send();
        } finally {
            // Clean up
            mail.close();
        }
    }


    @Override
    public String toString() {
        return "Mailer{\n" +
                "to='" + to + '\'' +
                ",\n cc='" + cc + '\'' +
                ",\n subject='" + subject + '\'' +
                ",\n body='" + body + '\'' +
                ",\n metrics=" + metrics +
                "\n}";
    }
}
