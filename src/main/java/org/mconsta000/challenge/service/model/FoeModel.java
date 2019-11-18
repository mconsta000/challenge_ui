package org.mconsta000.challenge.service.model;

public class FoeModel {
    private Integer id;
    private String name;
    private Integer xp;
    private String url;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public void setName(String name) {
        this.name = name;
    }
}