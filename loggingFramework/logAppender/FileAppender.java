package loggingFramework.logAppender;

import loggingFramework.LogFormatter;
import loggingFramework.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender  implements LogAppender{

  private FileWriter fileWriter;
  private final LogFormatter formatter;

  public FileAppender(String filePath,LogFormatter formatter){
    this.formatter = formatter;
    try{
      this.fileWriter = new FileWriter(filePath,true);
    }catch (Exception e){
      System.out.println("Failed to create writer for file logs,exception: "+e.getMessage());
    }
  }
  @Override
  public void append(LogMessage logMessage) {
    try{
      fileWriter.write(formatter.format(logMessage) + "\n");
      fileWriter.flush();
    }catch (IOException e){
      System.out.println("Failed to write logs to file,exception: "+e.getMessage());
    }
  }
}
