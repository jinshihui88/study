package com.zzzyedu.utils;



public class PageController {
	int totalRowsAmount; // ������
	boolean rowsAmountSet; // �Ƿ����ù�totalRowsAmount
	int pageSize = 2; // ÿҳ����
	int currentPage = 0; // ��ǰҳ��
	int nextPage;//��ҳ
	int previousPage;//ǰҳ
	int totalPages; // ��ҳ��
	boolean hasNext; // �Ƿ�����һҳ
	boolean hasPrevious; // �Ƿ���ǰһҳ
	String description;//��ʾ��Ϣ
	int pageStartRow;//��ҳ��ʼ��
	int pageEndRow;//��ҳ������
	//���췽�� ������������ÿҳ��ʾ����
	public PageController(int totalRows, int pageSize) {
		setPageSize(pageSize);
		setTotalRowsAmount(totalRows);
	}
	//�趨������ �õ���ҳ��
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
	//�趨��ǰҳ �� ���㿪ʼ�кͽ����� ���õ��Ƿ���ǰ��ҳ
	public void setCurrentPage(int i) {
		currentPage = i;
		nextPage = currentPage + 1;
		previousPage = currentPage - 1;
		// ���㵱ǰҳ��ʼ�кͽ�����
		if (currentPage * getPageSize() < totalRowsAmount) {
			pageEndRow = currentPage * getPageSize();
			pageStartRow = pageEndRow - getPageSize() + 1;

		} else {
			pageEndRow = totalRowsAmount;
			pageStartRow = this.getPageSize() * (totalPages - 1) + 1;
		}

		// �Ƿ����ǰҳ�ͺ�ҳ
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
	//��õ�ǰҳ
	public int getCurrentPage() {
		return currentPage;
	}
	//�Ƿ��к�ҳ
	public boolean isHasNext() {
		return hasNext;
	}
	public boolean getHasNext(){
		return hasNext;
	}
	//�Ƿ���ǰҳ
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public boolean getHasPrevious(){
		return hasPrevious;
	}
	//�õ���һҳ
	public int getPreviousPage() {
		return previousPage;
	}
	//�õ���һҳ
	public int getNextPage() {
		return nextPage;
	}
	//�õ�ÿҳ��ʵ����
	public int getPageSize() {
		return pageSize;
	}
	//�õ���ҳ��
	public int getTotalPages() {
		return totalPages;
	}
	//�õ�������
	public int getTotalRowsAmount() {
		return totalRowsAmount;
	}
	//�õ���ҳ��ʼ�к�
	public int getPageStartRow() {
		return pageStartRow;
	}
	//�õ���ҳ�����к�
	public int getPageEndRow() {
		return pageEndRow;
	}
	
	//һ��ȫ��Ϊ�趨ֵ���� 
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
		String description = "����������:" + this.getTotalRowsAmount() + " | ��ҳ���� "
				+ this.getTotalPages() + " | ��ǰҳ:" + this.currentPage
				+ " | �Ƿ���ǰҳ��" + this.hasPrevious + " | �Ƿ��к�ҳ:" + this.hasNext
				+ " | ��ҳ��ʼ�к�:" + this.pageStartRow + " | ��ҳ�����к�:"
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
