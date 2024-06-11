package com.learning.ticketing.common;

public record ApiError(Integer status, String message, String path) {
}
