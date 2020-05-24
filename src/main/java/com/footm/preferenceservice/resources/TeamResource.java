package com.footm.preferenceservice.resources;

import com.footm.preferenceservice.api.FullTeamSpecification;
import com.footm.preferenceservice.api.PlayerPositions;
import com.footm.preferenceservice.api.TeamCreationRepresentation;
import com.footm.preferenceservice.db.TeamDao;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("teams")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    private TeamDao teamDao;

    public TeamResource(TeamDao dao) {
        this.teamDao = dao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long createTeam(@NotNull TeamCreationRepresentation teamCreationRepresentation) {
        long teamId = teamDao.createTeam(teamCreationRepresentation);
        if (teamId != 0) {
            return teamId;
        }
        throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }

    @DELETE
    @Path("/{teamId}")
    public void deleteTeam(@NotNull @PathParam("teamId") int teamId) {
        int changedLines = teamDao.deleteTeam(teamId);

        ifNoChangedLineRespondWithNotFound(changedLines);
    }

    @PUT
    @Path("/{teamId}/name")
    @Consumes(MediaType.TEXT_PLAIN)
    public void setTeamName(@NotNull @PathParam("teamId") int teamId, @NotNull String newTeamName) {
        int changedLines = teamDao.setTeamName(teamId, newTeamName);

        ifNoChangedLineRespondWithNotFound(changedLines);
    }

    @PUT
    @Path("/{teamId}/formation")
    @Consumes(MediaType.TEXT_PLAIN)
    public void setTeamFormation(@PathParam("teamId") int teamId, String newTeamName) {
        int changedLines = teamDao.setTeamFormation(teamId, newTeamName);
        ifNoChangedLineRespondWithNotFound(changedLines);
    }

    @PUT
    @Path("/{teamId}/positions")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setPlayersToPositions(@PathParam("teamId") int teamId, PlayerPositions playerPositions) {
        int changedLines = teamDao.setPlayersToPositions(teamId, playerPositions);

        ifNoChangedLineRespondWithNotFound(changedLines);
    }

    @GET
    @Path("/{teamId}")
    public FullTeamSpecification getTeamWithId(@PathParam("teamId") int id) {
        FullTeamSpecification expectedTeam = teamDao.getTeamWithId(id);

        if (expectedTeam != null) {
            return expectedTeam;
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    private void ifNoChangedLineRespondWithNotFound(int changedLines) {
        if (changedLines == 0) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
