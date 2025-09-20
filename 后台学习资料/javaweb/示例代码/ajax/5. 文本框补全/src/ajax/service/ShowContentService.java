package ajax.service;

import java.util.List;

import model.ContentModel;

import org.json.JSONArray;
import org.json.JSONObject;

import ajax.dao.ShowContentDao;

public class ShowContentService {

	public String showContens(String con){
		ShowContentDao scd = new ShowContentDao();
		
		JSONArray jsa=new JSONArray();
		List cons = scd.selAll(con);
		if(cons != null){
			for(int i=0; i<cons.size(); i++){
				ContentModel cm = (ContentModel) cons.get(i);
				jsa.put(new JSONObject(cm));
			}
		}
		
		return jsa.toString();
	}
}
