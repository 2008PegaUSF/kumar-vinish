package bankingApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import util.ConnFactory;

public class Driver {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	public static void main(String[] args) {
		Configurator.initialize(null, "log4j.xml");	
		atm bank = new atm();
		bank.battery();
	}
}