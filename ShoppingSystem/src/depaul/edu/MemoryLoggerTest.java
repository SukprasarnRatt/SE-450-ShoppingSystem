package depaul.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MemoryLoggerTest {

    private MemoryLogger logger;

    @BeforeEach
    void setUp() {
        logger = new MemoryLogger();
    }

    @Test
    void testLogSingleMessage() {
        String message = "Test message 1";
        logger.log(message);
        List<String> messages = logger.getLogMessages();

        assertNotNull(messages);
        assertEquals(1, messages.size());
        assertEquals(message, messages.get(0));
    }

    @Test
    void testLogMultipleMessages() {
        String message1 = "Test message 1";
        String message2 = "Test message 2";
        
        logger.log(message1);
        logger.log(message2);
        List<String> messages = logger.getLogMessages();

        assertNotNull(messages);
        assertEquals(2, messages.size());
        assertEquals(message1, messages.get(0));
        assertEquals(message2, messages.get(1));
    }

    
}
