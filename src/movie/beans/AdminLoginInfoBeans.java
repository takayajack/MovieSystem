package movie.beans;

import java.io.Serializable;

public class AdminLoginInfoBeans implements Serializable {
	private String name;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
