/*package cn.com.his.other.controller;
package cn.com.his.other.controller;

import net.sf.json.JSONSerializer;

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
	
	*//**
	 * 初始化页面
	 * @return
	 *//*
	@RequestMapping("/toinitial")
	public String toinitial(){
		return "/user/initial";
	}
	
	*//**
	 * 判断是否已登录，若登录则为主页面，否则为登录页面
	 * @return
	 *//*
	@RequestMapping("/tologin")
	public String tologin(){
		Object obj = request().getSession().getAttribute("pfuserinfo");
		if(obj != null){
			return "/user/index";
		}
		request().getSession().invalidate();
		return "/user/login";
	}
	
	*//**
	 * 验证用户名是否存在
	 * @param username
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value="/verify", produces="application/json")
	public Object verify(String employeecode){
		Employee vo = employeeService.findByEpCode(employeecode);
		if(vo != null){
			System.out.println(JSONSerializer.toJSON("{'valid':true}")+"**");
			return JSONSerializer.toJSON("{'valid':true}");
		}
		return JSONSerializer.toJSON("{'valid':false}");
	}
	
	*//**
	 * 登录
	 * @param bo
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value="/login", produces="application/json")
	public Object login(Employee bo){		
		String msg = "";
		//bo.setPsw(MD5Util.GetMD5Code32(bo.getPsw()));
		bo.setPsw(bo.getPsw());
		EmployeeVo vo = employeeService.login(bo);
		if(vo != null){
			Role role = roleService.findByEpId(vo.getId());
			if(role != null){
				vo.setMenulist(resourceService.findFByPids(role.getResourceid()));
				vo.setResources(resourceService.findByPids(role.getResourceid()));
				request().getSession().setAttribute("pfuserinfo", vo);
				msg = "1";
			}else{
				msg = "您没有该系统权限，请联系管理员！";
			}
		}else{
			msg = "密码错误，请重新输入！";
		}
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
	*//**
	 * 到主页面
	 * @return
	 *//*
	@RequestMapping("/toindex")
	public String toindex(){
		String link = tologin();
		return link;
	}
	
	*//**
	 * 退出
	 * @return
	 *//*
	@RequestMapping("/loginout")
	public String loginout(){
		request().getSession().invalidate();
		return "/user/login";
	}
}
*/