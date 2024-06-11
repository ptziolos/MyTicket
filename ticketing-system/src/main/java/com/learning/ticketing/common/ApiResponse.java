package com.learning.ticketing.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiResponse<T> implements Serializable {
  String transactionId = UUID.randomUUID().toString().toUpperCase();

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  Date createdAt = new Date();

  T data;

  ApiError apiError;
}