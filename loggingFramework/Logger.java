package loggingFramework;

import loggingFramework.logAppender.ConsoleAppender;

public class Logger {
  private static final Logger instance = new Logger(); // singleton

  private LoggerConfig config;

  private Logger(){
    // private constructor to enforce singleton pattern
    config = new LoggerConfig(LogLevel.INFO,new ConsoleAppender(new DefaultFormatter()));
  }

  public static Logger getInstance(){
    return instance;
  }

  public void setConfig(LoggerConfig config){
    this.config = config;
  }

  public void log(LogLevel level,String message){
    if(level.ordinal() >= config.getLevel().ordinal()){
      LogMessage logMessage = new LogMessage(level,message);
      config.getLogAppender().append(logMessage);
    }
  }

  public void debug(String message){
    log(LogLevel.DEBUG,message);
  }

  public void info(String message){
    log(LogLevel.INFO,message);
  }

  public void warning(String message){
    log(LogLevel.WARN,message);
  }
  public void error(String message){
    log(LogLevel.ERROR,message);
  }

  public void fatal(String message){
    log(LogLevel.FATAL,message);
  }

}
