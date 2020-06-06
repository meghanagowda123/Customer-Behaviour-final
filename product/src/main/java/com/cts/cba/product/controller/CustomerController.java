package com.cts.cba.product.controller;

import java.util.List;

import com.cts.cba.product.entity.Product;
import com.cts.cba.product.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Customer", description = "A controller to activate endpoint related to properties of customer entity")
@RequestMapping("/customers")
@RefreshScope
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET, value = "/soldlocationlist/{timeDuration}/{customerCategory}/{location}")
    @ApiOperation(value = "Gets list of locations", notes = "Generates list of average sales details based on customer geoagraphy")
    public List<Product> getAllByLocation(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Location of customers", required = true) @PathVariable String location) {

        logger.debug("Resquest: {} | {} | {}", timeDuration, customerCategory, location);
        List<Product> list = service.getAllByLocation(timeDuration, customerCategory, location);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;

    }
}