package com.epam.wfhmanager.wfhmanager.controller;

import com.epam.wfhmanager.wfhmanager.model.ChromeAggrData;
import com.epam.wfhmanager.wfhmanager.model.ChromeData;
import com.epam.wfhmanager.wfhmanager.model.ProcessData;
import com.epam.wfhmanager.wfhmanager.store.ChromeDataStore;
import com.epam.wfhmanager.wfhmanager.store.ConnectionsStore;
import com.epam.wfhmanager.wfhmanager.store.ProcessDataStore;
import com.epam.wfhmanager.wfhmanager.store.WorkingHoursStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Map;
import java.util.Set;

@RestController
public class WorkingHoursUpdateController {

    @PostMapping("/workinghour")
    public void updateWorkingHours(@RequestBody Map<String, Long> meetingsHoursMap) {
        WorkingHoursStore.workingHoursMap = meetingsHoursMap;
    }
    @GetMapping("/workinghour")
    public Map<String, Long > updateWorkingHours(){

        Map<String , Long> sortedWorkingHrs=new TreeMap(WorkingHoursStore.workingHoursMap);

        return sortedWorkingHrs;
    }

    @PostMapping("/chrome-history")
    public void updateChromeData(@RequestBody Map<String, Integer> map) {
        ChromeDataStore.map = map;
    }

    @GetMapping("/chrome-history")
    public ChromeData getChromeHistory() {
        ChromeData chromeData = new ChromeData();
        String[] data = new String[ChromeDataStore.map.size()];
        ChromeDataStore.map.keySet().toArray(data);
        Integer[] count = new Integer[ChromeDataStore.map.size()];
        ChromeDataStore.map.values().toArray(count);
        chromeData.setSiteNames(data);
        chromeData.setCount(count);

        return chromeData;

    }

    @PostMapping("/chrome-aggr")
    public void updateChromeAggrData(@RequestBody Map<String, Integer> map){
        ChromeDataStore.chromeAggr = map;
    }

    @GetMapping("/chrome-aggr")
    public ChromeAggrData getChromeAggrData(){
        ChromeAggrData chromeData = new ChromeAggrData();
        String[] data=new String [ChromeDataStore.chromeAggr.size()];
        ChromeDataStore.chromeAggr.keySet().toArray(data);
        Integer[] count = new Integer[ChromeDataStore.chromeAggr.size()];
        ChromeDataStore.chromeAggr.values().toArray(count);
        chromeData.setType(data);
        chromeData.setTime(count);
        return chromeData;
    }

    @PostMapping("/connectionlist")
    public void connectionUpdater(@RequestBody Map<String, Integer> connections) {
        ConnectionsStore.connectionStrength = connections;
    }

    @GetMapping("/connectionlist")
    public Map<String, Integer> connectionUpdater() {
        return ConnectionsStore.connectionStrength;
    }

    @PostMapping("/newconnections")
    public void connectionUpdater(@RequestBody Set<String> newConnections) {
        ConnectionsStore.newConnections = newConnections;
    }

    @GetMapping("/newconnections")
    public Set<String> newConnectionUpdater() {
        return ConnectionsStore.newConnections;
    }

    @PostMapping("/processes")
    public ResponseEntity postController(@RequestBody Map<String, Integer> processData) {
        ProcessDataStore.map=processData;
        return ResponseEntity.ok("POSTED SUCCESSFULLY");
    }

    @GetMapping("/processes")
    public ProcessData getProcessData(){
        ProcessData pData = new ProcessData();
        String[] apps = new String[ProcessDataStore.map.size()];
        ProcessDataStore.map.keySet().toArray(apps);
        Integer[] timeSpent = new Integer[ProcessDataStore.map.size()];
        ProcessDataStore.map.values().toArray(timeSpent);
        pData.setApps(apps);
        pData.setTimeSpent(timeSpent);
        return pData;
    }

}
