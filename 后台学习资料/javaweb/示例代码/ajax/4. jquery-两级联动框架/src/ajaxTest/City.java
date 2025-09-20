package ajaxTest;

import java.io.Serializable;

public class City implements Serializable{
	private String city_id;
	private String city_name;
	
	public City() {
		
	}
	public City(String cityId, String cityName) {
		city_id = cityId;
		city_name = cityName;
	}
	
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String cityId) {
		city_id = cityId;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String cityName) {
		city_name = cityName;
	}
}
