package org.demis27.comicbook.data;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Person {

    private String firstname;

    private String id;

    public Person() {
    }

    @BsonCreator
    public Person(@BsonProperty("id")  String id, @BsonProperty("firstname") String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
