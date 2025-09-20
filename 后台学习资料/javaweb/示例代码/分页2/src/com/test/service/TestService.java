package com.test.service;

import java.util.List;

import com.test.dao.TestDao;
import com.test.model.TestModel;
import com.test.util.Util;

public class TestService {

	/**
	 * 分页，计算该页所应显示的数据    起始行    和     结束行    数
	 * 
	 * @param currentPage
	 *            int
	 * @param line
	 *            int
	 * @return
	 */
	public List<TestModel> getInfor(int currentPage) {
		TestDao dao = new TestDao();
		currentPage = currentPage < 1 ? 1 : currentPage;
		System.out.println(currentPage);

		return dao.getInfor((currentPage - 1) * Util.LINE, currentPage
				* Util.LINE);
	}

	/**
	 * 取得test中的所有信息条数，然后计算总页数
	 * 
	 * @return int
	 */
	public int getAllNum() {
		TestDao dao = new TestDao();
		int count = dao.getAllNum();
		if (0 == count % Util.LINE) {
			return count / Util.LINE;
		} else {
			return count / Util.LINE + 1;
		}
	}

}
