package cn.com.his.core.solr;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.AnalysisParams;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Test;

import cn.com.his.core.vo.solr.RegistertypeSolr;
import cn.com.test.getField.TesEmployee;

public class SolrCrud {
	
	
	/**
	 * 查询索引    不进行set("");搜索       只进行set("q","a:b","c:d")  
	 * @throws Exception 
	 */
	
	@Test
	public void testName() throws Exception {
		getDocment("的", "registertypeCore", true, 1, 10);
	}
	
	public static List<RegistertypeSolr>  getDocment(String keys,String core,Boolean isHighlighting,Integer page,Integer rows) {
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		 SolrQuery solrQuery= new SolrQuery("*:*"); // 构造搜索条件
		 solrQuery.setStart((Math.max(page, 1) - 1) * rows);
         solrQuery.setRows(rows);
		
         if(isHighlighting){setHighlight(solrQuery);}
         
		 System.out.println("ke:"+keys);
		 //进行分词
		 String splitWords = null;
		 QueryResponse solrResults =null;
		try {
			if(keys!=""||!keys.isEmpty()){
				System.out.println("8888888888888");
				splitWords = splitWords(solr,keys);
				System.out.println("splitWords:"+splitWords);
				solrQuery.set("q","typename:"+splitWords,"note:"+splitWords);
			}
			solrResults = solr.query(solrQuery);
			
		} catch (Exception e) {
			System.out.println("solrCrud:"+e.getMessage());
		}
		
		 List<RegistertypeSolr> registertypes=solrResults.getBeans(RegistertypeSolr.class);
		 for (RegistertypeSolr registertype : registertypes) {
				System.out.println(registertype);
			}
		 
		 
		if(isHighlighting){setHighlightToObject(solrResults,registertypes);}
		 
		 for (RegistertypeSolr registertype : registertypes) {
				System.out.println(registertype);
			}
		 
		return registertypes;
	}
	
	//设置高亮
	public static void setHighlight(SolrQuery solrQuery) {
		// 设置高亮
        solrQuery.setHighlight(true); // 开启高亮组件
        solrQuery.addHighlightField("id");
        solrQuery.addHighlightField("typecode");
        solrQuery.addHighlightField("typename");
        solrQuery.addHighlightField("typesum");
        solrQuery.addHighlightField("note");
        solrQuery.addHighlightField("isvalid");
        solrQuery.setHighlightSimplePre("<span style='color:red;'>");// 标记，高亮关键字前缀
        solrQuery.setHighlightSimplePost("</span>");// 后缀
		
	}
	
	//高亮进入实体
	
	public static void setHighlightToObject( QueryResponse solrResults , List<RegistertypeSolr> registertypes){
		// 将高亮的标题数据写回到数据对象中
        Map<String, Map<String, List<String>>> map = solrResults.getHighlighting();
        for (Map.Entry<String, Map<String, List<String>>> hightDatas : map.entrySet()) {
            for (RegistertypeSolr em : registertypes) {
                if (!hightDatas.getKey().equals(em.getId().toString())) {
                	continue;
                }
                
                if(hightDatas.getValue().get("typecode") != null){
                   em.setTypecode(hightDatas.getValue().get("typecode")+"");  
                }
                
                if(hightDatas.getValue().get("typename") != null){
                    em.setTypename(hightDatas.getValue().get("typename")+"");
                }
                
                if(hightDatas.getValue().get("typesum") != null){
//                    em.setTypesume(hightDatas);
                	
                }
                
                if(hightDatas.getValue().get("note") != null){
                    em.setNote(hightDatas.getValue().get("note")+"");
                }
                
                if(hightDatas.getValue().get("id") != null){
                  System.out.println("cn.com.his.core.solr.SolrCrud:id:"+hightDatas.getValue().get("id"));
//                     em.setId(hightDatas.getValue().get("id")+"");
                }
               //下面全是if
                break;
            }
        }
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 增加索引    实体
	 * @param obj
	 * @param core
	 */
	public static void addSolrByBean(Object obj,String core){
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		try {
			solr.addBean(obj);
			SolrUtil.commitAndCloseSolr(solr);
		} catch (IOException | SolrServerException  e) {
			System.out.println("addSolrByBean:"+e.getMessage()+e.getClass());
			
		}
		
	}
	
	
	/**
	 * 增加索引 通过Doc
	 */
	public static void addSolrByDoc(){
		 SolrInputDocument inputDocument = new SolrInputDocument();
	}
	
	/**
	 * 删除所有索引
	 * @throws Exception
	 */
	public  static void deleteAllSolr(String core)  {
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		try {
			solr.deleteByQuery("*");
			SolrUtil.commitAndCloseSolr(solr);
		} catch (IOException | SolrServerException  e) {
			System.out.println("addSolrByBean:"+e.getMessage()+e.getClass());
			
		}
		
	}
	 
	
	
	/**
	 * 按照id 删除单个
	 * @throws Exception
	 */
	public  static void deleteSolrById(Integer  id,String core){
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		try {
			solr.deleteById(""+id);//也可以是集合ids
			SolrUtil.commitAndCloseSolr(solr);
		} catch (IOException | SolrServerException  e) {
			System.out.println("addSolrByBean:"+e.getMessage()+e.getClass());
			
		}
		
	}
	
	
	/**
	 * 按照id 删除多个索引
	 * @throws Exception
	 */
	public  static void deleteSolrByIds(Integer[]  ids,String core){
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		try {
			solr.deleteById(ids.toString());
			SolrUtil.commitAndCloseSolr(solr);
		} catch (IOException | SolrServerException  e) {
			System.out.println("addSolrByBean:"+e.getMessage()+e.getClass());
			
		}
		
	}
	
	/**
	 * 修改  没做好
	 * @param ids
	 * @param core
	 */
	
	public static  void udpateSolr(String core,RegistertypeSolr registertype){
		HttpSolrClient solr=	SolrUtil.getSolrClient(core);
		try {
			 SolrInputDocument inputDocument = new SolrInputDocument();
	         //向文档中添加域以及对应的值,注意：所有的域必须在schema.xml中定义过,前面已经给出过我定义的域。
	    	 //修改id为1的商品的信息（如果该商品不存在其实就是添加了）
	         inputDocument.addField("id", "1");
	         inputDocument.addField("username", "sansung爆炸牌手机999999999999999787897987");
	         //3.将文档写入索引库中
	         solr.add(inputDocument);
	         SolrUtil.commitAndCloseSolr(solr);
		} catch (IOException | SolrServerException  e) {
			System.out.println("addSolrByBean:"+e.getMessage()+e.getClass());
			
		}
		
	}
	
	
	
	
	

	//分词器
    public static String splitWords(HttpSolrClient solrClient,String keywords) throws Exception{
        SolrQuery query = new SolrQuery();

        query.add(CommonParams.QT, "/analysis/field"); // query type

        query.add(AnalysisParams.FIELD_VALUE, keywords);

        query.add(AnalysisParams.FIELD_TYPE, "text_ik");
        QueryResponse response=solrClient.query(query);

        NamedList<Object> analysis =  (NamedList<Object>) response.getResponse().get("analysis");// analysis node

        NamedList<Object> field_types =  (NamedList<Object>) analysis.get("field_types");// field_types node

        NamedList<Object> text_ik =  (NamedList<Object>) field_types.get("text_ik");// text_chinese node

        NamedList<Object> index =  (NamedList<Object>) text_ik.get("index");// index node

        List<SimpleOrderedMap<String>> list =  (ArrayList<SimpleOrderedMap<String>>) index.get("org.wltea.analyzer.lucene.IKTokenizer");// tokenizer node

        String nextQuery="";
        for(Iterator<SimpleOrderedMap<String>> iter = list.iterator(); iter.hasNext();)

        {
            nextQuery += iter.next().get("text") + "  ";
        }
        return nextQuery.trim();
    }

}
