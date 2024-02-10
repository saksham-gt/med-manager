package htf.medmanager.service;

import htf.medmanager.model.response.GenerateOTPResponse;

public interface IOnboardingService {
    GenerateOTPResponse generateOTP(String mobileNumber);

    Boolean verifyOTP(String requestId, String code);
}
