package com.mxz.yiban;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import com.alibaba.fastjson.JSONObject;

public class JsoupTest {

    private static Map<String, String> cookies = null;

    public static void main(String[] args) throws IOException {
        // 先模拟登录获取到cookie和sessionid并存到全局变量cookies中
        String username = "201765110117";
        String city = "湖南省";
        login(username,city);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);
//        String city = "湖南省";
//        String text = "{\"xmqkb\":{\"id\":\"000000007044850701704491248b007c\"},\"c1\":\""+city+"\",\"c2\":\"正常\",\"c3\":\"36-36.9°C\",\"c4\":\"否\",\"c6\":\"否\",\"c7\":\"否\",\"c8\":\"否\",\"c9\":\"否\",\"c10\":\"否\",\"c12\":\"良好\",\"c13\":\"否\",\"c14\":\"否\",\"c15\":\"否\",\"type\":\"YQSJSB\"}";
//        JSONObject jsontext = JSONObject.parseObject(text);
//        System.out.println(jsontext);
    }

    /**
     * 模拟登录获取cookie和sessionid
     */
    public static void login(String username,String city) throws IOException {

        String urlLogin = "http://yiqing.hnevc.com/login/Login.htm";

        Connection connect = Jsoup.connect(urlLogin);
        // 伪造请求头
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connect.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect.header("Host", "yiqing.hnevc.com").header("Referer", "http://yiqing.hnevc.com/user/index.htm");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        connect.data("username", username).data("password", "123456").data("verification", "");

        // 请求url获取响应信息
        Response res = connect.ignoreContentType(true).method(Method.POST).execute();// 执行请求

        // 获取返回的cookie
        cookies = res.cookies();
//        String text = isUpload(username);
//        System.out.println(text);
        toUpload(city);

    }


    /**
     * 模拟提交信息模块
     */
    public static void toUpload(String city) throws IOException {
        String up_url = "http://yiqing.hnevc.com/syt/zzapply/operation.htm";

        //建立连接
//        Document document = Jsoup.connect(up_url).cookies(cookies).get();
        Connection connect = Jsoup.connect(up_url);

        // 伪造请求头
        connect.cookies(cookies);
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connect.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect.header("Host", "yiqing.hnevc.com").header("Referer", "http://yiqing.hnevc.com/user/index.htm");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        connect.data("data", "{\"xmqkb\":{\"id\":\"000000007044850701704491248b007c\"},\"c1\":\""+city+"\",\"c2\":\"正常\",\"c3\":\"36-36.9°C\",\"c4\":\"否\",\"c6\":\"否\",\"c7\":\"否\",\"c8\":\"否\",\"c9\":\"否\",\"c10\":\"否\",\"c12\":\"良好\",\"c13\":\"否\",\"c14\":\"否\",\"c15\":\"否\",\"type\":\"YQSJSB\"}")
                .data("msgUrl", "syt/zzapply/list.htm?type=YQSJSB&xmid=000000007044850701704491248b007c")
                .data("uploadFileStr", "{}");


        // 请求url获取响应信息
        Response res = connect.ignoreContentType(true).method(Method.POST).execute();// 执行请求
        System.out.println(res.body());
    }


    /**
     * 模拟获取最后登陆时间信息模块
     */
    public static String isUpload(String args) throws IOException{
        String is_url = "http://yiqing.hnevc.com/syt/zzapply/queryxssqlist.htm?type=yqsjsb&xmid=000000007044850701704491248b007c";
        Connection connect = Jsoup.connect(is_url);

        // 伪造请求头
        connect.cookies(cookies);
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connect.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect.header("Host", "yiqing.hnevc.com").header("Referer", "http://yiqing.hnevc.com/user/index.htm");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        connect.data("pageIndex","0")
                .data("pageSize","20")
                .data("sortField","")
                .data("sortOrder","");
        // 请求url获取响应信息
        Response res = connect.ignoreContentType(true).method(Method.POST).execute();// 执行请求
        JSONObject jsonObject = JSONObject.parseObject(res.body());
        JSONArray up_time = jsonObject.getJSONArray("data");

        String end_time = up_time.getJSONObject(0).getString("sqsj");
        return end_time;
    }
}
