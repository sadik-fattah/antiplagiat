package com.guercifzone.antiplagiat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.guercifzone.antiplagiat.Api.AiTextDetectionApi;
import com.guercifzone.antiplagiat.Responce.DetectionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    private EditText textInput;
    private Button analyzeButton;
    private TextView resultText;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInput = findViewById(R.id.textInput);
        analyzeButton = findViewById(R.id.analyzeButton);
        resultText = findViewById(R.id.resultText);
        // Initialize Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fakefinder.ai/")  // Replace with the actual API endpoint
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AiTextDetectionApi api = retrofit.create(AiTextDetectionApi.class);

        analyzeButton.setOnClickListener(view -> {
            String inputText = textInput.getText().toString().trim();
            if (!inputText.isEmpty()) {
                analyzeText(api, inputText);
            }
        });

    }
    private void analyzeText(AiTextDetectionApi api, String inputText) {
        // Call the API
        Call<DetectionResponse> call = api.detectAiText(inputText);
        call.enqueue(new Callback<DetectionResponse>() {
            @Override
            public void onResponse(Call<DetectionResponse> call, Response<DetectionResponse> response) {
                if (response.isSuccessful()) {
                    boolean isAiGenerated = response.body().isAiGenerated();
                    if (isAiGenerated) {
                        resultText.setText("The text is AI-generated.");
                    } else {
                        resultText.setText("The text is human-written.");
                    }
                } else {
                    resultText.setText("Error: Unable to analyze text.");
                }
            }

            @Override
            public void onFailure(Call<DetectionResponse> call, Throwable t) {
                resultText.setText("Failed to connect to the API.");
            }
        });
    }
}