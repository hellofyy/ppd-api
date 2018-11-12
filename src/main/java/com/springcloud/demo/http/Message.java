package com.springcloud.demo.http;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Message {

    public static void sendMessage(){
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://utf8.api.smschinese.cn/");
            post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");//在头文件中设置转码
            System.out.println();
            String num = String.valueOf((int)((Math.random())*10000));
            NameValuePair[] data ={ new NameValuePair("Uid", "fangyanyang"),new NameValuePair("Key", "d41d8cd98f00b204e980"),
                    new NameValuePair("smsMob","13011125921"),new NameValuePair("smsText","您的验证码："+num)};
            post.setRequestBody(data);
            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:"+statusCode);
            for(Header h : headers)
            {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("utf8"));
            System.out.println(result); //打印返回消息状态

            post.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
