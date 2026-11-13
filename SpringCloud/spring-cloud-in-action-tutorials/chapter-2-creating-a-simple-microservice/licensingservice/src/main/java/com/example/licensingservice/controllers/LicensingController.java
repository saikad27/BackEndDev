package com.example.licensingservice.controllers;


import com.example.licensingservice.model.License;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicensingController {
    @RequestMapping(value="/{licenseId}",method= RequestMethod.GET)
    public License getLicense(@PathVariable String licenseId, @PathVariable String organizationId){
        return new License()
                .withId(licenseId)
                .withProductName("Teleco")
                .withLicenseType("Seat")
                .withOrganizationId(organizationId);
    }
}
