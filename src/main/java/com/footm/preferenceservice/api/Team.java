package com.footm.preferenceservice.api;

import java.util.Objects;

public class Team {
    private String teamName;
    private String teamFormation;

    public void setName(String team_name) {
        this.teamName = team_name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamFormation='" + teamFormation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) &&
                Objects.equals(teamFormation, team.teamFormation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamName, teamFormation);
    }
}
