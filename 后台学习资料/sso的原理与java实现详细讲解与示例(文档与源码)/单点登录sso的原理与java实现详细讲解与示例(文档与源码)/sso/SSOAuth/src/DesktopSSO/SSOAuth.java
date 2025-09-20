package DesktopSSO;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSOAuth extends HttpServlet
{
  private static ConcurrentMap accounts;
  private static ConcurrentMap SSOIDs;
  String cookiename = "WangYuDesktopSSOID";
  String domainname;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    String action = request.getParameter("action");
    String gotoURL = request.getParameter("goto");
    String result = "failed";
    if (action == null) {
      handlerFromLogin(request, response);
    } else if (action.equals("authcookie")) {
      String myCookie = request.getParameter("cookiename");
      if (myCookie != null) result = authCookie(myCookie);
      out.print(result);
      out.close();
    } else if (action.equals("authuser")) {
      result = authNameAndPasswd(request, response);
      out.print(result);
      out.close();
    } else if (action.equals("logout")) {
      String myCookie = request.getParameter("cookiename");
      logout(myCookie);
      out.close();
    }
  }

  public static String authCookie(String value)
  {
    String result = (String)SSOIDs.get(value);
    if (result == null) {
      result = "failed";
      System.out.println("Authentication failed!");
    } else {
      System.out.println("Authentication success!");
    }
    return result;
  }

  public static String authUserAndPass(String username, String password)
  {
    String pass = (String)accounts.get(username);
    if ((pass == null) || (!pass.equals(password))) return "failed";
    String newID = createUID();
    SSOIDs.put(newID, username);
    return username;
  }

  protected String authNameAndPasswd(HttpServletRequest request, HttpServletResponse response)
  {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String pass = (String)accounts.get(username);
    if ((pass == null) || (!pass.equals(password))) return "failed";

    String newID = createUID();
    SSOIDs.put(newID, username);
    return newID;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    processRequest(request, response);
  }

  public String getServletInfo()
  {
    return "Short description";
  }

  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
    this.domainname = config.getInitParameter("domainname");
    this.cookiename = config.getInitParameter("cookiename");
    SSOIDs = new ConcurrentHashMap();
    accounts = new ConcurrentHashMap();
    accounts.put("wangyu", "wangyu");
    accounts.put("paul", "paul");
    accounts.put("carol", "carol");
  }

  private static String createUID() {
    Date now = new Date();
    long time = now.getTime();
    return "wangyu" + time;
  }
  /**
   * ע��
   * @param UID
   */
  private void logout(String UID) {
    System.out.println("Logout for " + UID);
    SSOIDs.remove(UID);
  }
  /**
   * ��֤�û��������룬Ȼ������ԭҳ��
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  private void handlerFromLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String pass = (String)accounts.get(username);
    if ((pass == null) || (!pass.equals(password))) {
      getServletContext().getRequestDispatcher("/failed.html").forward(request, response);
    } else {
      String gotoURL = request.getParameter("goto");
      String newID = createUID();
      SSOIDs.put(newID, username);
      
      this.add2Cookie(response, this.cookiename, newID, 60*1000);
      
      System.out.println("login success, goto back url:" + gotoURL);
      if (gotoURL != null) {
        PrintWriter out = response.getWriter();
        response.sendRedirect(gotoURL);
        out.close();
      }
    }
  }
  /**
   * �����cookie
   * @param response
   * @param cookieName
   * @param cookieValue
   * @param maxAge
   */
  private void add2Cookie(
			HttpServletResponse response, String cookieName,String cookieValue,int maxAge){
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setDomain(this.domainname);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge); // cookieһ������Ч60*60*24*365
		response.addCookie(cookie);
	}
}