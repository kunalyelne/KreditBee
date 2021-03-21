package com.kyodude.kreditbee.ViewModels;

import com.kyodude.kreditbee.Repository.Repository;
import com.kyodude.kreditbee.Model.DataModels.Album;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AlbumViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private final LiveData<List<Album>> albumsLiveData;

    @Inject public AlbumViewModel(Repository repository) {
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
