package cn.com.his.web.controller;

import java.util.List;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 


import cn.com.his.core.solr.SolrCrud;
import cn.com.his.core.vo.Registertype;
import cn.com.his.core.vo.solr.RegistertypeSolr;
import cn.com.his.service.service.RegistertypeService;

@Controller
@RequestMapping("/registertypeController")
public class RegistertypeController extends ABaseController{
	
	@Autowired
	private RegistertypeService registertypeService;
	
	/**
	 * 挂号类别页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		return "/baseinfo/registertype/registertype_list";
	}
	
	
	//solr
	/**
	 * 分页模糊查询
	 * @param contant
	 * @param pagesize
	 * @param currentpage
	 * @return
	 */
	@RequestMapping("/datalist")
	public String datalist(String contant,int pagesize, int currentpage){
		System.out.println("11**************1"+contant+"1111111111111111111111");
		//获取总行数
		int sumrow = registertypeService.vagueFind(contant, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<RegistertypeSolr> list = registertypeService.vagueFind(contant, pagingVo.getCurrentpage(), pagesize);
		request().setAttribute("rgstypes", list);
		return "/baseinfo/registertype/table/registertypetable";
	}
	
	/**
	 * 新增挂号类别页面
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(){
		return "/baseinfo/registertype/registertype_add";
	}
	
	
	//solr   add
	/**
	 * 新增挂号类别
	 * @param vo                 
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Registertype vo){
		vo.setIsvalid(1);
		registertypeService.add(vo);
	SolrCrud.addSolrByBean(vo, "registertypeCore");
		request().setAttribute("resulttext", "add");
		return list();
	}
	
	/**
	 * 修改挂号类别页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(Integer id){
		Registertype vo = registertypeService.findById(id);
		request().setAttribute("rgstype", vo);
		
		return "/baseinfo/registertype/registertype_edit";
	}
	
	//solr
	/**
	 * 修改挂号类别
	 * @param vo
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Registertype vo){
		registertypeService.edit(vo);
		SolrCrud.addSolrByBean(vo, "registertypeCore");
		request().setAttribute("resulttext", "edit");
		return list();
	}
	
	//solr
	/**
	 * 删除挂号类别
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json")
	public Object delete(Integer id){
		SolrCrud.deleteSolrById(id, "registertypeCore");
		int i = registertypeService.delete(id);
		String msg = i > 0 ? "删除成功" : "删除失败";
		return JSONSerializer.toJSON("{'msg':'"+ msg +"'}");
	}
}
