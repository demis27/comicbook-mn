package org.demis27.comicbook.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.demis27.comicbook.data.Person;

@Controller("/api/v1/person")
public class PersonController {

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> get(@PathVariable String id) {
        return HttpResponse.created(new Person(id));
    }
}
