package us.ncleves.skidmore.webapps.web;

public class RuntimeBean {
	
	public RuntimeBean(double time, String algorithm_name, long char_count){
		setTime(time);
		setAlgorithm_name(algorithm_name);
		setChar_count(char_count);
	}
	
	private double time;
	private String algorithm_name; 
	private long char_count;
	
	public double getTime() {
		return time;
		
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getAlgorithm_name() {
		return algorithm_name;
	}
	public void setAlgorithm_name(String algorithm_name) {
		this.algorithm_name = algorithm_name;
	}
	public long getChar_count() {
		return char_count;
	}
	public void setChar_count(long char_count) {
		this.char_count = char_count;
	}
	
}

