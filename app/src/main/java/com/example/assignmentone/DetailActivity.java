
package com.example.assignmentone;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Displays details for the selected CampusLife service.
 * Loads the corresponding image, title and content from XML arrays.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Apply system bar padding to avoid overlapping screen content.
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

        // Receive the selected topic index
        int topicIndex = getIntent().getIntExtra(
                MainActivity.EXTRA_TOPIC_INDEX, -1);

        Log.d("CampusLife", "Selected topic index: " + topicIndex);

        // Retrieve arrays from arrays.xml
        String[] images = getResources().getStringArray(
                R.array.string_array_images);

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles);

        String[] contents = getResources().getStringArray(
                R.array.string_array_content);

        // Find views in activity_detail.xml
        ImageView detailIcon = findViewById(R.id.detail_icon);
        TextView detailTopic = findViewById(R.id.detail_topic);
        TextView detailTitle = findViewById(R.id.detail_title);
        TextView detailContent = findViewById(R.id.detail_content);

        // Retrieve the corresponding topic data
        String imageName = images[topicIndex].trim();
        String title = titles[topicIndex].trim();
        String content = contents[topicIndex].trim();

        // Obtain the drawable resource ID
        int imageId = getResources().getIdentifier(
                imageName, "drawable", getPackageName());

        // Generate the topic name from the image name
        String topicName = imageName.replace("img_btn_", "");
        topicName = Character.toUpperCase(topicName.charAt(0))
                + topicName.substring(1);

        // Update the DetailActivity UI
        detailIcon.setImageResource(imageId);
        detailTopic.setText(topicName);
        detailTitle.setText(title);
        detailContent.setText(content);
    }
}
