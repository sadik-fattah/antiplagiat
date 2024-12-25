package com.guercifzone.antiplagiat.Api;

import com.guercifzone.antiplagiat.Responce.DetectionResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AiTextDetectionApi {
    @POST("detect-ai")
    Call<DetectionResponse> detectAiText(@Body String text);
}

