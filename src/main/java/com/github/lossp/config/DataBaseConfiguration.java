package com.github.lossp.config;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

public class DataBaseConfiguration {
    private static ProcessEngine processEngine;

    public static ProcessEngine getProcessEngine() {
        if (processEngine == null) {
            synchronized (DataBaseConfiguration.class) {
                if (processEngine == null) {
                    processEngine = build();
                }
            }
        }
        System.out.println("Engine started successfully");
        return processEngine;
    }

    private static ProcessEngine build() {
        ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration()
                // nullCatalogMeansCurrent=true means tables will be created if they are not found
                .setJdbcUrl("jdbc:mysql://localhost:3306/testflow?useUnicode=true&characterEncoding=utf8&autoReconnect=true&nullCatalogMeansCurrent=true")
                .setJdbcUsername("root")
                .setJdbcPassword("formylocal")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = configuration.buildProcessEngine();
        return processEngine;
    }
}
