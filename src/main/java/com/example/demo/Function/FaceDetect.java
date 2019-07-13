package com.example.demo.Function;

import com.example.demo.tool.Base64Util;
import com.example.demo.tool.FileUtil;
import com.example.demo.tool.GsonUtils;
import com.example.demo.tool.HttpUtil;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;
@Service
public class FaceDetect {


    public static String detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            //图片转换为BASE64
            byte[] bytes1 = FileUtil.readFileByBytes("F:\\face\\src\\main\\resources\\static\\juffer1.jpg");
            String image1 = Base64Util.encode(bytes1);

            Map<String, Object> map = new HashMap<>();
            map.put("image",image1);
            map.put("image_type", "BASE64");
            map.put("face_field", "face_shape,face_type,glasses");

            String param = GsonUtils.toJson(map);

            // access_token有过期时间，过期后重新获取。
            String accessToken = "24.2600c600f215f38fff158fa163aa1aa7.2592000.1565574904.282335-16778468";
            String result = HttpUtil.post(url, accessToken, "application/json", param);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect.detect();
    }
}
