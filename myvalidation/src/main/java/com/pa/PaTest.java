package com.pa;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-26
 */
public class PaTest {

    public static void main(String[] args) throws Exception{

        getHttp();




    }


    /***
     * @Title: getHttp()
     * @Author: 汪满青
     * @Description: get请求,抓取CSDN首页
     * @Date: 2020/10/25-21:55
     * @Param: []
     * @return: void
     **/
    public static void getHttp() throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet请求
//        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        HttpPost httpPost = new HttpPost("http://www.haeea.cn/HEAODataCenter/PagePZQuery/ShowPZLQTJ.aspx/QueryInfo");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Pragma", "no-cache");
        httpPost.addHeader("Cache-Control", "no-cache");
        httpPost.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpPost.addHeader("Origin", "http://www.haeea.cn");
        httpPost.addHeader("Referer", "http://www.haeea.cn/HEAODataCenter/PagePZQuery/ShowPZLQTJ.aspx");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpPost.addHeader("Cookie", "Hm_lvt_fc4af2ab30ea321f1f7e8bffb9378f35=1656251411; Hm_lpvt_fc4af2ab30ea321f1f7e8bffb9378f35=1656252643");

        StringEntity s = new StringEntity("{\"l_T\":\"2\",\"l_Y\":\"2021\",\"l_K\":\"理科\",\"l_P\":\"本科第二批\",\"l_QT\":\"\",\"l_PI\":1}", "utf-8");

        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,  "application/json"));

        httpPost.setEntity(s);

         CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求
            response = httpClient.execute(httpPost);
            System.out.println(response.getEntity().toString());
            //判断响应状态码是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
//                //如果为200表示请求成功，获取返回数据
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                //打印数据长度
//                System.out.println(content);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            if (response == null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpClient.close();
            }
        }
    }


}
