package com.epam.wfhmanager.wfhmanager.model;

public class ProcessData {
    String[] apps;
    Integer[] timeSpent;
    public String[] getApps() {
        return apps;
    }
    public void setApps(String[] apps) {
        this.apps = apps;
    }
    public Integer[] getTimeSpent() {
        return timeSpent;
    }
    public void setTimeSpent(Integer[] timeSpent) {
        this.timeSpent = timeSpent;
    }
}
