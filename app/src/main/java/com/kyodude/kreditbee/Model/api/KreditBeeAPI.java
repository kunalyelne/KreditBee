package com.kyodude.kreditbee.Model.api;

import com.kyodude.kreditbee.Model.DataModels.Album;
import com.kyodude.kreditbee.Model.DataModels.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KreditBeeAPI {
    @GET("albums")
    Call<List<Album>> getAlbums();
    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("album")int id);
}
