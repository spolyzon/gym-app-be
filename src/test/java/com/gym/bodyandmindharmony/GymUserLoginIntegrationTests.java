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
public class GymUserLoginIntegrationTests {

    private static final String REGISTRATION_URL = "/api/auth/register";
    private static final String LOGIN_URL = "/api/auth/login";
    private static final String EXCEPTION_RESPONSE_CODE = "$.code";
    private static final String EXCEPTION_RESPONSE_CATEGORY = "$.category";
    private static final String EXCEPTION_RESPONSE_MESSAGE = "$.message";

    private static final String FIRST_NAME = "$.firstName";
    private static final String LAST_NAME = "$.lastName";
    private static final String USERNAME = "$.username";
    private static final String ACCESS_TOKEN = "$.accessToken";
    private static final String REFRESH_TOKEN = "$.refreshToken";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(0)
    void theOneWhereFirstNameIsNull() throws Exception {
        final var request = """
                {
                }
                """;
        mockMvc
                .perform(post(LOGIN_URL).contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CODE).value(4001))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CATEGORY).value("BAD_REQUEST"))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_MESSAGE)
                        .value("JSON parse error: Missing required creator property 'username' (index 0)"))
                .andDo(print());
    }

    @Test
    @Order(0)
    void theOneWhereWeTryToLoginWithNotExistingUsername() throws Exception {
        final var loginRequest = """
                {
                    "username": "test"
                }
                """;
        mockMvc
                .perform(post(LOGIN_URL).contentType(MediaType.APPLICATION_JSON).content(loginRequest))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CODE).value(4040))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_CATEGORY).value("BAD_REQUEST"))
                .andExpect(jsonPath(EXCEPTION_RESPONSE_MESSAGE)
                        .value("User with username test does not exist"))
                .andDo(print());
    }

    @Test
    @Order(1)
    void theOneWhereWeSuccessfullyLogin() throws Exception {
        final var registrationRequest = """
                {
                    "firstName": "spyros",
                    "lastName": "polyzonis",
                    "username": "test"
                }
                """;
        mockMvc
                .perform(post(REGISTRATION_URL).contentType(MediaType.APPLICATION_JSON).content(registrationRequest))
                .andExpect(status().isCreated())
                .andDo(print());

        final var loginRequest = """
                {
                    "username": "test"
                }
                """;
        mockMvc
                .perform(post(LOGIN_URL).contentType(MediaType.APPLICATION_JSON).content(loginRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(FIRST_NAME).value("spyros"))
                .andExpect(jsonPath(LAST_NAME).value("polyzonis"))
                .andExpect(jsonPath(USERNAME).value("test"))
                .andExpect(jsonPath(ACCESS_TOKEN).isNotEmpty())
                .andExpect(jsonPath(REFRESH_TOKEN).isNotEmpty())
                .andDo(print());
    }

}
