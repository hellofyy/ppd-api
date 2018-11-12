package com.springcloud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class VideoController {

    @RequestMapping(value = "getVideo",method = RequestMethod.GET)
    @ResponseBody
    public void getVideo(HttpServletResponse response) {


        try {
            InputStream is =  VideoController.class.getResourceAsStream("/video/12 佩奇与乔治的花园.mkv");
            byte [] video = new byte[1000];
            int n;
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            while((n=is.read(video))!=-1){

                bos.write(video,0,n);

            }
            is.close();
            bos.close();
            response.setContentType("video/mpeg4");
            OutputStream os = response.getOutputStream();
            os.write(bos.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
