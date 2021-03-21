package com.kyodude.kreditbee.ViewModels;

import com.kyodude.kreditbee.Repository.Repository;
import com.kyodude.kreditbee.api.DataModels.Photo;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PageViewModel extends ViewModel {

    private LiveData<List<Photo>> photosLiveData;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final Repository repository;

    @Inject public PageViewModel(Repository repository) {
        super();
        this.repository = repository;
        isLoading.setValue(true);
    }
    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setAlbumId(int id) {
        photosLiveData = repository.getPhotos(id);
    }

    public LiveData<List<Photo>> getPhotosLiveData() {
        return photosLiveData;
    }
}