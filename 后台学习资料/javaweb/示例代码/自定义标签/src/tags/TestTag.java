package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TestTag extends TagSupport{
	private int a1;
	private int a2;

	public int doEndTag() throws JspException {
		
		return this.EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.println(a1+a2);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.SKIP_BODY;
	}

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	public int getA2() {
		return a2;
	}

	public void setA2(int a2) {
		this.a2 = a2;
	}

}
