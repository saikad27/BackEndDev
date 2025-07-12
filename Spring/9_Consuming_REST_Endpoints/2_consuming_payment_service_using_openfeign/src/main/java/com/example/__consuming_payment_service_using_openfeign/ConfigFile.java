package com.example.__consuming_payment_service_using_openfeign;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Configuration
@EnableFeignClients(basePackages="com.example.__consuming_payment_service_using_openfeign.proxy")
public class ConfigFile {

}
