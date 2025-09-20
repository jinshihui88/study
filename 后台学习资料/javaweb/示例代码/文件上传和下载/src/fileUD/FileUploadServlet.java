
package fileUD;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;

public class FileUploadServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("start to upload file...");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List fileItems = null;
		FileItem fi = null;
		
		try {
			fileItems = sfu.parseRequest(req);
			if(fileItems != null){
				for(int i=0; i< fileItems.size(); i++){
					fi = (FileItem) fileItems.get(i);
					
					System.out.println("contentType: " + fi.getContentType());
					System.out.println("fieldName: " + fi.getFieldName());
					System.out.println("name: " + fi.getName());
					System.out.println("size: " + fi.getSize());
					//System.out.println("String: " + fi.getString());
					System.out.println("isFormField: " + fi.isFormField());
					System.out.println("isInMemory: " + fi.isInMemory());
					System.out.println("====================================" );
					
					if(fi.isFormField()){
						//����Ǳ�Ԫ�أ����ȡ��ֵ��
						System.out.println(req.getParameter(fi.getFieldName()));
						System.out.println(fi.getString());
					}else{
						//�������ϴ��ļ�Ԫ��:
						
						//��ȡ�ϴ��ļ������֣�
						String fileName = fi.getName();
						if ((fileName != null) && (fileName.length() > 0)) {
							fileName = fileName.substring(fileName.lastIndexOf(File.separatorChar) + 1);
							
							System.out.println("the name of upload file is: " + fileName);
						}
						
						//�ļ��ϴ����������δ�--·����
						String base = req.getSession().getServletContext().getRealPath("");
						System.out.println("base1: " + base);
						
						String path = base + File.separator + "uploadFiles" + File.separator + fileName;
						System.out.println("the path of upload file at server is: " + path);
						
						//�ϴ��ļ���
						//fi.write(new File(path));
						
						//д��·����
						fi.write(new File("F:\\fileTest\\uploadFiles\\sql.txt"));
						fi.write(new File("F:\\fileTest\\uploadFiles\\sql.sql"));
						
						//��Ӧ�ͻ��ˣ�
						PrintWriter out = new PrintWriter(resp.getOutputStream());
						out.println("upload file successed...");
						out.flush();
						out.close();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
