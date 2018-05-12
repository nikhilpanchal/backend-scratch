package com.nikhil.functional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class RodCutter {
    private Logger LOGGER = LoggerFactory.getLogger(RodCutter.class);

    private Supplier<Integer> factory = () -> createAndCache();

    public void maxProfit(int length) {
        if (length == 0) {
            LOGGER.debug("Zero length, something going wrong here");
            throw new RuntimeException("Something went wrong here");
        }
    }

    public Integer createAndCache() {
        class HeavyFactory implements Supplier<Integer> {
            private Integer theThing = new Integer(5);

            @Override
            public Integer get() {
                return theThing;
            }
        }

        // Future calls to factory.get() will straightaway invoke HeavyFactory.get()
        // and will not come to createandcache.
        factory = new HeavyFactory();
        return factory.get();
    }


    // Functional interface instances can be used for lazy evaluation of code.
    // Rather than making a call and storing the result, create an instance of Supplier
    // that wraps the call and invoke the supplier only when you need it.
}
