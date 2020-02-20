package pl.qbix.openapi;

import org.openapitools.api.SecondEndpointApi;
import org.openapitools.model.SomeObjectType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SecondEndpointController implements SecondEndpointApi {
    @Override
    public ResponseEntity<Integer> secondEndpointGet(@Valid SomeObjectType firstDateOnRoot) {
        return ResponseEntity.ok(1);
    }
}
