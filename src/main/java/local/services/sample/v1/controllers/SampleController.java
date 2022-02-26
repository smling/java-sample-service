package local.service.sample.services.sample.v1.controllers;

import com.bbpos.tms2.libs.web.constants.ContentType;
import com.bbpos.tms2.libs.web.v1.dto.CommandResponse;
import local.service.sample.services.sample.services.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sample")
@Tag(name="Sample", description = "Sample API")
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService=sampleService;
    }

    @GetMapping(value = "/echo", produces = ContentType.APPLICATION_JSON)
    @Operation(summary = "Get response from API.", description = "Description here.", tags={ "Sample" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success."),
        @ApiResponse(responseCode = "500", description = "Server Error."),
        @ApiResponse(responseCode = "400", description = "Bad Request.")
    })
    public CommandResponse echo(
        @Parameter(description = "Input value")
        String value
    ) {
        return sampleService.echo(value);
    }
}
