package com.kyodude.kreditbee.ViewModels;

import com.kyodude.kreditbee.Repository.Repository;
import com.kyodude.kreditbee.api.DataModels.Album;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AlbumViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private final Repository repository = Repository.getInstance();
    private final LiveData<List<Album>> albumsLiveData;

    public AlbumViewModel() {
        super();
        albumsLiveData = repository.getAlbums();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Album>> getAlbumsLiveData() {
        return albumsLiveData;
    }
}
