package org.sai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"org.sai.services","org.sai.aspects"})
@EnableAspectJAutoProxy
public class Config {
}
