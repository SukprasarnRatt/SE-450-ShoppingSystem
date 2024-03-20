package depaul.edu;

import java.util.List;

public interface Logger {
    void log(String message);
    List<String> getLogMessages();
}

