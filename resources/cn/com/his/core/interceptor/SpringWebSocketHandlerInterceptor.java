package cn.com.his.core.interceptor;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import cn.com.his.core.vto.EmployeeVo;

/**
 * WebSocket拦截器
 * @author WANG
 *
 */

/**
*@function：实现获取上传的参数，然后设置到socke 的session中
*@parameter: WebSocket拦截器
*@return：该对象作为页面连接websocket服务的拦截器,代码如下
*@date：2016-9-10 上午11:15:03
*@author:Administrator
*@notice:
*/
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
    	
    	/*if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			// 标记用户
			String uid = servletRequest.getServletRequest().getParameter("uid");
			if (uid != null) {
				attributes.put("uid", uid);
			} else {
				return false;
			}
		}*/
    	
    	
    	System.out.println("握手前面");    	
        System.out.println("WebSocket拦截器 ：前拦截器");
        if (request instanceof ServletServerHttpRequest) {
        	
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            EmployeeVo  pfuserinfo= (EmployeeVo) servletRequest.getServletRequest().getSession().getAttribute("pfuserinfo");
             if (pfuserinfo != null) {
            	 System.out.println(pfuserinfo+"----"+pfuserinfo);
					attributes.put("pfuserinfo", pfuserinfo);
				} else {
					return false;
				}
             
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
        
    }
    
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
    	System.out.println("握手后");
        // TODO Auto-generated method stub
    	 System.out.println("WebSocket拦截器 ：后拦截器");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}