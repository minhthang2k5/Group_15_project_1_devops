package com.yas.search.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebMvcTest(controllers = SecurityConfigFilterChainTest.TestEndpoints.class)
@Import({SecurityConfig.class, SecurityConfigFilterChainTest.TestSecurityBeans.class})
@AutoConfigureMockMvc
class SecurityConfigFilterChainTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testStorefrontEndpoint_withoutToken_isPermitted() throws Exception {
        mockMvc.perform(get("/storefront/ping"))
            .andExpect(status().isOk());
    }

    @Test
    void testBackofficeEndpoint_withoutToken_isUnauthorized() throws Exception {
        mockMvc.perform(get("/backoffice/ping"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void testAnyOtherEndpoint_withoutToken_isUnauthorized() throws Exception {
        mockMvc.perform(get("/private/ping"))
            .andExpect(status().isUnauthorized());
    }

    @RestController
    static class TestEndpoints {
        @GetMapping("/storefront/ping")
        ResponseEntity<String> storefront() {
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }

        @GetMapping("/backoffice/ping")
        ResponseEntity<String> backoffice() {
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }

        @GetMapping("/private/ping")
        ResponseEntity<String> privateApi() {
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
    }

    @TestConfiguration
    static class TestSecurityBeans {
        @Bean
        JwtDecoder jwtDecoder() {
            return token -> Jwt.withTokenValue(token)
                .header("alg", "none")
                .claim("sub", "test-user")
                .build();
        }
    }
}
