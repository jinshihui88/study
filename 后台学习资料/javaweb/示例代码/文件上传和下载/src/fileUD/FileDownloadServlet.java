package fileUD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("start to download file...");
		
		String path = "D:\\installFile\\Tomcat 6.0\\webapps\\servletExam1\\uploadFiles\\20120728_105552.jpg";
		File f = new File(path);
		if(f.exists()){
			resp.setContentType("application/x-msdownload");
			resp.setContentLength((int)f.length());
			resp.setHeader("Content-Disposition", "attachment;"+ " filename=stone.jpg");
			
			//���������������
			OutputStream out = resp.getOutputStream();
			
			//�������ˣ���Ӳ�̵��ڴ��������
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			byte[] b = new byte[1024];
			while((bis.read(b)) > 0){
				//�ӷ������ڴ�  �����  �ͻ��ˣ�
				out.write(b);
			}
			
			out.flush();
			out.close();
			bis.close();
		}else{
			System.out.println("�ļ������ڡ�����");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
