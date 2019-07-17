package com.example.demo.Function;
import com.example.demo.tool.Base64Util;
import com.example.demo.tool.FileUtil;
import com.example.demo.tool.GsonUtils;
import com.example.demo.tool.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FaceAdd {


    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            byte[] bytes1 = FileUtil.readFileByBytes("F:\\face\\src\\main\\resources\\static\\Liao.jpg");
            String image1 = Base64Util.encode(bytes1);

            Map<String, Object> map = new HashMap<>();
            map.put("image", image1);
            map.put("image_type", "BASE64");
            map.put("group_id", "group_repeat");
            map.put("user_id", "Yandong");
            map.put("user_info", "wwww");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            String accessToken = "24.2600c600f215f38fff158fa163aa1aa7.2592000.1565574904.282335-16778468";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceAdd.add();
    }
}