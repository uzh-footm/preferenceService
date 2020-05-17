package com.footm.preferenceservice.resources;

import com.footm.preferenceservice.api.FullTeamSpecification;
import com.footm.preferenceservice.api.PlayerPositions;
import com.footm.preferenceservice.api.TeamCreationRepresentation;
import com.footm.preferenceservice.db.TeamDao;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
class TeamResourceTest {

    private static final TeamDao dao = mock(TeamDao.class);
    private static final ResourceExtension RULE = ResourceExtension.builder()
            .addResource(new TeamResource(dao))
            .build();

    @AfterEach
    void tearDown() {
        reset(dao);
    }

    @Test
    void testCreateTeamSuccess() {
        TeamCreationRepresentation createTeam = new TeamCreationRepresentation();
        createTeam.setTeamName("Team Name");
        createTeam.setTeamFormation("5-4-3");

        when(dao.createTeam(createTeam)).thenReturn(4);

        Response expectedResponse = RULE.target("/teams")
                .request()
                .post(Entity.entity(createTeam, MediaType.APPLICATION_JSON));

        assertThat(expectedResponse.readEntity(Integer.class)).isEqualTo(4);
        verify(dao).createTeam(createTeam);
    }

    @Test
    void testCreateTeamInternalError() {
        TeamCreationRepresentation createTeam = new TeamCreationRepresentation();
        when(dao.createTeam(createTeam)).thenReturn(0);

        Response expectedResponse = RULE.target("/teams")
                .request()
                .post(Entity.entity(createTeam, MediaType.APPLICATION_JSON));

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.INTERNAL_SERVER_ERROR);
        verify(dao).createTeam(createTeam);
    }

    @Test
    void testDeleteTeamSuccess() {
        when(dao.deleteTeam(2)).thenReturn(1);

        Response expectedResponse = RULE.target("/teams")
                .path("2")
                .request()
                .delete();

        System.out.println(expectedResponse);
        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NO_CONTENT);
        verify(dao).deleteTeam(2);
    }

    @Test
    void testDeleteTeamNotFound() {
        when(dao.deleteTeam(2)).thenReturn(0);

        Response expectedResponse = RULE.target("/teams")
                .path("2")
                .request()
                .delete();

        System.out.println(expectedResponse);
        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        verify(dao).deleteTeam(2);
    }


    @Test
    void testSetTeamNameSuccess() {
        when(dao.setTeamName(5, "New Team Name")).thenReturn(1);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("name")
                .request()
                .put(Entity.text("New Team Name"), Response.class);

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NO_CONTENT);
        verify(dao).setTeamName(5, "New Team Name");
    }

    @Test
    void testSetTeamNameNotFound() {
        when(dao.setTeamName(5, "New Team Name")).thenReturn(0);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("name")
                .request()
                .put(Entity.text("New Team Name"), Response.class);

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        verify(dao).setTeamName(5, "New Team Name");
    }

    @Test
    void testSetTeamPosition() {
        when(dao.setTeamFormation(5, "5-4-3")).thenReturn(1);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("formation")
                .request()
                .put(Entity.text("5-4-3"), Response.class);

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NO_CONTENT);
        verify(dao).setTeamFormation(5, "5-4-3");
    }

    @Test
    void testSetTeamPositionNotFound() {
        when(dao.setTeamFormation(5, "5-4-3")).thenReturn(0);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("formation")
                .request()
                .put(Entity.text("5-4-3"), Response.class);

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        verify(dao).setTeamFormation(5, "5-4-3");
    }

    @Test
    void testAssignPlayersToPositions() {
        PlayerPositions playerPositions = new PlayerPositions();
        playerPositions.setGk(1001);
        playerPositions.setLb(1002);
        playerPositions.setLcb(1003);
        playerPositions.setRcb(1004);
        playerPositions.setRb(1005);
        playerPositions.setLcm(1006);
        playerPositions.setRcm(1007);
        playerPositions.setCam(1008);
        playerPositions.setRw(1009);
        playerPositions.setSt(1010);
        playerPositions.setLw(1011);

        when(dao.setPlayersToPositions(5, playerPositions)).thenReturn(1);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("positions")
                .request()
                .put(Entity.entity(playerPositions, MediaType.APPLICATION_JSON));

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NO_CONTENT);
        verify(dao).setPlayersToPositions(5, playerPositions);
    }

    @Test
    void testAssignPlayersToPositionsNotFound() {
        PlayerPositions playerPositions = new PlayerPositions();
        when(dao.setPlayersToPositions(5, playerPositions)).thenReturn(0);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .path("positions")
                .request()
                .put(Entity.entity(playerPositions, MediaType.APPLICATION_JSON));

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        verify(dao).setPlayersToPositions(5, playerPositions);
    }

    @Test
    void testGetTeamWithIdSuccess() {

        when(dao.getTeamWithId(5)).thenReturn(new FullTeamSpecification());

        FullTeamSpecification expectedResponse = RULE.target("/teams")
                .path("5")
                .request()
                .get(FullTeamSpecification.class);

        assertThat(expectedResponse).isEqualTo(expectedResponse);
        verify(dao).getTeamWithId(5);
    }

    @Test
    void testGetTeamWithIdNotFound() {

        when(dao.getTeamWithId(5)).thenReturn(null);

        Response expectedResponse = RULE.target("/teams")
                .path("5")
                .request()
                .get();

        assertThat(expectedResponse.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        verify(dao).getTeamWithId(5);
    }
}
