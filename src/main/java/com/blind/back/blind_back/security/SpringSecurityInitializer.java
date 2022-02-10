package com.blind.back.blind_back.security;

import com.blind.back.blind_back.config.SpringSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityInitializer() {
        super(SpringSecurityConfig.class);
    }
}
