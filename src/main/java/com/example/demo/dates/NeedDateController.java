package com.example.demo.dates;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>用于演示时间序列化和反序列化的 Controller</h1>
 * */
@RestController
@RequestMapping("/need/date")
public class NeedDateController {

    @PostMapping("/user")
    public Map<String, String> postData(@RequestBody UserInfo userInfo) {

        Map<String, String> result = new HashMap<>();

        result.put("id", userInfo.getId().toString());
        result.put("name", userInfo.getName());
        result.put("birthday", String.valueOf(userInfo.getBirthday().getTime()));

        return result;
    }
}
