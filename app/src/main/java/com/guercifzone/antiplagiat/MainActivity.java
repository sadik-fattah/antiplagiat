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

import com.guercifzone.antiplagiat.Classes.PlagiarismChecker_TF;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    TextView resultText;
    Button tf, ngrams, jaccard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inputText = findViewById(R.id.InputText);
        resultText = findViewById(R.id.ResultText);
        tf = findViewById(R.id.TF);
        ngrams = findViewById(R.id.Ngrams);
        jaccard = findViewById(R.id.Jaccard);

        tf.setOnClickListener(v -> {
            String enteredText = inputText.getText().toString();
            String[] allDocuments = {"Document 1 text", "Document 2 text", "Document 3 text"};

            PlagiarismChecker_TF checker = new PlagiarismChecker_TF();
            double similarity = checker.computeCosineSimilarity(enteredText, allDocuments[0], allDocuments);
            resultText.setText("Similarity: " + (similarity * 100) + "%");
        });
        ngrams.setOnClickListener(v -> {
            String enteredText = inputText.getText().toString();
            String[] allDocuments = {"Document 1 text", "Document 2 text", "Document 3 text"};

            PlagiarismChecker_TF checker = new PlagiarismChecker_TF();
            double similarity = checker.computeCosineSimilarity(enteredText, allDocuments[0], allDocuments);
            resultText.setText("Similarity: " + (similarity * 100) + "%");
        });
        jaccard.setOnClickListener(v -> {
            String enteredText = inputText.getText().toString();
            String[] allDocuments = {"Document 1 text", "Document 2 text", "Document 3 text"};

            PlagiarismChecker_TF checker = new PlagiarismChecker_TF();
            double similarity = checker.computeCosineSimilarity(enteredText, allDocuments[0], allDocuments);
            resultText.setText("Similarity: " + (similarity * 100) + "%");
        });

    }

}