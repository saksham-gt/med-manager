package htf.medmanager.controller;

import htf.medmanager.adapter.UserAdapter;
import htf.medmanager.model.dto.UserDto;
import htf.medmanager.model.request.CreateUserRequest;
import htf.medmanager.model.request.UpdateUserRequest;
import htf.medmanager.model.response.UserDetailsResponse;
import htf.medmanager.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @Operation(summary = "Create User")
    @ApiResponse(responseCode = "201", description = "User Created Successfully",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/")
    public ResponseEntity<UserDetailsResponse> createUser(@RequestBody CreateUserRequest request) {
        System.out.println("CREATE REQUEST RECEIVED WITH MOBILE NUMBER - " + request.getMobileNumber());
        UserDto userDto = userService.createUser(request.getMobileNumber());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserAdapter.toUserDetailsResponse(userDto));
    }

    @Operation(summary = "Update User")
    @ApiResponse(responseCode = "200", description = "User Update Successfully",
            content = @Content(mediaType = "application/json"))
    @PatchMapping(value = "/{id}")
    public ResponseEntity<UserDetailsResponse> updateUser(@PathVariable("id") String userId,
                                                          @RequestBody UpdateUserRequest request) {
        UserDto userDto = userService.updateUser(userId, request);
        return ResponseEntity.ok()
                .body(UserAdapter.toUserDetailsResponse(userDto));
    }

    @Operation(summary = "Get User By Id")
    @ApiResponse(responseCode = "200", description = "User Found Successfully",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "User Not Found",
            content = @Content(mediaType = "application/json"))
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDetailsResponse> getUserById(@PathVariable("id") String userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok()
                .body(UserAdapter.toUserDetailsResponse(userDto));
    }

    @Operation(summary = "Get User By Mobile Number")
    @ApiResponse(responseCode = "200", description = "User Found Successfully",
            content = @Content(mediaType = "application/json"))
    @GetMapping(value = "/mobileNumber/{num}")
    public ResponseEntity<UserDetailsResponse> getUserByMobileNumber(@PathVariable("num") String mobileNumber) {
        UserDto userDto = userService.getUserByMobileNumber(mobileNumber);
        return ResponseEntity.ok()
                .body(UserAdapter.toUserDetailsResponse(userDto));
    }
}
