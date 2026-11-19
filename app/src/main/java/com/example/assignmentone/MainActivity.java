
package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main activity of the CampusLife application.
 * Displays four service buttons and opens the selected detail page.
 */
public class MainActivity extends AppCompatActivity {

    // Unique key used to identify the selected topic
    public static final String EXTRA_TOPIC_INDEX = "topic_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle system bar insets to keep the layout responsive.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });
    }

    // Open Facilities details
    public void onFacilitiesClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 0);
        startActivity(intent);
    }

    // Open Events details
    public void onEventsClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 1);
        startActivity(intent);
    }

    // Open Clubs details
    public void onClubsClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 2);
        startActivity(intent);
    }

    // Open Support details
    public void onSupportClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 3);
        startActivity(intent);
    }
}
