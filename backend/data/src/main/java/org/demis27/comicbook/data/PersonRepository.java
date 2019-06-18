package org.demis27.comicbook.data;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.bson.types.ObjectId;

import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;

@Singleton
public class PersonRepository {

    private final MongoClient mongoClient;

    public PersonRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public Single<List<Person>> list() {
        return Flowable.fromPublisher(getCollection().find()).toList();
    }

    public Maybe<Person> get(String id) {
        return Flowable.fromPublisher(getCollection().find(eq("_id", id)).limit(1)).firstElement();
    }

    private MongoCollection<Person> getCollection() {
        return mongoClient.getDatabase("comics").getCollection("person", Person.class);
    }

    public Single<Person> create(Person person) {
        if (person.getId() == null) {
            person.setId(UUID.randomUUID().toString());
        }
        return Single.fromPublisher(getCollection().insertOne(person)).map(success -> person);
    }
}
