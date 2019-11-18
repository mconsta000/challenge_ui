package org.mconsta000.challenge.controller.model;

/**
 * EncounterModel
 */
public class EncounterModel {
    private String name;
    private Integer count;
    private Integer xp;

    public String getName() {
        return name;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}