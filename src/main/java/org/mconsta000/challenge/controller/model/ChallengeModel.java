package org.mconsta000.challenge.controller.model;

/**
 * ChallengeModel
 */
public class ChallengeModel {
    private Integer party;
    private Integer encounter;

    public Integer getParty() {
        return party;
    }

    public Integer getEncounter() {
        return encounter;
    }

    public void setEncounter(Integer encounter) {
        this.encounter = encounter;
    }

    public void setParty(Integer party) {
        this.party = party;
    }
}