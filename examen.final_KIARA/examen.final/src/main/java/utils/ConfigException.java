package utils;

public class ConfigException extends Exception{

	private static final long serialVersionUID = -935408749921665540L;
	
	public ConfigException() {
		super();
	}
	
	public ConfigException(String message) {
		super(message);
	}
	
	public ConfigException(String message, Throwable e) {
		super(message, e);
	}
}
