package btlweb.mvc.model.dto;

public class ItemDto {
	private int pid;
	private int uid;
	private int size;
	private int num;
	
	public ItemDto() {
		super();
	}
	

	public ItemDto(int pid, int uid, int size, int num) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.size = size;
		this.num = num;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
