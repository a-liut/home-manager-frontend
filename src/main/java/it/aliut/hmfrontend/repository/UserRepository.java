package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.User;
import it.aliut.hmfrontend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Repository for {@link User} objects.
 */
@Repository
public class UserRepository implements IUserRepository {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public UserRepository(RestTemplateBuilder restTemplateBuilder, @Value("${app.services.users.url}") String baseUrl) {
        restTemplate = restTemplateBuilder.build();
        this.baseUrl = baseUrl;
    }

    /**
     * Return all registered users.
     *
     * @return An array of {@link User} objects.
     */
    @Override
    public User[] getAll() {
        URI uri = getUriBuilder()
                .path("/users")
                .build()
                .toUri();

        return restTemplate.getForObject(uri, User[].class);
    }

    @Override
    public User getById(String id) {
        URI uri = getUriBuilder()
                .path("/users/{userId}")
                .buildAndExpand(id)
                .toUri();

        try {
            return restTemplate.getForObject(uri, User.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new UserNotFoundException(id);
            }

            throw ex;
        }
    }

    /**
     * Returns a {@link UriComponentsBuilder} initialized with the repository base URL.
     *
     * @return The {@link UriComponentsBuilder} object.
     */
    private UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }
}
