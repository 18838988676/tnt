package cn.com.his.core.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrUtil {
	 public static String SOLR_URL = "http://localhost:8080/solr/";
	//获取solr服务
	 public static HttpSolrClient getSolrClient(String core) {
	        return new HttpSolrClient(SOLR_URL + core);
	    }
	 
	 //提交并关闭
	 public static void commitAndCloseSolr(HttpSolrClient solrClient)
	          {
	        try {
				solrClient.commit();
				solrClient.close();
			} catch (SolrServerException | IOException e) {
				e.printStackTrace();
			}
	       
	    }
	 
	 
	 
	 
	 
	 
	 

}
