package loggingFramework;

public class LogMessage {
  private final LogLevel level;
  private final String message;
  private final long timeStamp;
  private final String threadName;

  public LogMessage(LogLevel level,String message){
    this.level = level;
    this.message = message;
    this.timeStamp = System.currentTimeMillis();
    this.threadName = Thread.currentThread().getName();
  }

  public LogLevel getLevel() {
    return level;
  }

  public String getMessage() {
    return message;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public String getThreadName() {
    return threadName;
  }

  public String toString(){
    return "[" + level + "]" + timeStamp + " - " + message;
  }
}
