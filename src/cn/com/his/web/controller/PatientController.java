package cn.com.his.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 
import cn.com.his.core.vo.Patient;
import cn.com.his.service.service.AttributedetailService;
import cn.com.his.service.service.DepartmentService;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.service.service.PatienttypeService;
import cn.com.his.service.service.RegistertypeService;
import cn.com.his.service.service.ViptypeService;
import cn.com.his.service.service.PatientService;
import cn.com.his.service.service.RegisterService;
import cn.com.his.core.vto.EmployeeVo;
import cn.com.his.core.vto.PatientVo;

@Controller
@RequestMapping("/patientController")
public class PatientController extends ABaseController{
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private AttributedetailService attributedetailService;
	@Autowired
	private PatienttypeService patienttypeService;
	@Autowired
	private ViptypeService viptypeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegistertypeService registertypeService;
	
	/**
	 * 挂号页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		System.out.println("6666666666666666666 ");
		// 查询前三个挂号类别  正常就诊  。。。
		request().setAttribute("registertypes", registertypeService.findBefor());
		// 查询最后一个挂号信息
		request().setAttribute("register", registerService.findLast());
		//统计挂号人数与金额
		request().setAttribute("countinfo", registerService.countInfo());
		//查询全部
		request().setAttribute("patienttypes", patienttypeService.findAll());
		// 查询会员类别
		request().setAttribute("viptypes", viptypeService.findAll());
		//婚姻
		request().setAttribute("politicsstatuss", attributedetailService.findByAttributeid(3));
		//医保
		request().setAttribute("insuretypes", attributedetailService.findByAttributeid(20));
		//查询是否允许挂号
		request().setAttribute("departments", departmentService.findIsRgs());
		// 查询角色为门诊医生的可挂号科室的医生
		request().setAttribute("doctors", employeeService.findIsRegister());
		
		return "/registermanage/register";
	}
	


	
	/**
	 * 模糊查询病人信息
	 * @param contant
	 * @return
	 */
	@RequestMapping("/patienttablelist")
	public String patienttablelist(String contant){
		PatientVo bo = new PatientVo();
		bo.setPatientname(contant);
		bo.setCardcode(contant);
		List<PatientVo> list = patientService.vagueFind(bo);
		request().setAttribute("patients", list);
		return "/registermanage/table/patienttable";
	}
	
	/**
	 * 添加病人
	 * @param bo
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Patient bo){
		bo.setCardcode(new Random().nextInt(99999999)+"");
		patientService.add(bo);
		request().setAttribute("resulttext", "addpt");
		return list();
	}
	
	/**
	 * 根据科室id查询医生
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/findemp",produces="application/json")
	public Object findemp(int id) throws IOException{		
		List<EmployeeVo> employees = employeeService.findByDepartmentId(id);
		return JSONSerializer.toJSON(employees);
	}
}
