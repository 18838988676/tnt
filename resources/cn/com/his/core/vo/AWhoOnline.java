package cn.com.his.core.vo;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;

public class AWhoOnline {
	 private String employeename;
	  private String jobtitlename;
		private String departmentname;
		private String sessionID;
		
		
		
		
		
		
		public String getSessionID() {
			return sessionID;
		}
		public void setSessionID(String sessionID) {
			this.sessionID = sessionID;
		}
		public String getEmployeename() {
			return employeename;
		}
		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}
		
		public String getJobtitlename() {
			return jobtitlename;
		}
		public void setJobtitlename(String jobtitlename) {
			this.jobtitlename = jobtitlename;
		}
		public String getDepartmentname() {
			return departmentname;
		}
		public void setDepartmentname(String departmentname) {
			this.departmentname = departmentname;
		}
		public AWhoOnline(String employeename,
				String jobtitlename, String departmentname, String sessionID) {
			super();
			this.employeename = employeename;
			this.jobtitlename = jobtitlename;
			this.departmentname = departmentname;
			this.sessionID = sessionID;
		}
	
		
		
		
		
		
		

}
