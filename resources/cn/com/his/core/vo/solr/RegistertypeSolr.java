package cn.com.his.core.vo.solr;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.solr.client.solrj.beans.Field;
import org.junit.Test;

public class RegistertypeSolr {
	
	
	
	@Field("id")
	public  String id;
	@Field("typecode")
	public  String typecode;
	@Field("typename")
	public  String typename;
	@Field("typesum")
	public  String typesum;
	@Field("note")
	public  String note;
	@Field("isvalid")
	public  String isvalid;

    

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTypecode() {
		return typecode;
	}



	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}



	public String getTypename() {
		return typename;
	}



	public void setTypename(String typename) {
		this.typename = typename;
	}



	public String getTypesum() {
		return typesum;
	}



	public void setTypesum(String typesum) {
		this.typesum = typesum;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public String getIsvalid() {
		return isvalid;
	}



	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}



	@Override
	public String toString() {
		return "Registertype [id=" + id + ", typecode=" + typecode
				+ ", typename=" + typename + ", typesum=" + typesum + ", note="
				+ note + ", isvalid=" + isvalid + "]";
	}
    
    
    
}