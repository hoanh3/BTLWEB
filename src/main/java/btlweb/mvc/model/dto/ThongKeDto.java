package btlweb.mvc.model.dto;

import java.util.List;

public class ThongKeDto {
	private int revenue;
	private int numberOfOrder;
	private List<TopCate> list;
	
	public ThongKeDto(int revenue, int numberOfOrder, List<TopCate> list) {
		super();
		this.revenue = revenue;
		this.numberOfOrder = numberOfOrder;
		this.list = list;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getNumberOfOrder() {
		return numberOfOrder;
	}

	public void setNumberOfOrder(int numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}

	public List<TopCate> getList() {
		return list;
	}

	public void setList(List<TopCate> list) {
		this.list = list;
	}
}
