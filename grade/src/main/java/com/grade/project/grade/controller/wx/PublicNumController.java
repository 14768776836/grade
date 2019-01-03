package com.grade.project.grade.controller.wx;

import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wxPpublicNum")
public class PublicNumController {

    @RequestMapping(value = "/getWxLoginOauth2URL")
    @ResponseBody
    public JSObject getWxLoginOauth2URL(){
        return null;
    }
}
