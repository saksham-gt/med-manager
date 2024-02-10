package htf.medmanager.controller;

import htf.medmanager.model.request.GenerateOTPRequest;
import htf.medmanager.model.request.VerifyOTPRequest;
import htf.medmanager.model.response.GenerateOTPResponse;
import htf.medmanager.model.response.VerifyOTPResponse;
import htf.medmanager.service.IOnboardingService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/v1/otp")
@RestController
@RequiredArgsConstructor
public class OnboardingController {

    private final IOnboardingService onboardingService;

    @Operation(summary = "Generate OTP")
    @ApiResponse(responseCode = "201", description = "OTP generated successfully",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/generate")
    public ResponseEntity<GenerateOTPResponse> generateOTP(@RequestBody GenerateOTPRequest request) {

        GenerateOTPResponse response = onboardingService.generateOTP(request.getMobileNumber());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Verify OTP")
    @ApiResponse(responseCode = "200", description = "OTP verified successfully",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/verify")
    public ResponseEntity<VerifyOTPResponse> verifyOTP(@RequestBody VerifyOTPRequest request) {

        Boolean isVerified = onboardingService.verifyOTP(request.getRequestId(), request.getCode());
        return ResponseEntity.ok(VerifyOTPResponse.builder()
                .isVerified(isVerified)
                .build());
    }
}
