package cn.com.his.web.controller;


import java.util.List;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.his.core.utils.ChineseToEnglish;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.core.vto.EmployeeVo;

@Controller
@RequestMapping("/passController")
public class PassController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 获取拼音码
	 * @param zhname
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getpinyin", produces="application/json")
	public Object getpinyin(String zhname){
		String pinyincode = ChineseToEnglish.getPinYinHeadChar(zhname);
		return JSONSerializer.toJSON("{'pinyincode':'"+ pinyincode +"'}");
	}
	
	/**
	 * 获取分页界面
	 * @return
	 */
	@RequestMapping("/getpaging")
	public String getPaging (){
		return "/common/paging";
	}
	
	/**
	 * 根据科室id查询医生
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getdoctorbydptid",produces="application/json")
	public Object dataselect(int id){
		List<EmployeeVo> list = employeeService.findByDepartmentId(id);
		return list;
	}
}
