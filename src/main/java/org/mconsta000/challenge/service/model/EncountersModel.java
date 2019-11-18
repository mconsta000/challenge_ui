package org.mconsta000.challenge.service.model;

import java.util.List;

/**
 * Encounters
 */
public class EncountersModel {
    private Integer id;
    private String url;
    private String name;
    private List<Integer> foes;

    public Integer getId() {
        return id;
    }

    public List<Integer> getFoes() {
        return foes;
    }

    public void setFoes(List<Integer> foes) {
        this.foes = foes;
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