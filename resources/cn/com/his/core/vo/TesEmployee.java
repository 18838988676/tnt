package cn.com.his.core.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class TesEmployee  implements Serializable{
	
	@Field("id")
    private Integer id;
	@Field("EMemployeecode")
    private String EMemployeecode;
	@Field("EMemployeename")
    private String EMemployeename;
	@Field("EMpsw")
    private String EMpsw;
	@Field("EMpinyincode")
    private String EMpinyincode;
	@Field("EMwubicode")
    private String EMwubicode;

    private Integer EMjobtitleid;

    private Integer EMpositionid;

    private Integer EMsex;

    private String EMtel;

    private Integer EMdepartmentid;

    private String EMemail;

    private String EMidcard;

    private String EMaddress;

    private Date EMbirthday;

    private Date EMinductiontime;

    private Date EMdimissiontime;

    private Integer EMmaxeducationid;

    private Integer EMmajorid;

    private Integer EMpoliticsstatusid;

    private Integer EMisoperator;

    private Integer EMisdoctor;

    private Integer EMisnurse;

    private Integer EMworkstatus;

    private String EMpicture;

    private String EMnote;

    private Integer EMisvalid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEMemployeecode() {
		return EMemployeecode;
	}

	public void setEMemployeecode(String eMemployeecode) {
		EMemployeecode = eMemployeecode;
	}

	public String getEMemployeename() {
		return EMemployeename;
	}

	public void setEMemployeename(String eMemployeename) {
		EMemployeename = eMemployeename;
	}

	public String getEMpsw() {
		return EMpsw;
	}

	public void setEMpsw(String eMpsw) {
		EMpsw = eMpsw;
	}

	public String getEMpinyincode() {
		return EMpinyincode;
	}

	public void setEMpinyincode(String eMpinyincode) {
		EMpinyincode = eMpinyincode;
	}

	public String getEMwubicode() {
		return EMwubicode;
	}

	public void setEMwubicode(String eMwubicode) {
		EMwubicode = eMwubicode;
	}

	public Integer getEMjobtitleid() {
		return EMjobtitleid;
	}

	public void setEMjobtitleid(Integer eMjobtitleid) {
		EMjobtitleid = eMjobtitleid;
	}

	public Integer getEMpositionid() {
		return EMpositionid;
	}

	public void setEMpositionid(Integer eMpositionid) {
		EMpositionid = eMpositionid;
	}

	public Integer getEMsex() {
		return EMsex;
	}

	public void setEMsex(Integer eMsex) {
		EMsex = eMsex;
	}

	public String getEMtel() {
		return EMtel;
	}

	public void setEMtel(String eMtel) {
		EMtel = eMtel;
	}

	public Integer getEMdepartmentid() {
		return EMdepartmentid;
	}

	public void setEMdepartmentid(Integer eMdepartmentid) {
		EMdepartmentid = eMdepartmentid;
	}

	public String getEMemail() {
		return EMemail;
	}

	public void setEMemail(String eMemail) {
		EMemail = eMemail;
	}

	public String getEMidcard() {
		return EMidcard;
	}

	public void setEMidcard(String eMidcard) {
		EMidcard = eMidcard;
	}

	public String getEMaddress() {
		return EMaddress;
	}

	public void setEMaddress(String eMaddress) {
		EMaddress = eMaddress;
	}

	public Date getEMbirthday() {
		return EMbirthday;
	}

	public void setEMbirthday(Date eMbirthday) {
		EMbirthday = eMbirthday;
	}

	public Date getEMinductiontime() {
		return EMinductiontime;
	}

	public void setEMinductiontime(Date eMinductiontime) {
		EMinductiontime = eMinductiontime;
	}

	public Date getEMdimissiontime() {
		return EMdimissiontime;
	}

	public void setEMdimissiontime(Date eMdimissiontime) {
		EMdimissiontime = eMdimissiontime;
	}

	public Integer getEMmaxeducationid() {
		return EMmaxeducationid;
	}

	public void setEMmaxeducationid(Integer eMmaxeducationid) {
		EMmaxeducationid = eMmaxeducationid;
	}

	public Integer getEMmajorid() {
		return EMmajorid;
	}

	public void setEMmajorid(Integer eMmajorid) {
		EMmajorid = eMmajorid;
	}

	public Integer getEMpoliticsstatusid() {
		return EMpoliticsstatusid;
	}

	public void setEMpoliticsstatusid(Integer eMpoliticsstatusid) {
		EMpoliticsstatusid = eMpoliticsstatusid;
	}

	public Integer getEMisoperator() {
		return EMisoperator;
	}

	public void setEMisoperator(Integer eMisoperator) {
		EMisoperator = eMisoperator;
	}

	public Integer getEMisdoctor() {
		return EMisdoctor;
	}

	public void setEMisdoctor(Integer eMisdoctor) {
		EMisdoctor = eMisdoctor;
	}

	public Integer getEMisnurse() {
		return EMisnurse;
	}

	public void setEMisnurse(Integer eMisnurse) {
		EMisnurse = eMisnurse;
	}

	public Integer getEMworkstatus() {
		return EMworkstatus;
	}

	public void setEMworkstatus(Integer eMworkstatus) {
		EMworkstatus = eMworkstatus;
	}

	public String getEMpicture() {
		return EMpicture;
	}

	public void setEMpicture(String eMpicture) {
		EMpicture = eMpicture;
	}

	public String getEMnote() {
		return EMnote;
	}

	public void setEMnote(String eMnote) {
		EMnote = eMnote;
	}

	public Integer getEMisvalid() {
		return EMisvalid;
	}

	public void setEMisvalid(Integer eMisvalid) {
		EMisvalid = eMisvalid;
	}

	@Override
	public String toString() {
		return "TesEmployee [id=" + id + ", EMemployeecode=" + EMemployeecode
				+ ", EMemployeename=" + EMemployeename + ", EMpsw=" + EMpsw
				+ ", EMpinyincode=" + EMpinyincode + ", EMwubicode="
				+ EMwubicode + ", EMjobtitleid=" + EMjobtitleid
				+ ", EMpositionid=" + EMpositionid + ", EMsex=" + EMsex
				+ ", EMtel=" + EMtel + ", EMdepartmentid=" + EMdepartmentid
				+ ", EMemail=" + EMemail + ", EMidcard=" + EMidcard
				+ ", EMaddress=" + EMaddress + ", EMbirthday=" + EMbirthday
				+ ", EMinductiontime=" + EMinductiontime + ", EMdimissiontime="
				+ EMdimissiontime + ", EMmaxeducationid=" + EMmaxeducationid
				+ ", EMmajorid=" + EMmajorid + ", EMpoliticsstatusid="
				+ EMpoliticsstatusid + ", EMisoperator=" + EMisoperator
				+ ", EMisdoctor=" + EMisdoctor + ", EMisnurse=" + EMisnurse
				+ ", EMworkstatus=" + EMworkstatus + ", EMpicture=" + EMpicture
				+ ", EMnote=" + EMnote + ", EMisvalid=" + EMisvalid + "]";
	}
    

  
    
    
    
    
    
    
}