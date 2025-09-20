package com.test.service;

import java.util.List;

import com.test.dao.TestDao;
import com.test.model.TestModel;
import com.test.util.Util;

public class TestService {

	/**
	 * ��ҳ�������ҳ��Ӧ��ʾ������    ��ʼ��    ��     ������    ��
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
	 * ȡ��test�е�������Ϣ������Ȼ�������ҳ��
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
