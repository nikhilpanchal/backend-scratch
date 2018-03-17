package com.nikhil.functional.patterns;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Loan Pattern, where a class exposes a static function that accepts a function.
 *
 * The class creates an instance and passes that instance to the accepted function, allowing
 * the function to do whatever it wants to that instance for a while (loaning that instance
 * out). When the function is done doing what it needs to on the instance, the class
 * performs any clean up that is required.
 *
 * So you can think of this as the class "loaning" out an instance to the function temporarily
 */
public class MailerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailerTest.class.getName());

    @Before
    public void setup() {
    }

    @Test
    public void should_call_pre_and_post_processors_after_executing_function_bdoy() {
        // given
        Mailer mailerSpy = Mockito.spy(new Mailer());
        Mailer.INSTANCE = mailerSpy;

        // when
        Mailer.sendMail(mail -> {
            mail.to("nikhil@invalid.abc")
                    .cc("erica@invalid.abc")
                    .subject("Testing fluent and loan pattern")
                    .body("Pretty cool that I get an object, do what I want with it, and " +
                            "Mailer takes care of setup and cleanup for me");
        }, mail -> {
            mail.gatherMetrics(10);
        });

        // then
        // Ensure that the required methods around the block are called.
        Mockito.verify(mailerSpy).init();
        Mockito.verify(mailerSpy).send();
        Mockito.verify(mailerSpy).close();
    }
}
