package cn.com.his.core.vto;

import java.io.Serializable;

import cn.com.his.core.vo.Prescriptiontemplatedetail;

public class PrescriptiontemplatedetailVo extends Prescriptiontemplatedetail implements Serializable{
	/**
	 * 药品编号
	 */
	private String drugcode;
	/**
	 * 药品名称
	 */
	private String drugname;
	/**
	 * 用药方式名称
	 */
	private String medicineformname;
	/**
	 * 用药频率名称
	 */
	private String medicinefrequencyname;
	
	public String getDrugcode() {
		return drugcode;
	}
	public void setDrugcode(String drugcode) {
		this.drugcode = drugcode;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getMedicineformname() {
		return medicineformname;
	}
	public void setMedicineformname(String medicineformname) {
		this.medicineformname = medicineformname;
	}
	public String getMedicinefrequencyname() {
		return medicinefrequencyname;
	}
	public void setMedicinefrequencyname(String medicinefrequencyname) {
		this.medicinefrequencyname = medicinefrequencyname;
	}	
}
