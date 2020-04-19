package com.epam.wfhmanager.wfhmanager.controller;

import com.epam.wfhmanager.wfhmanager.ChromeData;
import com.epam.wfhmanager.wfhmanager.store.ChromeDataStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkingHoursUpdateController {

    @PostMapping("/workinghour")
    public void updateWorkingHours(@RequestBody String body){

        if(body.contains("chromedata")){

        }
        System.out.println(body);

    }

    @PostMapping("/chrome-history")
    public void updateChromeData(@RequestBody Map<String, Integer> map){
        System.out.println(map);
        //data
        ChromeDataStore.map=map;
    }
    @GetMapping("/chrome-history")
    public ChromeData getChromeHistory(){
        ChromeData chromeData = new ChromeData();
        String[] data=new String [ChromeDataStore.map.size()];
        ChromeDataStore.map.keySet().toArray(data);
        Integer[] count = new Integer[ChromeDataStore.map.size()];
        ChromeDataStore.map.values().toArray(count);
        chromeData.setSiteNames(data);
        chromeData.setCount(count);

        return chromeData;

    }
}
