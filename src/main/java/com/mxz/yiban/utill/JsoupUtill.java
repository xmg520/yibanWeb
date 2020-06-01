package com.mxz.yiban.utill;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

public class JsoupUtill{

    private static Map<String, String> cookies = null;

    public static void main(String[] args) throws IOException {
        // 先模拟登录获取到cookie和sessionid并存到全局变量cookies中
//        String username = "201765110117";
//        String city = "湖南省";
//        System.out.println(login(username,city));
    }

    /**
     * 模拟获取最后登陆时间信息模块
     */
    public static boolean isUpload(String username) throws IOException{

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

        String is_url = "http://yiqing.hnevc.com/syt/zzapply/queryxssqlist.htm?type=yqsjsb&xmid=000000007044850701704491248b007c";
        Connection connect1 = Jsoup.connect(is_url);

        // 伪造请求头
        connect1.cookies(cookies);
        connect1.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect1.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        connect1.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect1.header("Host", "yiqing.hnevc.com").header("Referer", "http://yiqing.hnevc.com/user/index.htm");
        connect1.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        connect1.data("pageIndex","0")
                .data("pageSize","20")
                .data("sortField","")
                .data("sortOrder","");
        // 请求url获取响应信息
        Response res1 = connect1.ignoreContentType(true).method(Method.POST).execute();// 执行请求
        JSONObject jsonObject = JSONObject.parseObject(res1.body());
        JSONArray up_time = jsonObject.getJSONArray("data");

        String end_time = up_time.getJSONObject(0).getString("sqsj");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());

        if (format.equals(end_time)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 模拟登录获取cookie和sessionid
     */
    public static String login(String username,String city) throws IOException {

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
        return toUpload(city);
    }

    /**
     * 模拟提交信息模块
     */
    public static String toUpload(String city) throws IOException {
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
        return res.body();
    }

}
