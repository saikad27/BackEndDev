package org.sai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"org.sai.aspect","org.sai.service"})
public class Config {
}
