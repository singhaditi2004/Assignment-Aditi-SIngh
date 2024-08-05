package com.example.assignmet_aditi_singh;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView imageView = findViewById(R.id.imageView);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            titleTextView.setText(product.getTitle());
            descriptionTextView.setText(product.getDescription());
            String imageUrl = product.getFirstImage();
            Log.d("ProductDetailActivity", "Loading image from URL: " + imageUrl);
            if (imageUrl != null) {
                Picasso.get().load(imageUrl).into(imageView);
            } else {
                Log.d("ProductDetailActivity", "Image URL is null");
                TagAdapter adapter = new TagAdapter(product.getTags());
                RecyclerView tagsRecyclerView = findViewById(R.id.tagRecycle);
                tagsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                tagsRecyclerView.setAdapter(adapter);
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}