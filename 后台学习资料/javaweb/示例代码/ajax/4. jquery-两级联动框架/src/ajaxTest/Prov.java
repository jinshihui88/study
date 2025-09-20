package ajaxTest;

import java.io.Serializable;

public class Prov implements Serializable  {
	private String prov_id;
	private String prov_name;
	
	public Prov() {
		
	}

	public Prov(String provId, String provName) {
		prov_id = provId;
		prov_name = provName;
	}

	public String getProv_id() {
		return prov_id;
	}

	public void setProv_id(String provId) {
		prov_id = provId;
	}

	public String getProv_name() {
		return prov_name;
	}

	public void setProv_name(String provName) {
		prov_name = provName;
	}
}
