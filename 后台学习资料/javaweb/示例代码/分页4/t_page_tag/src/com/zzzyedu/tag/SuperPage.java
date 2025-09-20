package com.zzzyedu.tag;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class SuperPage extends SimpleTagSupport {
	
    private String _count;
    private String _language;
    private String _mode;
    private String _pageCurrent;
    private String _pageSize;
    private String _pageURL;

    public void setCount(String value) {
        _count = value;
    }

    public void setLanguage(String value) {
        _language = value;
    }

    public void setMode(String value) {
        _mode = value;
    }

   
    public void setPageCurrent(String value) {
        _pageCurrent = value;
    }

   

    public void setPageSize(String value) {
        _pageSize = value;
    }

    public void setPageURL(String value) {
        _pageURL = value;
    }

    public void doTag() throws IOException, JspException {
        String linkURL = this._pageURL;
        int pageSize = Integer.parseInt(this._pageSize);
        int pageCurrent = 1;
        try {
            pageCurrent = Integer.parseInt(this._pageCurrent);
        } catch (NumberFormatException ex) {
        }
        //如果count<pageSize 则让count=pageCurrent.
        int count = Integer.parseInt(this._count)>pageSize?Integer.parseInt(this._count):pageCurrent;
        int pageNumber = (count + pageSize - 1) / pageSize;
        String language = this._language==null?"":this._language;
        String model = this._mode==null?"":this._mode;
        String first = "首页";
        String last = "尾页";
        String priv = "上一页";
        String next = "下一页";
        String di="第";
        String ye="页";
        JspWriter out = getJspContext().getOut();

        if (language.equals("en")) {
            first = "first";
            last = "last";
            priv = "priv";
            next = "next";
            di="page(";
            ye=")";
        }
        if (language.equals("pic")) {
            first = "&lt;&lt;";
            last = "&gt;&gt;";
            priv = "&lt;";
            next = "&gt;";
            di="page(";
            ye=")";
        }

        if (pageCurrent > pageNumber) {
            pageCurrent = pageNumber;
        }
        if (pageCurrent < 1) {
            pageCurrent = 1;
        }

        if (pageCurrent == 1) {
            out.println(first + " " + priv + " ");
        } else {//////////////////////
            out.println("<a href='" + linkURL + "page=1'>" + first + "</a> ");
            out.println("<a href='" + linkURL + "page=" + (pageCurrent - 1) +
                      "'>" + priv + "</a> ");
        }
        if (pageCurrent == pageNumber) {
            out.println(next + " " + last + " ");
        } else {//////////////////////
            out.println("<a href='" + linkURL + "page=" + (pageCurrent + 1) +
                      "'>" + next + "</a> ");
            out.println("<a href='" + linkURL + "page=" + pageNumber + "'>" +
                      last + "</a> ");
        }

        if (model.contains("message")) {
            out.print(di+pageCurrent+"/"+pageNumber+ye);
        }

        if (model.contains("list")) {
            out.println("<script language=\"javascript\" content=\"text/html\">");
            out.println("<!--");
            out.println("function processPageNumList(){");////////////////
            out.println("window.location.href=\""+linkURL+"page=\"+pageNumList.options[pageNumList.selectedIndex].value;");
            out.println("}");
            out.println("//-->");
            out.println("</script>");
            out.println("<select name=\"pageNumList\" onchange=\"processPageNumList();\">");
            for(int i=1;i<=pageNumber;i++){
                out.print("<option value=\""+i+"\"");
                if(i==pageCurrent){
                    out.print(" selected");
                }
                out.print(">"+di+i+ye+"</option>");
            }
            out.println("</select>");
        }

        if (model.contains("go")) {
            out.println("<input type=\"text\" name=\"pageNumGo\" size=\"2\" value=\""+pageCurrent+"\" onfocus=\"this.select()\" onkeypress=\"return processKeyPageNumberGo();\" /><input type=\"button\" onclick=\"processPageNumberGo();\" value=\"GO\" />");
            out.println("<script language=\"javascript\" content=\"text/html\">");
            out.println("<!--");
            out.println("function processKeyPageNumberGo(){");
            out.println("   if(window.event.keyCode=='\\r'.charCodeAt(0)){");
            out.println("      processPageNumberGo();");
            out.println("   }");
            out.println("   if(window.event.keyCode>='0'.charCodeAt(0) && window.event.keyCode<='9'.charCodeAt(0)){");
            out.println("      return true;");
            out.println("   }");
            out.println("   return false;");
            out.println("}");
            out.println("function processPageNumberGo(){");
            out.println("   var pageNumber="+pageNumber+";");
            out.println("   if(! isNaN(pageNumGo.value)){");
            out.println("      if(parseInt(pageNumGo.value)<1){");
            out.println("         pageNumGo.value='1';");
            out.println("      }");
            out.println("      if(parseInt(pageNumGo.value)>pageNumber){");
            out.println("         pageNumGo.value=pageNumber;");
            out.println("      }");
            out.println("   }else{");
            out.println("      pageNumGo.value='1';");
            out.println("   }");////////////////////
            out.println("   window.location.href=\""+linkURL+"page=\"+pageNumGo.value;");
            out.println("}");
            out.println("pageNumGo.focus();");
            out.println("//-->");
            out.println("</script>");
        }
    }
}
