package MyPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Configurator;
//import org.apache.logging.log4j.PropertyConfigurator;
//import org.

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class log4j{

   /* Get actual class name to be printed on */
   //static Logger log = Logger.getLogger(log4j.class.getName());
   
   public static void main(String[] args)throws IOException,SQLException{
      Logger log = LogManager.getLogger(MyClass.class);
   }
}