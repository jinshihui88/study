package paging;

import java.util.List;

public class PagingService {

	public List<EMPModel> queryByPage(int currPage, int pageSize){
		int start =0;
		int end = currPage * pageSize;
		
		if(currPage < 1){
			currPage = 1;
		}
		start = (currPage-1) * pageSize + 1;
		
		return new PagingDAO().query(start, end);
	}
}
