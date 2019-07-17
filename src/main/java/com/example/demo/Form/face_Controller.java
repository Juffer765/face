package com.example.demo.Form;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Function.*;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class face_Controller {

    @RequestMapping("/")
    String test(){
        return "new";
    }

    @RequestMapping("login.html")
    String p(){
        return "login";
    }

    @Autowired
    private FaceDetect faceDetect;
    private FaceMatch faceMatch;
    private FaceSearch faceSearch;
    private FaceAdd faceAdd;


    @RequestMapping("/face_login")
    @ResponseBody
    public String faceLogin(HttpServletRequest request){

        //删除，BASE64格式的图片头
        String image=request.getParameter("action");
        String del="data:image/png;base64,";
        image=image.replace(del,"");
        JsonObject feedback=new JsonObject();
        String verify=face_function.faceVerify(image);
        if(verify.equals("pass")) {   //活体检测
                String detect = face_function.detect(image);   //多张人脸
                if (detect.equals("1")) {
                    String information = face_function.search(image);   //进行搜搜
                    if(!information.equals("Login Failure")) {
                        feedback.addProperty("result", "success");
                        feedback.addProperty("info", information);
                    }else{
                        feedback.addProperty("result", "error");
                        feedback.addProperty("info", information);
                    }
                    return feedback.toString();
                } else {
                    feedback.addProperty("result", "error");
                    feedback.addProperty("info", detect);
                    return feedback.toString();
                }
        }
        else {
            feedback.addProperty("result", "error");
            feedback.addProperty("info", verify);
            return feedback.toString();
        }
    }

    @RequestMapping("/face_register")
    @ResponseBody
    public String faceRegister(HttpServletRequest request){


        String data=request.getParameter("action");
        JSONObject json_data= JSON.parseObject(data);
        String image=json_data.getString("image");

        if(face_function.faceVerify(image).equals("pass")) {   //活体检测
                String detect=face_function.detect(image);
                if(detect.equals("1")){
                        String information =  face_function.add(image,json_data.getString("group_id"),json_data.getString("user_id"));
                        return JSON.toJSONString(information);
                } else {
                        return JSON.toJSONString(detect);
                }
        }
        else {
            return JSON.toJSONString(face_function.faceVerify(image));
        }
    }
}
