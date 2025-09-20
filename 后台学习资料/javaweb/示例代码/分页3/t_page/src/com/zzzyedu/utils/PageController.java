package com.zzzyedu.utils;



public class PageController {
	int totalRowsAmount; // 总行数
	boolean rowsAmountSet; // 是否设置过totalRowsAmount
	int pageSize = 2; // 每页行数
	int currentPage = 0; // 当前页码
	int nextPage;//后页
	int previousPage;//前页
	int totalPages; // 总页数
	boolean hasNext; // 是否有下一页
	boolean hasPrevious; // 是否有前一页
	String description;//提示信息
	int pageStartRow;//本页开始行
	int pageEndRow;//本页结束行
	//构造方法 传入总行数、每页显示条数
	public PageController(int totalRows, int pageSize) {
		setPageSize(pageSize);
		setTotalRowsAmount(totalRows);
	}
	//设定总行数 得到总页数
	public void setTotalRowsAmount(int i) {
		if (!this.rowsAmountSet) {
			totalRowsAmount = i;
			if (totalRowsAmount % getPageSize() == 0) {
				totalPages = totalRowsAmount / getPageSize();
			} else {
				totalPages = totalRowsAmount / getPageSize() + 1;
			}
			this.rowsAmountSet = true;
		}

	}
	//设定当前页 并 计算开始行和结束行 并得到是否有前后页
	public void setCurrentPage(int i) {
		currentPage = i;
		nextPage = currentPage + 1;
		previousPage = currentPage - 1;
		// 计算当前页开始行和结束行
		if (currentPage * getPageSize() < totalRowsAmount) {
			pageEndRow = currentPage * getPageSize();
			pageStartRow = pageEndRow - getPageSize() + 1;

		} else {
			pageEndRow = totalRowsAmount;
			pageStartRow = this.getPageSize() * (totalPages - 1) + 1;
		}

		// 是否存在前页和后页
		if (nextPage > totalPages) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		if (previousPage == 0) {
			hasPrevious = false;
		} else {
			hasPrevious = true;
		}
		
		//System.out.println(this.description());
	}
	//获得当前页
	public int getCurrentPage() {
		return currentPage;
	}
	//是否有后页
	public boolean isHasNext() {
		return hasNext;
	}
	public boolean getHasNext(){
		return hasNext;
	}
	//是否有前页
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public boolean getHasPrevious(){
		return hasPrevious;
	}
	//得到上一页
	public int getPreviousPage() {
		return previousPage;
	}
	//得到下一页
	public int getNextPage() {
		return nextPage;
	}
	//得到每页现实条数
	public int getPageSize() {
		return pageSize;
	}
	//得到总页数
	public int getTotalPages() {
		return totalPages;
	}
	//得到总行数
	public int getTotalRowsAmount() {
		return totalRowsAmount;
	}
	//得到本页开始行号
	public int getPageStartRow() {
		return pageStartRow;
	}
	//得到本页结束行号
	public int getPageEndRow() {
		return pageEndRow;
	}
	
	//一下全部为设定值方法 
	public void setHasNext(boolean b) {
		hasNext = b;
	}

	public void setHasPrevious(boolean b) {
		hasPrevious = b;
	}

	public void setNextPage(int i) {
		nextPage = i;
	}

	public void setPageSize(int i) {
		pageSize = i;
	}

	
	public void setPreviousPage(int i) {
		previousPage = i;
	}

	
	public void setTotalPages(int i) {
		totalPages = i;
	}

	

	public String description() {
		String description = "数据总条数:" + this.getTotalRowsAmount() + " | 总页数： "
				+ this.getTotalPages() + " | 当前页:" + this.currentPage
				+ " | 是否有前页：" + this.hasPrevious + " | 是否有后页:" + this.hasNext
				+ " | 本页开始行号:" + this.pageStartRow + " | 本页结束行号:"
				+ this.pageEndRow;
		return description;
	}

	public static void main(String args[]) {
	 PageController pc=new PageController(10,4);
		 //System.out.println(pc.getDescription());
		 pc.setCurrentPage(1);
		 System.out.println(pc.description());
		 pc.setCurrentPage(3);
		 System.out.println(pc.description());
	}
}
