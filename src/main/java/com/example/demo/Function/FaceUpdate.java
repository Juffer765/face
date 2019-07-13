package com.example.demo.Function;
import com.example.demo.tool.Base64Util;
import com.example.demo.tool.FileUtil;
import com.example.demo.tool.GsonUtils;
import com.example.demo.tool.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FaceUpdate {


    public static String update() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/update";
        try {


            Map<String, Object> map = new HashMap<>();
            map.put("image", "027d8308a2ec665acb1bdf63e513bcb9");
            map.put("image_type", "FACE_TOKEN");
            map.put("group_id", "group_repeat");
            map.put("user_id", "user1");
            map.put("user_info", "cba");
            map.put("liveness_control", "NORMAL");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.2600c600f215f38fff158fa163aa1aa7.2592000.1565574904.282335-16778468";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceUpdate.update();
    }
}