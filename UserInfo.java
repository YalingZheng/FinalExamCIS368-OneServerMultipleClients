

import java.io.Serializable;

public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9054431724786129791L;
	private int height;
	private int weight;
	
	
	public UserInfo(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
