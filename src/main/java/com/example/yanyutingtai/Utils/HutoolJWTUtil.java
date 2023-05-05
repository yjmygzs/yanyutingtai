package com.example.yanyutingtai.Utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.example.yanyutingtai.domain.AdminUser;
import com.example.yanyutingtai.domain.User;

import java.util.HashMap;
import java.util.Map;

public class HutoolJWTUtil {
    public static String createToken(AdminUser adminUser){
        DateTime now = DateTime.now();
        DateTime newTime = now.offsetNew(DateField.MINUTE,120);
        Map<String,Object> payload = new HashMap<String,Object>();
        //签发时间
        payload.put(JWTPayload.ISSUED_AT,now);
        //过期时间
        payload.put(JWTPayload.EXPIRES_AT,newTime);
        //生效时间
        payload.put(JWTPayload.NOT_BEFORE,now);
        //载荷
        payload.put("username",adminUser.getUsername());
        payload.put("aid", adminUser.getId());
        String key = "yanyutingtai";
        String token = JWTUtil.createToken(payload, key.getBytes());
        return token;
    }
}
