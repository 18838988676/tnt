package cn.com.his.other.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import cn.com.his.core.vo.Employee;
import cn.com.his.core.vo.Role;
import cn.com.his.core.vto.EmployeeVo;
import cn.com.his.core.vto.ResourceVo;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.service.service.ResourceService;
import cn.com.his.service.service.RoleService;


public class MyReale extends AuthorizingRealm{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 认证
	 */
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String employeecode = (String) token.getPrincipal();
		  String psw = new String((char[])token.getCredentials());  
		Employee e=new Employee();
		e.setEmployeecode(employeecode);
		e.setPsw(psw);
		EmployeeVo vo = employeeService.login(e);
		if (vo == null) {
			return null;
		}
		
		Role role = roleService.findByEpId(vo.getId());
		if(role != null){
			vo.setMenulist(resourceService.findFByPids(role.getResourceid()));
			vo.setResources(resourceService.findByPids(role.getResourceid()));
	
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(vo,e.getPsw(),this.getName());
			return info;
		}
		return null;
	}
	
	
	/**
	 * 授权
	 */
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		EmployeeVo vo=(EmployeeVo) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<ResourceVo> res=vo.getResources();
		for (ResourceVo resourceVo : res) {
			/*if(StringUtils.isNotEmpty(resourceVo.getR)){
				
			}*/
		}
		/*TUser user = (TUser) principals.getPrimaryPrincipal();
		 // （目录+菜单+按钮）
        List<TPermission> permissionList = user.getRsrootandFirstButtonsList();
		
        for (TPermission permission : permissionList) {
        	if (StringUtil.isNotEmpty(permission.getCode())) {
        		info.addStringPermission(permission.getCode());
        	}
        }
        
        if(user.getUserName().equals("2")){
        	info.addStringPermission("tomain");
        }
        
		return info;*/
		return null;
	}

}
