package com.bbpos.tms2.services.sample.v1.controllers;

import com.bbpos.tms2.services.sample.services.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sample")
@Tag(name="Sample", description = "Sample API")
public class SampleController {
    private SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService=sampleService;
    }

    @GetMapping("/echo")
    @Operation(summary = "Get response from API.", description = "Description here.", tags={ "Sample" })
    @ApiResponses(
        @ApiResponse(responseCode = "200", description = "Success.")
    )
    public String echo(
        @Parameter(description = "Input value")
        String value
    ) {
        return sampleService.echo(value);
    }
}
