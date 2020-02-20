package pl.qbix.openapi;

import org.openapitools.api.FirstEndpointApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
public class FirstEndpointController implements FirstEndpointApi {
    @Override
    public ResponseEntity<Integer> firstEndpointGet(@Valid LocalDate firstDateOnRoot, @Valid LocalDate secondDateOnRoot) {
        return ResponseEntity.ok(1);
    }
}
