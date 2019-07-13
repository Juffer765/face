package com.example.demo.Form;

import com.baidu.aip.face.AipFace;
import com.example.demo.Function.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class face_Controller {

    @RequestMapping("/")
    String test(){
        return "index";
    }

    @RequestMapping("new.html")
    String camer(){return "new";}

    @Autowired
    private FaceDetect faceDetect;
    private FaceMatch faceMatch;
    private FaceSearch faceSearch;
    private FaceAdd faceAdd;

    @RequestMapping(value = "try",method = RequestMethod.POST)
    public String face(){
        //faceAdd.add();
        //faceSearch.search();
        return "index";
    }

}
