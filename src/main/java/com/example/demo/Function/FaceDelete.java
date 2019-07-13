package com.example.demo.Function;
import com.example.demo.tool.GsonUtils;
import com.example.demo.tool.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FaceDelete {


    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
        try {
            Map<String, Object> map = new HashMap<>();

            map.put("group_id", "group_repeat");
            map.put("user_id", "user1");
            map.put("face_token","ziji");


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