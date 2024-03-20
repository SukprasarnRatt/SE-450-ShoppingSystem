package depaul.edu;

import java.util.ArrayList;
import java.util.List;

public class MemoryLogger implements Logger {
    private List<String> logMessages = new ArrayList<>();

    @Override
    public void log(String message) {
        logMessages.add(message);
       
    }

    @Override
    public List<String> getLogMessages() {
        return logMessages;
    }
}

