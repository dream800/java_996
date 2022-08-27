package com.dream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-26
 */
@Slf4j
@RestController
public class PachongController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("test1")
    public void test1()
    {

//        HttpHeaders headers = new HttpHeaders();
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("Connection", "keep-alive");
//        hashMap.put("Pragma", "no-cache");
//        hashMap.put("Cache-Control", "no-cache");
//        hashMap.put("Accept", "application/json, text/javascript, */*; q=0.01");
//        hashMap.put("Accept-Encoding", "gzip, deflate, br");
//        hashMap.put("X-Requested-With", "XMLHttpRequest");
//        hashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36");
//        hashMap.put("Content-Type", "application/json; charset=UTF-8");
//        hashMap.put("Origin", "http://www.haeea.cn");
//        hashMap.put("Referer", "http://www.haeea.cn/HEAODataCenter/PagePZQuery/ShowPZLQTJ.aspx");
//        hashMap.put("Accept-Language", "zh-CN,zh;q=0.9");
//        hashMap.put("Cookie", "Hm_lvt_fc4af2ab30ea321f1f7e8bffb9378f35=1656251411; Hm_lpvt_fc4af2ab30ea321f1f7e8bffb9378f35=1656252643");
////        headers.setContentType(MediaType.APPLICATION_JSON);
//        ArrayList<String> listCookie = new ArrayList<>();
//        hashMap.forEach((K , V) ->{
////            listCookie.add(K+"="+V);
//            headers.add(K, V);
//        });
//        log.info("cookies : {} ", listCookie.toString());

//
//        log.info("headers : {}" , headers);

//        List<String> cookieList = Arrays.stream(objects)
//                    .map(obj -> obj.getName() + "=" + obj.getValue())
//                    .collect(Collectors.toList());
//            headers.put(HttpHeaders.COOKIE, cookieList);

//        headers.put(HttpHeaders.COOKIE, listCookie);
//
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//        map.add("l_T", "2");
//        map.add("l_Y", "2021");
//        map.add("l_K", "理科");
//        map.add("l_P", "本科第二批");
//        map.add("l_QT", "");
//        map.add("l_PI", 1);
//        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<String> entity = restTemplate.postForEntity("http://www.haeea.cn/HEAODataCenter/PagePZQuery/ShowPZLQTJ.aspx/QueryInfo", request, String.class);
////        ResponseEntity<String> entity = restTemplate.postForEntity("http://120.77.207.10/index.php", request, String.class);
//
//        System.out.println(entity.getStatusCode());
//        System.out.println(entity.getBody());



    }

}
