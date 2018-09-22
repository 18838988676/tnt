package cn.com.his.core.vto;

import java.io.Serializable;

import cn.com.his.core.vo.Resource;

public class ResourceVo extends Resource implements Serializable{
	/**
	 * 资源id的上级id
	 */
	private String resourcesuperior;

	public String getResourcesuperior() {
		return resourcesuperior;
	}

	public void setResourcesuperior(String resourcesuperior) {
		this.resourcesuperior = resourcesuperior;
	}
}
