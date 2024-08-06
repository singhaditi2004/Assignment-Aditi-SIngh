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

import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView titleTextView, descriptionTextView, priceTextView, ratingTextView, categoryTextView, stockTextView,
            brandTextView, skuTextView, weightTextView, widthTextView, heightTextView, depthTextView, warrantyInfoTextView,
            shippingInfoTextView, availabilityStatusTextView, returnPolicyTextView, minumOrdTextView, createdAtTextView,
            updatedAtTextView, barCodeTextView;
    private ImageView imageView,qrCodeImageView;
    private RecyclerView tagsRecyclerView, ratingRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        imageView = findViewById(R.id.imageView);
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        priceTextView = findViewById(R.id.price);
        ratingTextView = findViewById(R.id.rating);
        categoryTextView = findViewById(R.id.category);
        stockTextView = findViewById(R.id.stock);
        brandTextView = findViewById(R.id.brand);
        skuTextView = findViewById(R.id.sku);
        weightTextView = findViewById(R.id.weight);
        widthTextView = findViewById(R.id.width);
        heightTextView = findViewById(R.id.height);
        depthTextView = findViewById(R.id.depth);
        warrantyInfoTextView = findViewById(R.id.warrantyInfo);
        shippingInfoTextView = findViewById(R.id.shippingInfo);
        availabilityStatusTextView = findViewById(R.id.availabilityStatus);
        returnPolicyTextView = findViewById(R.id.returnPolicy);
        minumOrdTextView = findViewById(R.id.minumOrd);
        createdAtTextView = findViewById(R.id.createdAt);
        updatedAtTextView = findViewById(R.id.updatedAt);
        barCodeTextView = findViewById(R.id.barCode);
        tagsRecyclerView = findViewById(R.id.tagRecycle);
        ratingRecyclerView = findViewById(R.id.ratingRecycle);
        qrCodeImageView=findViewById(R.id.qrcode);
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
            }

            Dimension dimension = product.getDimension();
            Meta meta = product.getMeta();
            TagAdapter adapter = new TagAdapter(product.getTags());
            String qrCodeUrl = meta.getQrCode();
            if (qrCodeUrl != null) {
                Picasso.get().load(qrCodeUrl).into(qrCodeImageView);
            }
            if (dimension != null) {
                double width = dimension.getWidth();
                double height = dimension.getHeight();
                double depth = dimension.getDepth();

                widthTextView.setText(String.valueOf(dimension.getWidth()));
                heightTextView.setText(String.valueOf(dimension.getHeight()));
                depthTextView.setText(String.valueOf(dimension.getDepth()));
            }
            else{
                Log.d("ProductDetailActivity", "Dimension is null");
            }
            tagsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            tagsRecyclerView.setAdapter(adapter);

            priceTextView.setText(String.valueOf(product.getPrice()));
            ratingTextView.setText(String.valueOf(product.getRating()));
            categoryTextView.setText(product.getCategory());
            stockTextView.setText(String.valueOf(product.getStock()));
            brandTextView.setText(product.getBrand());
            skuTextView.setText(product.getSku());
            weightTextView.setText(String.valueOf(product.getWeight()));

            warrantyInfoTextView.setText(product.getWarrantyInformation());
            shippingInfoTextView.setText(product.getShippingInformation());
            availabilityStatusTextView.setText(product.getAvailabilityStatus());
            returnPolicyTextView.setText(product.getReturnPolicy());
            minumOrdTextView.setText(String.valueOf(product.getMinimumOrderQuantity()));
            createdAtTextView.setText(meta.getCreatedAt());
            updatedAtTextView.setText(meta.getUpdatedAt());
            barCodeTextView.setText(meta.getBarcode());

            List<Review> reviews = product.getReviews();
            if (reviews != null) {
                ratingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                ReviwerAdapter reviewAdapter = new ReviwerAdapter(this, reviews);
                ratingRecyclerView.setAdapter(reviewAdapter);
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}