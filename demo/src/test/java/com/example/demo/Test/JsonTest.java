package com.example.demo.Test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    @Test
    public void test1(){
        Map map  = new HashMap<>();
        map.put( "Data","[{\"agentcode\":\"M01A00\",\"agentname\":\"测试印度代理3\",\"sitecode\":\"M01A00009\",\"sitename\":\"" +
                        "新加坡售后\",\"regioncode\":\"91\",\"regionname\":\"India\",\"provincecode\":\"01\",\"provincename\":\"ROORKEE\",\"citycode\":\"0101\",\"cityname\":\"ROORKEE\",\"areacode\":\"\",\"areaname\":\"\",\"new_address\":\"" +
                        "新加坡售后\",\"new_phone\":\"1\",\"new_operatetype\":\"1\",\"new_istogether\":\"False\",\"business_time\":\"08：" +
                        "00-10：00\",\"rest_time\":\"\",\"resttime_code\":\"\",\"new_latitude\":\"0\",\"createdon\":\"8/21/2019 3:03:42 PM\",\"" +
                        "modifiedon\":\"9/25/2019 7:19:52 PM\",\"new_isenabled\":\"False\"}]"
                );

        String data = (String) map.get("Data");
        // User user = JSONObject.parseObject(data, User.class);

    }
}
