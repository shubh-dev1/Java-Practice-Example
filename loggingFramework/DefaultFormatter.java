package loggingFramework;

public class DefaultFormatter implements LogFormatter{
  @Override
  public String format(LogMessage message) {
    return String.format("[%s] [%s] [%s] %s",
    message.getTimeStamp(),message.getThreadName(),message.getLevel(),message.getMessage());
  }
}
