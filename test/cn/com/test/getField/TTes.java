package cn.com.test.getField;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.AnalysisParams;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Test;

import com.sun.javafx.geom.Edge;

public class TTes {
	  public static String SOLR_URL = "http://localhost:8080/solr";
	 public static HttpSolrClient getSolrClient(String core) {
	        HttpSolrClient hsc = new HttpSolrClient(SOLR_URL + core);
	        return hsc;
	    }
	
	
	 
	 
	 
	 
	 	//根据查询删除
	 	@Test
		public void testqueryDelete() throws Exception {
	    	HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
	    					//key : value
	    	System.out.println( solrClient.deleteByQuery("EMidcard:456"));
	         solrClient.commit();
		}
	    
	 
	 //修改
	 @Test
	public void tesudpage() throws Exception {
		 HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
    	 SolrInputDocument inputDocument = new SolrInputDocument();
         //向文档中添加域以及对应的值,注意：所有的域必须在schema.xml中定义过,前面已经给出过我定义的域。
    	 //修改id为1的商品的信息（如果该商品不存在其实就是添加了）
         inputDocument.addField("id", "1");
         inputDocument.addField("username", "sansung爆炸牌手机999999999999999787897987");
         //3.将文档写入索引库中
         solrClient.add(inputDocument);
         solrClient.commit();
		 
	}
	 
	 
	 
	 
	 
	 //删除所有索引
	 @Test
	public void testallDelete() throws Exception {
		 HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
	        solrClient.deleteByQuery("*");
	        solrClient.commit();
			  solrClient.close();
	}
	 
	 
	 //删除指定索引
	 @Test
	public void testDelete() throws Exception {
		 HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
	        solrClient.deleteById("12345");//也可以是集合ids
	        solrClient.commit();
			  solrClient.close();
	}
	 
	 
	 
	 
	 
	 
	 
	 //添加索引   二次添加就覆盖
	 @Test
	public void testadd() throws Exception {
		   HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
		   TesEmployee tesEmployee=new TesEmployee();
//		   tesEmployee.setEMaddress("0dffasdjfaklsdj断开理发店");
//		   tesEmployee.setEMwubicode("96321asdfasdfasdf");
		   //必须插入id
		   tesEmployee.setId(12345);
		   solrClient.addBean(tesEmployee);
		   solrClient.commit();
		   solrClient.close();
		 
		 
		 
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	//查询查询查询索引
	@Test
	public void test1() throws Exception {

        HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
        int page = 1;
        int rows = 50;
        SolrQuery solrQuery = new SolrQuery("*:*"); // 构造搜索条件
        	//  solrQuery.setQuery("EMemployeecode:" + "*2*"); // 也可以 搜索关键词  不加
//            solrQuery.setQuery("EMemployeecode:" + "2"); // 搜索关键词  不加
            String splitWords = splitWords(solrClient,"的我他中有我我中有他");
            System.out.println("这是分词"+splitWords);
            
            //只有这样的才能高亮 solrQuery.set("q", ""); 类似模糊搜索  只能写一个set("q")
            solrQuery.set("q", "EMwubicode:"+splitWords,"EMpinyincode:"+splitWords);
            
            solrQuery.setStart((Math.max(page, 1) - 1) * rows);
            solrQuery.setRows(rows);
          
            //回显哪个字段
            //solrQuery.setFields("EMemployeecode","EMwubicode");
            
            if (true) {
                // 设置高亮
                solrQuery.setHighlight(true); // 开启高亮组件
                solrQuery.addHighlightField("EMwubicode");// 高亮字段
                solrQuery.addHighlightField("EMpinyincode");
                solrQuery.setHighlightSimplePre("<span style='color:red;'>");// 标记，高亮关键字前缀
                solrQuery.setHighlightSimplePost("</span>");// 后缀
            }
            
            QueryResponse solrResults = solrClient.query(solrQuery);
          
           /*  SolrDocumentList docs=	solrResults.getResults();
            System.out.println(docs); 
            System.out.println(docs.get(0));
            System.out.println(docs.get(1));
            System.out.println(docs.get(0).get("EMnote")); */
         
            List<TesEmployee> employees = solrResults.getBeans(TesEmployee.class);
            for (TesEmployee tesEmployee : employees) {
//				System.out.println(tesEmployee);
			}
            
            //将高亮带进java对象中
            if (true) {
            // 将高亮的标题数据写回到数据对象中
            Map<String, Map<String, List<String>>> map = solrResults.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (TesEmployee em : employees) {
                    if (!highlighting.getKey().equals(em.getId().toString())) {
                    	continue;
                    }
                    
                    if(highlighting.getValue().get("EMwubicode") != null){
                    	System.out.println(highlighting.getValue().get("EMwubicode")+"****************" );
                       em.setEMwubicode(highlighting.getValue().get("EMwubicode")+"");  
                    }
                    
                    if(highlighting.getValue().get("EMpinyincode") != null){
                    	System.out.println(highlighting.getValue().get("EMpinyincode"));
                        em.setEMpinyincode(highlighting.getValue().get("EMpinyincode")+"");
                    }
                    
                    
                   //下面全是if

                    break;
                }
            }
        }
            System.out.println("**********************");
            for (TesEmployee tesEmployee : employees) {
				System.out.println(tesEmployee.getEMpinyincode()+"---------------"+tesEmployee.getEMwubicode());
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
