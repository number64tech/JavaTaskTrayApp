package jp.number64.tasktray;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrayWorkerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrayWorkerTest.class);

    @Test
    public void case01() {
        LOGGER.debug("case01");
        assertEquals(true, true);
    }
}
