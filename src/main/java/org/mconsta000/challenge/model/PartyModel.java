package org.mconsta000.challenge.model;

import java.util.List;

/**
 * PartiesModel
 */
public class PartyModel {
    private Integer id;
    private String url;
    private String name;
    private List<Integer> player;

    public Integer getId() {
        return id;
    }

    public List<Integer> getPlayer() {
        return player;
    }

    public void setPlayer(List<Integer> player) {
        this.player = player;
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