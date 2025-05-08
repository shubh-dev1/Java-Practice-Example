package loggingFramework.logAppender;

import loggingFramework.LogMessage;

public interface LogAppender {
  void append(LogMessage logMessage);
}
