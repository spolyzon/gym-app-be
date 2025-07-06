package com.gym.bodyandmindharmony;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties"
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class AuthenticationIntegrationTests {

    private static final String HELLO_URL = "/hello";
    private static final String EXCEPTION_RESPONSE_CODE = "$.code";
    private static final String EXCEPTION_RESPONSE_CATEGORY = "$.category";
    private static final String EXCEPTION_RESPONSE_MESSAGE = "$.message";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(0)
    void theOneWhereAccessTokenIsNull() throws Exception {
        mockMvc
                .perform(get(HELLO_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CODE).value(3000))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CATEGORY).value("ACCESS_DENIED"))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_MESSAGE).value("No Authorization header found"))
                .andDo(print());
    }

}
