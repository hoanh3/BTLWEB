package btlweb.mvc.model.dto;

import java.util.List;

public class TopCate {
	private String title;
	private int num;
	public TopCate(String title, int num) {
		super();
		this.title = title;
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
