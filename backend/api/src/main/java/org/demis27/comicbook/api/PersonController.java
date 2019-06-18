package org.demis27.comicbook.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.demis27.comicbook.data.Person;
import org.demis27.comicbook.data.PersonRepository;

import javax.inject.Inject;
import java.util.List;

@Controller("/api/v1/person")
public class PersonController {

    @Inject
    private PersonRepository personRepository;

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Maybe<Person>> get(@PathVariable String id) {
        return HttpResponse.created(personRepository.get(id));
    }

    @Get(value = "/", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Single<List<Person>>> get() {
        return HttpResponse.created(personRepository.list());
    }

    @Post(value = "/", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Single<Person>> post(@Body Person person) {
        return HttpResponse.created(personRepository.create(person));
    }
}
