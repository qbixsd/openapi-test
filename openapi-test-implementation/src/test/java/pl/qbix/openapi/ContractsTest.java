package pl.qbix.openapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ContractsTest {
    @Autowired
    private MockMvc mokcMvc;

    @Test
    public void shouldAcceptDatesInIsoFormatWhenDefinedOnRootContractLevel() throws Exception {
        mokcMvc.perform(
                get("/firstEndpoint")
                        .param("firstDateOnRoot", "2020-10-02")
                        .param("secondDateOnRoot", "2020-10-02"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAcceptDatesInIsoFormatWhenDefinedInNestedObject() throws Exception {
        mokcMvc.perform(
                get("/secondEndpoint")
                        .param("firstNestedDate", "2020-10-02")
                        .param("secondNestedDate", "2020-10-02"))
                .andExpect(status().isOk());
    }


    @Test
    public void shouldNotAcceptDatesInShortFormatWhenDefinedInNestedObject() throws Exception {
        mokcMvc.perform(
                get("/secondEndpoint")
                        .param("firstNestedDate", "02/10/20")
                        .param("secondNestedDate", "02/10/20"))
                .andExpect(status().is5xxServerError());
    }
}
