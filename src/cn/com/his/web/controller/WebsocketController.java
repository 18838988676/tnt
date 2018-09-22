package cn.com.his.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import cn.com.his.dao.baseDao.WebsocketHandler;

import cn.com.his.core.vo.AWhoOnline;
import cn.com.his.core.vto.EmployeeVo;



@Controller
public class WebsocketController {
	public WebsocketController() {
		System.out.println("初始化webCor");
	}
	
    @Bean//这个注解会从Spring容器拿出Bean
    public WebsocketHandler infoHandler() {
        return new WebsocketHandler();
    }

    @RequestMapping("/websocket/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        System.out.println("用户："+username+"正在登录,userid="+userid);
        request.getSession().setAttribute("uuid", userid);
        request.getSession().setAttribute("username", username);
        return "websocket.jsp";
    }

    
    
   //指定发送
    @RequestMapping("/websocket/send")
   @ResponseBody
    public String send(HttpServletRequest request,String sessionid,String content) {
    	System.err.println(sessionid+"=="+content);
        infoHandler().sendMessageToUser(sessionid, content);
        return null;
    }
    
    
    //消息群发
    @RequestMapping("/websocket/sendtoall")
    @ResponseBody
     public String sendtoall(HttpServletRequest request,String content,String sessionid) {
         infoHandler().sendMessageToUsers(new TextMessage("全体人员信息："+content));
         return null;
     }
    
    //当前谁在线
    @RequestMapping("/websocket/allwho")
    public String allwho(HttpServletRequest request) {
    	List<AWhoOnline> whos=new ArrayList<AWhoOnline>();
   	ConcurrentHashMap<WebSocketSession, EmployeeVo> a=  infoHandler().getWhoOnline();
   	
   	for (Entry<WebSocketSession, EmployeeVo> entry : a.entrySet()) {
   	whos.add(new AWhoOnline(entry.getValue().getEmployeename(), entry.getValue().getJobtitlename(),
   			entry.getValue().getDepartmentname(), 			entry.getKey().getId()));
	}
   	request.getSession().setAttribute("whos", whos);
        return "/who/wholine";
    }
    
    //下线操作
    @RequestMapping("/websocket/makedown")
    public String makeDown(HttpServletRequest request) {
    	String sessionId=  request.getParameter("sessionId");
    	String msg=infoHandler().makeDown(sessionId);
    	System.out.println(msg);
        return "forward:/websocket/allwho.do";
    }
    
    
    
    
    
   /* @RequestMapping("/websocket/allwho")
     public String allwho(HttpServletRequest request) {
    	ConcurrentHashMap<WebSocketSession, EmployeeVo> a=  infoHandler().getWhoOnline();
    		
    	System.out.println("==============================");
    			for (Enumeration<WebSocketSession> e = a.keys(); e.hasMoreElements();){
    			       System.out.println(e.nextElement());
    			}
    			System.out.println("==============================");
    	Collection<EmployeeVo>s=a.values();
    	request.getSession().setAttribute("whos", s);
    	
         return "/who/wholine";
     }*/
}