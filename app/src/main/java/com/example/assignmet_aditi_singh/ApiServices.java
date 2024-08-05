package com.example.assignmet_aditi_singh;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiServices {
    @GET("products")
    Call<ProductResponse> getProducts();
}
