package utils;

public class ConfigException extends Exception{

	private static final long serialVersionUID = -935408749921665540L;

	public ConfigException () {
		super();
	}
	
	public ConfigException(String msg) {
		super(msg);
	}
	
	public ConfigException(String msg, Throwable e) {
		super(msg, e);
	}
}
