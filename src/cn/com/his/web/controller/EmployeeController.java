package cn.com.his.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

 
import cn.com.his.core.utils.DateUtil;
import cn.com.his.core.utils.FileLoadUtil;
import cn.com.his.core.utils.MD5Util;
import cn.com.his.core.vo.Employee;
import cn.com.his.service.service.AttributedetailService;
import cn.com.his.service.service.DepartmentService;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.core.vto.EmployeeVo;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController extends ABaseController{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private AttributedetailService attributedetailService;
	
	/**
	 * 员工页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "/personnelmanage/employee/employee_list";
	}
	
	
	
	//进行模糊查询
	/**
	 * 模糊查询
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	@RequestMapping("/datalist")
	public String datalist(String contant,Integer currentpage, Integer pagesize){
		//获取总行数
		int sumrow = employeeService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<EmployeeVo> list = employeeService.vagueFind(contant,pagingVo.getCurrentpage(),pagesize);
		request().setAttribute("employees", list);
		return "/personnelmanage/employee/table/employeetable";
	}
	
	
	
	
	
	
	/**
	 * 添加员工页面
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(){
		request().setAttribute("departments", departmentService.findAll());
		request().setAttribute("maxeducations", attributedetailService.findByAttributeid(1));
		request().setAttribute("politicsstatuss", attributedetailService.findByAttributeid(2));
		request().setAttribute("positions", attributedetailService.findByAttributeid(4));
		request().setAttribute("jobtitles", attributedetailService.findByAttributeid(5));
		request().setAttribute("majors", attributedetailService.findByAttributeid(10));
		return "/personnelmanage/employee/employee_add";
	}
	
	/**
	 * 添加员工
	 * @param bo
	 * @param myfile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/add")
	public String add(Employee bo,@RequestParam(value="file",required=true)MultipartFile myfile) throws IOException{
		String picture = FileLoadUtil.file_load(myfile,request());
		if(picture != ""){
			bo.setPicture(picture);
		}else{
			/*bo.setPicture("http://localhost:8080/tnt/initial.jpg");*/
		}
		bo.setIsvalid(1);
//		bo.setPsw(MD5Util.GetMD5Code32("123"));
		bo.setPsw("1");
		employeeService.add(bo);
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	/**
	 * 自动装配格式化日期
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DateUtil());
	}
	
	/**
	 * 修改员工页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(int id){
		request().setAttribute("departments", departmentService.findAll());
		request().setAttribute("maxeducations", attributedetailService.findByAttributeid(1));
		request().setAttribute("politicsstatuss", attributedetailService.findByAttributeid(2));
		request().setAttribute("positions", attributedetailService.findByAttributeid(4));
		request().setAttribute("jobtitles", attributedetailService.findByAttributeid(5));
		request().setAttribute("majors", attributedetailService.findByAttributeid(10));
		Employee bo = employeeService.findById(id);
		request().setAttribute("employee", bo);
		return "/personnelmanage/employee/employee_edit";
	}
	
	/**
	 * 修改员工
	 * @param bo
	 * @param myfile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/edit")
	public String edit(Employee bo,@RequestParam(value="file",required=true)MultipartFile myfile) throws IOException{		
		if(!myfile.isEmpty()){
			String picture = FileLoadUtil.file_load(myfile,request());
			bo.setPicture(picture);
		}
		employeeService.edit(bo);
		request().setAttribute("resulttext", "edit");
		return list();
	}
	
	/**
	 * 重置密码
	 * @param bo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/resetpsw",produces="application/json")
	public Object resetpsw(Employee bo){
		bo.setPsw(MD5Util.GetMD5Code32(bo.getPsw()));
		int i = employeeService.edit(bo);
		String msg = i > 0 ? "重置成功" : "重置失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = employeeService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
}
