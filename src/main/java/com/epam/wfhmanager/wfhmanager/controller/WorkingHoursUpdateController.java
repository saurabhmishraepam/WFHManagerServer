package com.epam.wfhmanager.wfhmanager.controller;

import com.epam.wfhmanager.wfhmanager.model.ChromeAggrData;
import com.epam.wfhmanager.wfhmanager.model.ChromeData;
import com.epam.wfhmanager.wfhmanager.store.ChromeDataStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WorkingHoursUpdateController {

    @PostMapping("/workinghour")
    public void updateWorkingHours(@RequestBody Map<String, Long > meetingsHoursMap){
        WorkingHoursStore.workingHoursMap=meetingsHoursMap;
    }
    @GetMapping("/workinghour")
    public Map<String, Long > updateWorkingHours(){
        return WorkingHoursStore.workingHoursMap;
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
        String[] data=new String [ChromeDataStore.chromeHistory.size()];
        ChromeDataStore.chromeHistory.keySet().toArray(data);
        Integer[] count = new Integer[ChromeDataStore.chromeHistory.size()];
        ChromeDataStore.chromeHistory.values().toArray(count);
        chromeData.setSiteNames(data);
        chromeData.setCount(count);

        return chromeData;

    }

    @PostMapping("/connectionlist")
    public void connectionUpdater(@RequestBody Map<String, Integer> connections){
        ConnectionsStore.connectionStrength=connections;
    }
    @GetMapping("/connectionlist")
    public Map<String, Integer > connectionUpdater(){
        return ConnectionsStore.connectionStrength;
    }
    @PostMapping("/newconnections")
    public void connectionUpdater(@RequestBody Set<String> newConnections){
        ConnectionsStore.newConnections=newConnections;
    }
    @GetMapping("/newconnections")
    public Set<String> newConnectionUpdater(){
        return ConnectionsStore.newConnections;
    }

}
