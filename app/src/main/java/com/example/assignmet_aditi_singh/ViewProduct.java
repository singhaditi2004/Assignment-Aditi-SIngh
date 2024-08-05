package com.example.assignmet_aditi_singh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProduct extends AppCompatActivity implements ProductAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_view_product);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiServices apiService = RetrofitClient.getRetrofitInstance().create(ApiServices.class);
        Call<ProductResponse> call = apiService.getProducts();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful()) {
                    ProductResponse productResponse = response.body();
                    if (productResponse != null) {
                        List<Product> products = productResponse.getProducts();
                        for (Product product : products) {
                            Log.d("ViewProduct", "Product: " + product.getTitle() + ", Image: " + product.getFirstImage());
                        }
                        productAdapter = new ProductAdapter(products, ViewProduct.this);
                        recyclerView.setAdapter(productAdapter);
                    } else {
                        Log.d("ViewProduct", "ProductResponse is null");
                    }
                } else {
                    Log.d("ViewProduct", "Response failed: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(ViewProduct.this, "Failed to load products", Toast.LENGTH_SHORT).show();
                Log.e("ProductListActivity", "onFailure: " + t.getMessage());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onItemClick(Product product) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}