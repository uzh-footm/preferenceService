package com.footm.preferenceservice.db;

import com.footm.preferenceservice.api.FullTeamSpecification;
import com.footm.preferenceservice.api.PlayerPositions;
import com.footm.preferenceservice.api.TeamCreationRepresentation;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 * The interface TeamDao uses the JDBI SQL Object API to communicate with DB, it takes advantage of mapping between
 * relations and object.
 *
 * @author Rinor Sefa
 * @author Lundrim Azemi
 */
public interface TeamDao {

    @SqlUpdate("INSERT INTO teams_formation (name,formation) VALUES (:teamName, :teamFormation::formation)")
    @GetGeneratedKeys("id")
    long createTeam(@BindBean TeamCreationRepresentation teamCreationRepresentation);

    @SqlUpdate("DELETE FROM teams_formation WHERE id = :teamId")
    int deleteTeam(@Bind("teamId") int teamId);

    @SqlUpdate("UPDATE teams_formation SET name = :teamName WHERE id = :teamId")
    int setTeamName(@Bind("teamId") int teamId, @Bind("teamName") String teamName);

    @SqlUpdate("UPDATE teams_formation SET formation = :teamFormation::formation WHERE id = :teamId")
    int setTeamFormation(@Bind("teamId") int teamId, @Bind("teamFormation") String teamFormation);

    @SqlUpdate("UPDATE teams_formation SET  ls = :ls, st = :st ,rs = :rs, lw = :lw ," +
            "lf = :lf, cf = :cf, rf = :rf, rw = :rw, " +
            "lam = :lam, cam = :cam, ram = :ram, " +
            "lm = :lm, lcm = :lcm, cm = :cm, " +
            "rcm = :rcm, rm = :rm, lwb = :lwb, " +
            "ldm = :ldm, cdm = :cdm, rdm = :rdm, " +
            "rwb = :rwb, lb = :lb, lcb = :lcb, " +
            "cb = :cb, rcb = :rcb, rb = :rb, gk = :gk WHERE id = :teamId")
    int setPlayersToPositions(@Bind("teamId") int teamId, @BindBean PlayerPositions playerPositions);

    @SqlQuery("Select id, name, formation, ls, st, rs, lw, lf, cf, rf, rw, lam," +
            "cam, ram, lm, lcm, cm, rcm, rm, lwb, ldm, cdm, rdm, rwb, lb, lcb, cb, rcb, rb," +
            "gk FROM teams_formation where id = :teamId")
    @RegisterBeanMapper(FullTeamSpecification.class)
    FullTeamSpecification getTeamWithId(@Bind("teamId") int teamId);
}
