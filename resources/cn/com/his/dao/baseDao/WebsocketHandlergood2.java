package cn.com.his.dao.baseDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import cn.com.his.core.vto.EmployeeVo;

public class WebsocketHandlergood2 extends TextWebSocketHandler{
	private static final Boolean isOnline=true;
	public static ConcurrentHashMap<WebSocketSession, EmployeeVo> sessionsMaps;
	static {
		sessionsMaps = new ConcurrentHashMap<WebSocketSession, EmployeeVo>();
	}
    public WebsocketHandlergood2() {
    	//初始化
    }

    
    
    /**
     * 连接成功时候，会触发页面上onopen方法  上线提醒
     */

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
   	 EmployeeVo  pfuserinfo = (EmployeeVo) session.getHandshakeAttributes().get("pfuserinfo");
   	System.out.println("pfuserinfo:"+pfuserinfo+"\nsession:"+session);
   	
   	System.out.println("\n\n\n************************************************************************\n\n\n");
   	System.out.println(sessionsMaps.isEmpty()+"第一人");
   	//第一个人登录
   	if (sessionsMaps.isEmpty()) {
   				System.out.println("这是第一个人登录的");
   				System.out.println("1");
				sessionsMaps.put(session, pfuserinfo);
				//借用onopen方法
		    	session.sendMessage(new TextMessage("欢迎："+pfuserinfo.getEmployeename()));
				String name=pfuserinfo.getDepartmentname()+":"+pfuserinfo.getEmployeename()+"上线了";
				//给除了他的所有人发上线通知
				sendMessageToUsersByGetOnlies(new TextMessage(name),session);
   		}
   		else {
   			//第二个人登录
   			Collection<EmployeeVo> isss= sessionsMaps.values();
   			//循环得到value 的employeevo 的id的intvalue的值     与当前 pfuserinfo的id的intvalue的值相等时的 value值，根据气质 判断被等这session
   			for (EmployeeVo employeeVo : isss) {
   					//判断是否已经登录
   				System.out.println("//判断是否已经登录"); //--------------------------------else
   				if(employeeVo.getId().intValue()==pfuserinfo.getId().intValue()){
   					System.out.println("//此账号已被登录	");
   					//此账号已被登录	
   					Set<WebSocketSession> aa=  sessionsMaps.keySet();
   					//既然被登录  那value相同；因此根据value的id，查找被登录者的session
   		   			for (WebSocketSession webSocketSession : aa) {
   		   					if(sessionsMaps.get(webSocketSession).getId().intValue()==pfuserinfo.getId().intValue()){
   		   						
   		   					//就是这个session
   		   					//借用onopen方法
   		   					//第一个登录者下线
   		   					webSocketSession.sendMessage(new TextMessage("对不起 ： 您被异地登录了，请重新登录"));
   		   					//........
   		   					webSocketSession.close();
   							sessionsMaps.remove(webSocketSession);
   							
   							
   		   			    	//第二个登陆者登录
   							sessionsMaps.put(session, pfuserinfo);
   							//借用onopen方法
   					    	session.sendMessage(new TextMessage("欢迎："+pfuserinfo.getEmployeename()));
   							String name=pfuserinfo.getDepartmentname()+":"+pfuserinfo.getEmployeename()+"上线了";
   							//给除了他的所有人发上线通知
   							sendMessageToUsersByGetOnlies(new TextMessage(name),session);
   		   					}
   		   					break;
   		   				
   					}
				
   				}
   				//此账号现在没人登录
   				else {
					
   					sessionsMaps.put(session, pfuserinfo);
   					//借用onopen方法
   			    	session.sendMessage(new TextMessage("欢迎："+pfuserinfo.getEmployeename()));
   					String name=pfuserinfo.getDepartmentname()+":"+pfuserinfo.getEmployeename()+"上线了";
   					//给除了他的所有人发上线通知
   					sendMessageToUsersByGetOnlies(new TextMessage(name),session);
   					
				}
   				
			}
   			
   		}   	System.out.println("\n\n\n************************************************************************\n\n\n");
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
    public void sendMessageToUser(String sessionid,String message) {
    	System.out.println("1sessionid:"+sessionid+"--message:"+message);
    	Set<Entry<WebSocketSession, EmployeeVo>> ss=sessionsMaps.entrySet();
    	for (Entry<WebSocketSession, EmployeeVo> entry : ss) {
    			System.out.println("2"+entry.getKey().getId()+"---");
    		System.out.println("3"+entry.getKey().getId().endsWith(sessionid)+" ===");
    		if(entry.getKey().getId().endsWith(sessionid)){
    			try {
    				System.out.println("4");
					entry.getKey().sendMessage(new TextMessage(message));
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		System.out.println("5");
    		
		}
    	
    	
        
        
    	
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