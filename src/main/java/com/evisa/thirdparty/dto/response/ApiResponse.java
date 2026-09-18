package com.evisa.thirdparty.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private static final String STATUS_SUCCESS = "SUCCESS";
    private static final String STATUS_ERROR = "ERROR";

    private int statusCode;
    private String status;
    private String message;
    private Object data;

    public static ApiResponse ok(Object data) {
        return ApiResponse.builder()
                .statusCode(200)
                .status(STATUS_SUCCESS)
                .message("Request processed successfully")
                .data(data)
                .build();
    }

    public static ApiResponse ok(String message, Object data) {
        return ApiResponse.builder()
                .statusCode(200)
                .status(STATUS_SUCCESS)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse error(int statusCode, String message) {
        return ApiResponse.builder()
                .statusCode(statusCode)
                .status(STATUS_ERROR)
                .message(message)
                .build();
    }

    public static ApiResponse notFound(String message) {
        return ApiResponse.builder()
                .statusCode(404)
                .status(STATUS_ERROR)
                .message(message)
                .build();
    }
}
