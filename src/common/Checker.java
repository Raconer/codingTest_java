package common;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;

// ! 좀더 상세한 정보를 얻기 위한 Abstract Class를 만들었지만 "보류"
public abstract class Checker {

    static final Logger log = Logger.getLogger(Checker.class.getName());

    Instant start;

    @Before
    public void setTestStatTime() {
        this.start = Instant.now();
    }

    @After
    public void setTestEndTime() {
        long elapsedTime = Duration.between(start, Instant.now()).toNanos();
        System.out.println("elapsedTime(ms) : " + elapsedTime);
    }

    public abstract void singleTest();

    public abstract void manyTest();

}
