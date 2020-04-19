package com.epam.wfhmanager.wfhmanager.controller;

import com.epam.wfhmanager.wfhmanager.model.ChromeAggrData;
import com.epam.wfhmanager.wfhmanager.model.ChromeData;
import com.epam.wfhmanager.wfhmanager.store.ChromeDataStore;
import org.springframework.web.bind.annotation.*;

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
        ChromeDataStore.chromeHistory=map;
    }

    @GetMapping("/chrome-history")
    public ChromeData getChromeHistory(){
        ChromeData chromeData = new ChromeData();
        String[] data=new String [ChromeDataStore.chromeHistory.size()];
        ChromeDataStore.chromeHistory.keySet().toArray(data);
        Integer[] count = new Integer[ChromeDataStore.chromeHistory.size()];
        ChromeDataStore.chromeHistory.values().toArray(count);
        chromeData.setSiteNames(data);
        chromeData.setCount(count);
        return chromeData;
    }

    @PostMapping("/chrome-aggr")
    public void updateChromeAggrData(@RequestBody Map<String, Integer> map){
        System.out.println(map);
        ChromeDataStore.chromeAggr = map;
    }

    @GetMapping("/chrome-aggr")
    public ChromeAggrData getChromeAggrData(){
        ChromeAggrData chromeData =  new ChromeAggrData();
        String[] type=new String [ChromeDataStore.chromeAggr.size()];
        ChromeDataStore.chromeAggr.keySet().toArray(type);
        Integer[] time = new Integer[ChromeDataStore.chromeAggr.size()];
        ChromeDataStore.chromeAggr.values().toArray(time);
        chromeData.setType(type);
        chromeData.setTime(time);
        return chromeData;
    }
}
