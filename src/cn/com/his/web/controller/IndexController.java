package cn.com.his.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONSerializer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.com.his.core.utils.MD5Util;
import cn.com.his.core.vo.Employee;
import cn.com.his.core.vo.Role;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.service.service.ResourceService;
import cn.com.his.service.service.RoleService;
import cn.com.his.core.vto.EmployeeVo;

@Controller
@RequestMapping("/indexController")
public class IndexController extends ABaseController{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 初始化页面
	 * @return
	 */
	@RequestMapping("/toinitial")
	public String toinitial(){
		return "/user/initial";
	}
	
	/**
	 * 判断是否已登录，若登录则为主页面，否则为登录页面
	 * @return
	 */
	@RequestMapping("/tologin")
	public String tologin(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		EmployeeVo vo = (EmployeeVo) subject.getPrincipal();
		if(vo != null){
			//访问后台的controller 的url 的后缀 都带.do 不带的话，就是去前台找页面呢
			request().getSession().setAttribute("pfuserinfo", vo);
			return "/user/index";
		}
		request().getSession().invalidate();
		return "/user/login";
	}
	
	
	//验证用户名是否存在
	@ResponseBody
	@RequestMapping(value="/verify", produces="application/json")
	public Object verify(String employeecode){
		Employee vo = employeeService.findByEpCode(employeecode);
		if(vo != null){
			return JSONSerializer.toJSON("{'valid':true}");
		}
		return JSONSerializer.toJSON("{'valid':false}");
	}
	
	
	//登录  
	@ResponseBody
	@RequestMapping(value="/login", produces="application/json")
	public Object login(Employee bo){
		String msg = "";
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(bo.getEmployeecode().trim(), bo.getPsw().trim());
		try {
			subject.login(token);
			msg = "1";
			
		}catch (UnknownAccountException e) {
			System.out.println("UnknownAccountException");
		//	return resu="404&用户不存在";
			
		}catch(IncorrectCredentialsException e) {
			msg = "密码错误，请重新输入！";
			System.out.println("IncorrectCredentialsException");
			
		}
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
	
	
	
	
	/**
	 * 到主页面
	 * @return
	 */
	@RequestMapping("/toindex")
	public String toindex(HttpServletRequest request){
		String link = tologin(request);
		return link;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/loginout")
	public String loginout(){
		request().getSession().invalidate();
		return "/user/login";
	}
}
