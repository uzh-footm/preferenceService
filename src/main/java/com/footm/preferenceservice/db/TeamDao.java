package com.footm.preferenceservice.db;

import com.footm.preferenceservice.api.FullTeamSpecification;
import com.footm.preferenceservice.api.PlayerPositions;
import com.footm.preferenceservice.api.TeamCreationRepresentation;

public interface TeamDao {

    //TODO: needs to be implemented;

    int createTeam(TeamCreationRepresentation teamCreationRepresentation);

    int deleteTeam(int teamId);

    int setTeamName(int teamId, String teamName);

    int setTeamFormation(int teamId, String teamPosition);

    int setPlayersToPositions(int teamId, PlayerPositions playerPositions);

    FullTeamSpecification getTeamWithId(int i);
}
