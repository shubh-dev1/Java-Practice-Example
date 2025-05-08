package loggingFramework;

import loggingFramework.logAppender.FileAppender;

public class LoggingFrameworkDemo {
  public static void main(String[] args) {
    run();
  }

  public static void run(){
    Logger logger = Logger.getInstance();

    // Logging with default configuration
    logger.info("This is an information message");
    logger.warning("This is warning message");
    logger.error("this is error message");

    // changing log level and appender
    LoggerConfig config = new LoggerConfig(LogLevel.DEBUG,new FileAppender("app.log",new DefaultFormatter()));
    logger.setConfig(config);

    logger.debug("this is a debug message");
    logger.info("this is an information message");
  }
}
