package cn.com.his.web.controller;

import java.util.List;
import java.util.Random;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 
import cn.com.his.core.utils.DateUtil;
import cn.com.his.core.vo.Dispensing;
import cn.com.his.core.vo.Register;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.service.service.DispensingService;
import cn.com.his.service.service.RegisterService;
import cn.com.his.core.vto.EmployeeVo;
import cn.com.his.core.vto.RegisterVo;

@Controller
@RequestMapping("/registerController")
public class RegisterController extends ABaseController{
	
	@Autowired
	private RegisterService registerService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DispensingService dispensingService;
	
	/**
	 * 分页查询挂号信息
	 * @param pagesize
	 * @param currentpage
	 * @return
	 */
	@RequestMapping("/registerlist")
	public String registerlist(Integer pagesize, Integer currentpage){
		//获取总行数
		int sumrow = registerService.pageFindToday(0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<RegisterVo> list = registerService.pageFindToday(pagingVo.getCurrentpage(),pagesize);
		request().setAttribute("registers", list);
		return "/registermanage/table/registertable";
	}
	
	/**
	 * 挂号
	 * @param bo
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Register bo){
		EmployeeVo employee = (EmployeeVo) request().getSession().getAttribute("pfuserinfo");
		//挂号单号
		bo.setRegistercode("GHD" + new Random().nextInt(99999999));
		bo.setRegistertime(DateUtil.timestamp());
		bo.setRegisterstatus(1);
		bo.setIsvalid(1);		
		bo.setRegisterpersonid(employee.getId());
		
		registerService.add(bo);
		request().setAttribute("resulttext", "addrgt");
		return "forward:/patientController/list.do";
	}
	
	/**
	 * 作废挂号单
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		int i = registerService.delete(id);
		Dispensing dispensing = dispensingService.findByRegisterId(id);
		if(dispensing != null){
			dispensingService.delete(dispensing.getId());
		}
		String msg = i > 0 ? "作废成功" : "作废失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
	
	/**
	 * 挂号历史记录页面
	 * @return
	 */
	@RequestMapping("/tohistory")
	public String tohistory(){
		// 查询角色为挂号员的挂号人员
		request().setAttribute("persons", employeeService.findRegisterP());
		return "/registermanage/registerhistory_list";
	}
	
	/**
	 * 模糊查询挂号历史记录
	 * @param bo
	 * @param pagesize
	 * @param currentpage
	 * @return
	 */
	@RequestMapping("/historydatalist")
	public String historydatalist(RegisterVo bo,Integer pagesize, Integer currentpage){
		//获取总行数
		int sumrow = registerService.manyConditionsFindhistory(bo, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<RegisterVo> list = registerService.manyConditionsFindhistory(bo,pagingVo.getCurrentpage(),pagesize);
		request().setAttribute("registers", list);
		return "/registermanage/table/registerhistorytable";
	}
}
