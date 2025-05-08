package loggingFramework.logAppender;

import loggingFramework.LogFormatter;
import loggingFramework.LogMessage;

public class ConsoleAppender implements LogAppender{
  private final LogFormatter formatter;

  public ConsoleAppender(LogFormatter formatter){
    this.formatter = formatter;
  }

  @Override
  public void append(LogMessage logMessage) {
    System.out.println(formatter.format(logMessage));
  }
}
