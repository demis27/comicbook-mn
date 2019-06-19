package org.demis27.comicbook.data;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("comicbook")
public class ComicBookConfiguration {

    private String databaseName = "comics";

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
