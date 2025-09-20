package ajax.model;

import java.io.Serializable;

public class ContentModel implements Serializable{

	private String cid;
	private String content;
	
	public ContentModel(){
		
	}
	
	public ContentModel(String newcid, String newcon){
		this.cid = newcid;
		this.content = newcon;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String con) {
		this.content = con;
	}
	
}
