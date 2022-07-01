package com.hasan.retofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface EczaneApi {
    @GET("health/dutyPharmacy?ilce=Meram&il=Konya")
    Call<Post> getData();
}
