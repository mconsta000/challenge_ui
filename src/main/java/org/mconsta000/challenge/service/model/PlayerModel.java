package org.mconsta000.challenge.service.model;

/**
 * PlayerModel
 */
public class PlayerModel {
    private Integer id;
    private String url;
    private String name;
    private Integer level;

    public Integer getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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