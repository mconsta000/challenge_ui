package org.mconsta000.challenge.service.model;

/**
 * FoeEncounterModel
 */
public class FoeEncounterModel {
    private Integer id;
    private String url;
    private Integer foe;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFoe() {
        return foe;
    }

    public void setFoe(Integer foe) {
        this.foe = foe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}