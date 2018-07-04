package com.animals.config.database;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class EbeanProvider implements Provider<EbeanServer> {

    private final DataSource datasource;

    @Override
    public EbeanServer get() {

        ServerConfig conf = new ServerConfig();
        conf.setAutoCommitMode(false);
        conf.setName("ebean");
        conf.setDefaultServer(true);
        conf.addPackage("com.animals");
        conf.setExpressionNativeIlike(true);
        conf.setDataSource(datasource);
        return EbeanServerFactory.create(conf);
    }
}
