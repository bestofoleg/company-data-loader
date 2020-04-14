package com.boo.companydataloader.dto;

import java.util.List;

public class OrganizationData {
    private boolean isNeedToBeSave;

    private String inn;

    private List<String> competitorNames;

    private String name;

    private String address;

    public OrganizationData() {}

    public OrganizationData(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNeedToBeSave() {
        return isNeedToBeSave;
    }

    public void setNeedToBeSave(boolean needToBeSave) {
        isNeedToBeSave = needToBeSave;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public List<String> getCompetitorNames() {
        return competitorNames;
    }

    public void setCompetitorNames(List<String> competitorNames) {
        this.competitorNames = competitorNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InputOrganizationData{" +
                "inn='" + inn + '\'' +
                '}';
    }
}
