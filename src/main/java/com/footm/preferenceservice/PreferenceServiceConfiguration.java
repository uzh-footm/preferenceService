package com.footm.preferenceservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The class PreferenceServiceConfiguration gets the environment specific parameters to run the microservice
 * In this case it gets the database address, username, password etc.
 *
 * @author Rinor Sefa
 * @author Lundrim Azemi
 */
public class PreferenceServiceConfiguration extends Configuration {
//DATABASE CONFIGURATION

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}