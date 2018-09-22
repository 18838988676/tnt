package cn.com.his.web.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.his.core.utils.DateUtil;
import cn.com.his.core.vo.Charge;
import cn.com.his.core.vo.Dispensing;
import cn.com.his.core.vo.Prescription;
import cn.com.his.core.vo.Register;
import cn.com.his.service.service.EmployeeService;
import cn.com.his.service.service.ChargeService;
import cn.com.his.service.service.DispensingService;
import cn.com.his.service.service.PrescriptionService;
import cn.com.his.service.service.RegisterService;
import cn.com.his.core.vto.ChargeVo;
import cn.com.his.core.vto.EmployeeVo;
import cn.com.his.core.vto.PrescriptionVo;

@Controller
@RequestMapping("/chargeController")
public class ChargeController extends ABaseController{
	
	@Autowired
	private PrescriptionService prescriptionService;
	@Autowired
	private ChargeService chargeService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DispensingService dispensingService;
	
	/**
	 * 收费页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(){
		request().setAttribute("lastcharge", chargeService.findLast());
		return "/chargemanage/charge";
	}
	
	/**
	 * 查询处方信息
	 * @param contant
	 * @return
	 */
	@RequestMapping("/prescripttablelist")
	public String prescripttablelist(String contant){
		List<PrescriptionVo> list = prescriptionService.vagueFind(contant);
		request().setAttribute("prescriptions", list);
		return "/chargemanage/table/prescriptiontable";
	}
	
	/**
	 * 收费状态为1时收费、否则退款
	 * @param charge
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Charge charge){
		String resulttext = "";
		EmployeeVo employee = (EmployeeVo) request().getSession().getAttribute("pfuserinfo");
		charge.setInvoicecode("FP" + new Random().nextInt(99999999));
		charge.setOperationpersonid(employee.getId());
		charge.setChargetime(DateUtil.timestamp());
		charge.setIsvalid(1);
		if(charge.getChargestatus() == 1){
			resulttext = "add";
		}else{
			resulttext = "edit";
		}
		int chargeid = chargeService.add(charge);
		Prescription vo = prescriptionService.findById(charge.getPrescriptionid());
		Register register = new Register();
		
		register.setId(vo.getRegisterid());
		register.setRegisterstatus(charge.getChargestatus() == 1 ? 4 : 7);
		if(register.getRegisterstatus() == 4){
			Dispensing dispensing = new Dispensing();
			dispensing.setChargeid(chargeid);
			dispensing.setDispensingstatus(1);
			dispensing.setIsvalid(1);
			dispensingService.add(dispensing);
		}
		registerService.updatestatus(register);
		request().setAttribute("resulttext", resulttext);
		return list();
	}
	
	
	
	
	/**
	 * 收费历史记录页面
	 * @return
	 */
	@RequestMapping("/tohistory")
	public String tohistory(){
		request().setAttribute("operations", employeeService.findChargeP());
		return "/chargemanage/chargehistory_list";
	}
	
	/**
	 * 分页查询
	 * @param bo
	 * @param pagesize
	 * @param currentpage
	 * @return
	 */
	@RequestMapping("/historydatalist")
	public String historydatalist(ChargeVo bo,Integer pagesize, Integer currentpage){
		//获取总行数
		int sumrow = chargeService.manyConditionsFindHistory(bo, 0, 99999999).size();
		//设置分页参数
		setPaging(pagesize, sumrow, currentpage);
		//获取分页后的数据
		List<ChargeVo> list = chargeService.manyConditionsFindHistory(bo,pagingVo.getCurrentpage(),pagesize);
		request().setAttribute("chargehistorys", list);
		return "/chargemanage/table/chargehistorytable";
	}
}
