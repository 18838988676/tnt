package cn.com.his.dao.baseDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import cn.com.his.core.interceptor.SpringWebSocketHandlerInterceptor;


/**
 * WebScoket配置处理器
 * @author he
 * @Date 2016年03月15日 下午1:15:09
 */

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebsocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		/*registry.addHandler(myHandler(), "/websocketsocketServer.do").addInterceptors(new MyHandShake());
		registry.addHandler(myHandler(), "/sockjssocketServer.do").addInterceptors(new MyHandShake()).withSockJS();*/
		/*1*/
		System.out.println("服务器运行后 首先注册webscoket控制器，和拦截器");
		registry.addHandler(myHandler(), "/websocketsocketServer.do").addInterceptors(new SpringWebSocketHandlerInterceptor());
		  
		registry.addHandler(myHandler(), "/sockjssocketServer.do").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
	} 
	 
	@Bean
    public WebsocketHandler myHandler() {
        return new WebsocketHandler();
    }

}
