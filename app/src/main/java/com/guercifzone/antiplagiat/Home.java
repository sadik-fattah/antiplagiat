package com.guercifzone.antiplagiat;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
/*
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://api-inference.huggingface.co/";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create HuggingFace API service
        HuggingFaceApi api = retrofit.create(HuggingFaceApi.class);

        // Input text to analyze
        String textToAnalyze = "Snowfall can have a significant impact on human activities.";

        // Prepare the input data
        InputData inputData = new InputData(textToAnalyze);

        // Make the API call
        Call<HuggingFaceResponse> call = api.detectOpenAIContent(inputData);
        call.enqueue(new Callback<HuggingFaceResponse>() {
            @Override
            public void onResponse(Call<HuggingFaceResponse> call, Response<HuggingFaceResponse> response) {
                if (response.isSuccessful()) {
                    HuggingFaceResponse huggingFaceResponse = response.body();
                    if (huggingFaceResponse != null && !huggingFaceResponse.getLabel().isEmpty()) {
                        Log.d(TAG, "Response: " + huggingFaceResponse.getLabel().get(0));
                    }
                } else {
                    Log.e(TAG, "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<HuggingFaceResponse> call, Throwable t) {
                Log.e(TAG, "Request failed", t);
            }
        });*/
    }
}
