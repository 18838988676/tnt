package cn.com.test.getField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.AnalysisParams;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Test;


/**
 * Created by Tiger-Li on 2017/10/22.
 */
public class SolrUtilForbb {
    public static String SOLR_URL = "http://localhost:8080/solr";
    
  
    
    
    
    /**
     * 获取solr服务
     *
     * @return
     */
    public static HttpSolrClient getSolrClient(String core) {
        HttpSolrClient hsc = new HttpSolrClient(SOLR_URL + core);
        return hsc;
    }




    /**
     * 添加文档，通过bean方式
     *
     * @param user
     * @param core
     * @throws Exception
     */
 /*   public static void addDocumentByBean(User user, String core)
            throws Exception {
        HttpSolrClient solrClient = getSolrClient("/" + core);
        solrClient.addBean(user);
        commitAndCloseSolr(solrClient);
    }
    */
   

    /**
     * 添加文档，通过bean方式
     *
     * @param persons
     * @param core
     * @throws Exception
     */
/*    public static void addDocumentByBeans(List<User> persons, String core)
            throws Exception {
        HttpSolrClient solrClient = getSolrClient("/" + core);
        solrClient.addBeans(persons);
        commitAndCloseSolr(solrClient);
    }*/

    /**
     * 根据id删除索引
     *
     * @param userId
     * @param core
     * @throws Exception
     */
    public static void deleteDocumentById(String userId, String core)
            throws Exception {
        HttpSolrClient solrClient = getSolrClient("/" + core);
        solrClient.deleteById(userId);
        commitAndCloseSolr(solrClient);
    }

    /**
     * 根据id集合删除索引
     *
     * @param ids
     * @param core
     * @throws Exception
     */
    public static void deleteDocumentByIds(List<String> ids, String core)
            throws Exception {
        HttpSolrClient solrClient = getSolrClient("/" + core);
        solrClient.deleteById(ids);
        commitAndCloseSolr(solrClient);
    }

    /**
     * 查询方法
     * @param core
     * @param user
     * @param isHighlighting
     * @return
     * @throws Exception
     */
    
    

    @Test
    public void getDocument() throws Exception {
    	
        HttpSolrClient solrClient = getSolrClient("/" + "employeeCore");
        int page = 1;
        int rows = 110;
        
        SolrQuery solrQuery = new SolrQuery("*:*"); // 构造搜索条件
            solrQuery.setQuery("EMpositionid:" + "*2*"); // 搜索关键词
         //   solrQuery.set("q","pinyincode:"+"ZY");
           // solrQuery.setQuery("tel:" + "66"); // 搜索关键词
          //  solrQuery.setQuery("employeecode:" +"8"); // 搜索关键词
           /* solrQuery.setQuery("username:*"+user.getUsername()+"*");
            solrQuery.set("q","desc:"+user.getDesc());*/
           /* String splitWords = splitWords(solrClient,user.getDesc());
            System.out.println(splitWords);*/
            //这个很重要
          /*  solrQuery.setQuery("desc:*"+splitWords+"*");*/

        //分片信息
       /* solrQuery.setFacet(true).setFacetMinCount(1).setFacetLimit(5).addFacetField("desc");*/
        // 设置分页
      //  solrQuery.setStart((Math.max(page, 1) - 1) * rows);
       // solrQuery.setRows(rows);

      /*  // 是否需要高亮
        if (isHighlighting) {
            // 设置高亮
            solrQuery.setHighlight(true); // 开启高亮组件
            solrQuery.addHighlightField("username");// 高亮字段
            solrQuery.addHighlightField("id");
            solrQuery.addHighlightField("desc");
            solrQuery.addHighlightField("password");
            solrQuery.addHighlightField("age");
            solrQuery.setHighlightSimplePre("<span style='color:red;'>");// 标记，高亮关键字前缀
            solrQuery.setHighlightSimplePost("</span>");// 后缀
        }
*/
        QueryResponse queryResponse = solrClient.query(solrQuery);

      
        
        
       System.out.println(queryResponse);
      //  List<User> persons = queryResponse.getBeans(User.class);
       

       /* if (isHighlighting) {
            // 将高亮的标题数据写回到数据对象中
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (User person : persons) {
                    if (!highlighting.getKey().equals(person.getId().toString())) {
                    	continue;
                    }
                    if(highlighting.getValue().get("username") != null){
                        person.setUsername(highlighting.getValue().get("username")+"");
                    }
                    if(highlighting.getValue().get("id") != null){
                        person.setId(highlighting.getValue().get("id")+"");
                    }
                    if(highlighting.getValue().get("desc") != null){
                        person.setDesc(highlighting.getValue().get("desc")+"");
                    }
                    if(highlighting.getValue().get("age") != null){
                        person.setAge(highlighting.getValue().get("age")+"");
                    }
                    if(highlighting.getValue().get("password") != null){
                        person.setPassword(highlighting.getValue().get("password")+"");
                    }

                    break;
                }
            }
        }
        for (User user2 : persons) {
			System.out.println(user2);
		}*/
        
    }
    
    
    
    

    /**
     * 获取分词结果
     * @param solrClient
     * @param keywords
     * @return
     * @throws Exception
     */
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


    /**
     * 提交以及关闭服务
     *
     * @param solrClient
     * @throws Exception
     */
    public static void commitAndCloseSolr(HttpSolrClient solrClient)
            throws Exception {
        solrClient.commit();
        solrClient.close();
    }

    /**
     * <b>function:</b> query 基本用法测试
     */
//    public void queryCase() {
//        //AND 并且
//        SolrQuery params = new SolrQuery("name:apple AND manu:inc");
//
//        //OR 或者
//        params.setQuery("name:apple OR manu:apache");
//        //空格 等同于 OR
//        params.setQuery("name:server manu:dell");
//
//        //params.setQuery("name:solr - manu:inc");
//        //params.setQuery("name:server + manu:dell");
//
//        //查询name包含solr apple
//        params.setQuery("name:solr,apple");
//        //manu不包含inc
//        params.setQuery("name:solr,apple NOT manu:inc");
//
//        //50 <= price <= 200
//        params.setQuery("price:[50 TO 200]");
//        params.setQuery("popularity:[5 TO 6]");
//        //params.setQuery("price:[50 TO 200] - popularity:[5 TO 6]");
//        //params.setQuery("price:[50 TO 200] + popularity:[5 TO 6]");
//
//        //50 <= price <= 200 AND 5 <= popularity <= 6
//        params.setQuery("price:[50 TO 200] AND popularity:[5 TO 6]");
//        params.setQuery("price:[50 TO 200] OR popularity:[5 TO 6]");
//
//        //过滤器查询，可以提高性能 filter 类似多个条件组合，如and
//        //params.addFilterQuery("id:VA902B");
//        //params.addFilterQuery("price:[50 TO 200]");
//        //params.addFilterQuery("popularity:[* TO 5]");
//        //params.addFilterQuery("weight:*");
//        //0 < popularity < 6  没有等于
//        //params.addFilterQuery("popularity:{0 TO 6}");
//
//        //排序
//        params.addSortField("id", ORDER.asc);
//
//        //分页：start开始页，rows每页显示记录条数
//        //params.add("start", "0");
//        //params.add("rows", "200");
//        //params.setStart(0);
//        //params.setRows(200);
//
//        //设置高亮
//        params.setHighlight(true); // 开启高亮组件
//        params.addHighlightField("name");// 高亮字段
//        params.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
//        params.setHighlightSimplePost("</font>");//后缀
//        params.setHighlightSnippets(1);//结果分片数，默认为1
//        params.setHighlightFragsize(1000);//每个分片的最大长度，默认为100
//
//        //分片信息
//        params.setFacet(true)
//                .setFacetMinCount(1)
//                .setFacetLimit(5)//段
//                .addFacetField("name")//分片字段
//                .addFacetField("inStock");
//
//        //params.setQueryType("");
//
//        try {
//            QueryResponse response = server.query(params);
//
//        /*List<Index> indexs = response.getBeans(Index.class);
//        for (int i = 0; i < indexs.size(); i++) {
//            fail(indexs.get(i));
//        }*/
//
//            //输出查询结果集
//            SolrDocumentList list = response.getResults();
//            fail("query result nums: " + list.getNumFound());
//            for (int i = 0; i < list.size(); i++) {
//                fail(list.get(i));
//            }
//
//            //输出分片信息
//            List<FacetField> facets = response.getFacetFields();
//            for (FacetField facet : facets) {
//                fail(facet);
//                List<Count> facetCounts = facet.getValues();
//                for (FacetField.Count count : facetCounts) {
//                    System.out.println(count.getName() + ": " + count.getCount());
//                }
//            }
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        }
//    }


//    12、 分片查询、统计
//
///**
// * <b>function:</b> 分片查询， 可以统计关键字及出现的次数、或是做自动补全提示
// */
//
//    public void facetQueryCase() {
//        SolrQuery params = new SolrQuery("*:*");
//
//        //排序
//        params.addSortField("id", ORDER.asc);
//
//        params.setStart(0);
//        params.setRows(200);
//
//        //Facet为solr中的层次分类查询
//        //分片信息
//        params.setFacet(true)
//                .setQuery("*:*")
//                .setFacetMinCount(1)
//                .setFacetLimit(5)//段
//                        //.setFacetPrefix("electronics", "cat")
//                .setFacetPrefix("cor")//查询manu、name中关键字前缀是cor的
//                .addFacetField("manu")
//                .addFacetField("name");//分片字段
//
//        try {
//            QueryResponse response = server.query(params);
//
//            //输出查询结果集
//            SolrDocumentList list = response.getResults();
//            fail("Query result nums: " + list.getNumFound());
//
//            for (int i = 0; i < list.size(); i++) {
//                fail(list.get(i));
//            }
//
//            fail("All facet filed result: ");
//            //输出分片信息
//            List<FacetField> facets = response.getFacetFields();
//            for (FacetField facet : facets) {
//                fail(facet);
//                List<Count> facetCounts = facet.getValues();
//                for (FacetField.Count count : facetCounts) {
//                    //关键字 - 出现次数
//                    fail(count.getName() + ": " + count.getCount());
//                }
//            }
//
//            fail("Search facet [name] filed result: ");
//            //输出分片信息
//            FacetField facetField = response.getFacetField("name");
//            List<Count> facetFields = facetField.getValues();
//            for (Count count : facetFields) {
//                //关键字 - 出现次数
//                fail(count.getName() + ": " + count.getCount());
//            }
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        }
//    }













}
