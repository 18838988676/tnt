package cn.com.his.dao.baseDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import cn.com.his.core.vto.EmployeeVo;

public class WebsocketHandler2 extends TextWebSocketHandler{
	private static final Boolean isOnline=true;
	public static ConcurrentHashMap<WebSocketSession, EmployeeVo> sessionsMaps;
	static {
		sessionsMaps = new ConcurrentHashMap<WebSocketSession, EmployeeVo>();
	}
    public WebsocketHandler2() {
    	//初始化
    }

    
    
    /**
     * 连接成功时候，会触发页面上onopen方法  上线提醒
     */
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	 EmployeeVo  pfuserinfo = (EmployeeVo) session.getHandshakeAttributes().get("pfuserinfo");
    	System.out.println(pfuserinfo+"===");
    	if (!(pfuserinfo == null)) {
    		
			if (sessionsMaps.get(session) == null) {
				sessionsMaps.put(session, pfuserinfo);
				//借用onopen方法
		    	session.sendMessage(new TextMessage("欢迎："+pfuserinfo.getEmployeename()));
				String name=pfuserinfo.getDepartmentname()+":"+pfuserinfo.getEmployeename()+"上线了";
				//给除了他的所有人发上线通知
				sendMessageToUsersByGetOnlies(new TextMessage(name),session);
			} else { 
				sessionsMaps.put(session, pfuserinfo);
		}
	}
    	
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
        //TextMessage returnMessage = new TextMessage("你将收到的离线");
        //session.sendMessage(returnMessage);
    }
    
    /**
     * 关闭连接时触发  下线通知
     */
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        EmployeeVo pfuserinfo=		sessionsMaps.get(session);
        String name=pfuserinfo.getDepartmentname()+":"+pfuserinfo.getEmployeename()+"下线了";
    	//给除了他的所有人发下线通知
        sendMessageToUsersByGetOnlies(new TextMessage(name),session);
        sessionsMaps.remove(session);
        System.out.println("用户"+name+"已退出！");
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override    
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        System.out.println(session);
        System.out.println(message);
        System.out.println("js调用websocket.send时候，会调用该方法");
        System.out.println("sendMessageToUsers");
        sendMessageToUsers(new TextMessage("zhe shi qun fa info "));
    }

    
   
    /**
     * 上下线提醒
     */
    public void sendMessageToUsersByGetOnlies(TextMessage message,WebSocketSession session) {
    	Set<WebSocketSession> wescokets=  sessionsMaps.keySet();
    	for (WebSocketSession ws : wescokets) {
			if(ws.isOpen()&&ws!=session){
				  try {
					  ws.sendMessage(message);
				} catch (IOException e) {
					System.out.println("给所有在线用户发送消息失败："+e.getMessage());
				}
			}
		}
    }
    
    
    
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
    	Set<WebSocketSession> wescokets=  sessionsMaps.keySet();
    	for (WebSocketSession ws : wescokets) {
			if(ws.isOpen()){
				  try {
					ws.sendMessage(message);
				} catch (IOException e) {
					System.out.println("给所有在线用户发送消息失败："+e.getMessage());
				}
			}
		}
    }
    
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
    	
      /*  for (WebSocketSession user : sessionsMaps) {
            if (user.getHandshakeAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        */
        
        
    	
    }
    
    
    
    
    
    
    
    //当前谁在线
    public ConcurrentHashMap<WebSocketSession, EmployeeVo> getWhoOnline(){
    	ConcurrentHashMap<WebSocketSession, EmployeeVo> whos =new ConcurrentHashMap<WebSocketSession, EmployeeVo>();
    	Set<WebSocketSession> wescokets=  sessionsMaps.keySet();
    	for (WebSocketSession ws : wescokets) {
			if(ws.isOpen()){
				whos.put(ws, sessionsMaps.get(ws));
			}
		}
    	return whos;
    }
    
    //强制下线
    public String makeDown(String sessionId){
    	Enumeration<WebSocketSession> aa=  sessionsMaps.keys();
    	while (aa.hasMoreElements()) {
			WebSocketSession session = (WebSocketSession) aa.nextElement();
			if(session.getId().endsWith(sessionId)){
				EmployeeVo employeeVo=sessionsMaps.get(session);
				if(session.isOpen()){
					try {
						String msg="强制下线通知！用户："+employeeVo.getEmployeename()+"被管理员强制下线了";
						 sendMessageToUsersByGetOnlies(new TextMessage(msg),session);
						 session.sendMessage(new TextMessage("对不起，您被强制下线"));
						session.close();
						sessionsMaps.remove(session);
					} catch (IOException e) {
						System.out.println("强制下线出错了，错误信息："+e.getMessage());
					}
					return  new String("强制下线了");
				}else {
					return  new String("已经自动下线了");
				}
			}
		}
    	return "";
    }
    
    
    
    
    

    @Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){session.close();}
//        users.remove(session);
    }

    @Override
	public boolean supportsPartialMessages() {
        return false;
    }
    
   
 }