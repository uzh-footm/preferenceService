package com.footm.preferenceservice;

import com.footm.preferenceservice.db.TeamDao;
import com.footm.preferenceservice.resources.TeamResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class PreferenceServiceApplication extends Application<PreferenceServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PreferenceServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "PreferenceService";
    }

    @Override
    public void initialize(final Bootstrap<PreferenceServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PreferenceServiceConfiguration configuration,
                    final Environment environment) {

        //database
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        TeamDao teamDao = jdbi.onDemand(TeamDao.class);

        environment.jersey().register(new TeamResource(teamDao));
    }
}
