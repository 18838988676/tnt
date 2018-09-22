package cn.com.his.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
import cn.com.his.core.vo.Attributedetail;
import cn.com.his.core.vo.Useunit;
import cn.com.his.service.service.AttributedetailService;
import cn.com.his.service.service.UseunitService;

@Controller
@RequestMapping("/useunitController")
public class UseunitController extends ABaseController{
	
	@Autowired
	private UseunitService useunitService;
	@Autowired
	private AttributedetailService attributedetailService;
	
	/**
	 * 使用单位页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		List<Attributedetail> list = attributedetailService.findByAttributeid(9);
		request().setAttribute("banks", list);
		Useunit vo = useunitService.findOne();
		request().setAttribute("useunit", vo);
		return "/system/useunit/useunit";
	}
	
	/**
	 * 编辑保存使用单位
	 * @param vo
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Useunit vo){
		if(vo.getId() == null){
			useunitService.add(vo);
		}else{
			useunitService.edit(vo);
		}
		request().setAttribute("resulttext","save");
		return list();
	}
}
