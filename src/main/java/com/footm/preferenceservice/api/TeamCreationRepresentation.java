package com.footm.preferenceservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TeamCreationRepresentation {
    private String teamName;
    private String teamFormation;

    public TeamCreationRepresentation() {
    }

    public TeamCreationRepresentation(String teamName, String teamFormation) {
        this.teamName = teamName;
        this.teamFormation = teamFormation;
    }

    @JsonProperty
    public String getTeamName() {
        return teamName;
    }

    @JsonProperty
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @JsonProperty
    public String getTeamFormation() {
        return teamFormation;
    }

    @JsonProperty
    public void setTeamFormation(String teamFormation) {
        this.teamFormation = teamFormation;
    }

    @Override
    public String toString() {
        return "TeamCreationRepresentation{" +
                "teamName='" + teamName + '\'' +
                ", teamFormation='" + teamFormation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamCreationRepresentation that = (TeamCreationRepresentation) o;
        return Objects.equals(teamName, that.teamName) &&
                Objects.equals(teamFormation, that.teamFormation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamName, teamFormation);
    }
}
