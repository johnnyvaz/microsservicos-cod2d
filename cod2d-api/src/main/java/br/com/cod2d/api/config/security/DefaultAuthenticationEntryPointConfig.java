package br.com.cod2d.api.config.security;

import br.com.cod2d.api.config.base.ResponseBodyDTO;
import br.com.cod2d.api.config.base.error.ErrorDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DefaultAuthenticationEntryPointConfig implements AuthenticationEntryPoint {

    private static final String UNAUTHORIZED_DEVELOPER_MESSAGE =
            "Unauthorized - make sure the header parameter Authorization is valid";
    private static final String UNAUTHORIZED_USER_MESSAGE = "You are not authorized to perform this operation";
    private static final long UNAUTHORIZED_ERROR_CODE = 30001L;

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException)
            throws IOException {

        final var errorDTO = new ErrorDTO(UNAUTHORIZED_DEVELOPER_MESSAGE,
                UNAUTHORIZED_USER_MESSAGE,
                UNAUTHORIZED_ERROR_CODE);

        final var jsonError = buildObjectMapper()
                .writeValueAsString(new ResponseBodyDTO<>(errorDTO));

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().append(jsonError);
    }

    private static ObjectMapper buildObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        return objectMapper;
    }
}
