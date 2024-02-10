package htf.medmanager.service.impl;

import com.vonage.client.VonageClient;
import com.vonage.client.verify.CheckResponse;
import com.vonage.client.verify.VerifyResponse;
import com.vonage.client.verify.VerifyStatus;
import htf.medmanager.model.response.GenerateOTPResponse;
import htf.medmanager.service.IOnboardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnboardingServiceImpl implements IOnboardingService {
    private final VonageClient client = VonageClient.builder().apiKey("8e8271a7").apiSecret("mRhwIKVE5MMtQfGn").build();

    private final String brand = "Chang Pharma";
    @Override
    public GenerateOTPResponse generateOTP(String mobileNumber) {
        VerifyResponse response = client.getVerifyClient().verify(mobileNumber, brand);
        if(response.getStatus() == VerifyStatus.ALREADY_REQUESTED) {
            client.getVerifyClient().cancelVerification(response.getRequestId());
        }
        if (response.getStatus() == VerifyStatus.OK || response.getStatus() == VerifyStatus.ALREADY_REQUESTED) {
            return GenerateOTPResponse.builder()
                    .requestId(response.getRequestId())
                    .status(response.getStatus().name())
                    .build();
        } else {
            throw new RuntimeException("OTP Request Failed. Verification Status - " + response.getStatus().name());
        }
    }

    @Override
    public Boolean verifyOTP(String requestId, String code) {
        CheckResponse response = client.getVerifyClient().check(requestId, code);
        if (response.getStatus() == VerifyStatus.OK) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
