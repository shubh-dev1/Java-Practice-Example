package loggingFramework;

import loggingFramework.logAppender.LogAppender;

public class LoggerConfig {
  private LogLevel level;
  private LogAppender logAppender;

  public LoggerConfig(LogLevel level, LogAppender logAppender) {
    this.level = level;
    this.logAppender = logAppender;
  }

  public LogLevel getLevel() {
    return level;
  }

  public void setLevel(LogLevel level) {
    this.level = level;
  }

  public LogAppender getLogAppender() {
    return logAppender;
  }

  public void setLogAppender(LogAppender logAppender) {
    this.logAppender = logAppender;
  }
}
