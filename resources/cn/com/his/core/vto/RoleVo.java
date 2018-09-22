package cn.com.his.core.vto;

import java.io.Serializable;

import cn.com.his.core.vo.Role;

public class RoleVo extends Role implements Serializable{
	/**
	 * id和r组合而成，用于生成树
	 */
	private String rid;
	/**
	 * 父级rid，用于生成树
	 */
	private String frid;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getFrid() {
		return frid;
	}

	public void setFrid(String frid) {
		this.frid = frid;
	}
}
