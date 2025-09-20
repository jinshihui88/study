package hbjr1108.servletSeniorExams;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest1 implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session be created......");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session be destroyed......");
	}

}
