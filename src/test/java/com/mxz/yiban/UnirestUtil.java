package com.mxz.yiban;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UnirestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnirestUtil.class.getName());

    /**
     *
     * @param url 目标url
     * @param name 参数名称
     * @param param 请求参数
     * @return 网络传输状态码或请求结果
     */
    public static HttpResponse sendGet(String url, String name, String param) throws UnirestException {
        LOGGER.debug("request url info : {}", url);
        HttpResponse<String> response = Unirest.get(url)
                .header("accept", "application/json;charset=UTF-8")
                .queryString(name, param)
                .asString();
        LOGGER.debug("response status info : {}", response.getStatus());
        LOGGER.debug("response status message info : {}", response.getStatusText());
        return response;
    }

    /**
     *
     * @param url 目标url
     * @param name 参数名称
     * @param param 请求参数实体
     * @return 网络传输状态码
     */
    public static HttpResponse sendPost(String url, String name, String param) throws UnirestException {
        LOGGER.debug("request url info : {}", url);
        HttpResponse<JsonNode> response = Unirest.post(url)
                .header("accept", "application/json;charset=UTF-8")
                .queryString(name, param)
                .asJson();
        LOGGER.debug("response status info : {}", response.getStatus());
        LOGGER.debug("response status message info : {}", response.getStatusText());
        return response;
    }


    //测试发送GET和POST请求
    public static void main(String[] args) throws Exception {
        //发送GET请求
//        HttpResponse s = sendGet("https://api.deeract.com/l2s/api/questions","keyword","李白");
//        System.out.println(s.getBody());
        //发送POST请求
        HttpResponse s1 = sendPost("http://v.juhe.cn/toutiao/index", "key","91b2919aa5d62749ff985440d97be051");
        System.out.println(s1.getBody());
    }

}
