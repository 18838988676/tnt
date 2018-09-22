package cn.com.his.core.vo;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.solr.client.solrj.beans.Field;
import org.junit.Test;

public class Registertype {
	
	
	
	@Field("id")
	private  Integer id;
	@Field("typecode")
	private  String typecode;
	@Field("typename")
	private  String typename;
	@Field("typesum")
	private  BigDecimal typesum;
	@Field("note")
	private  String note;
	@Field("isvalid")
	private  Integer isvalid;

    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id==null?null:id;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public BigDecimal getTypesum() {
        return typesum;
    }

    public void setTypesum(BigDecimal typesum) {
        this.typesum = typesum==null?null:typesum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid==null?null:isvalid;
    }

	@Override
	public String toString() {
		return "Registertype [id=" + id + ", typecode=" + typecode
				+ ", typename=" + typename + ", typesum=" + typesum + ", note="
				+ note + ", isvalid=" + isvalid + "]";
	}
    
    
    
}