package com.kyodude.kreditbee.ViewModels;

import com.kyodude.kreditbee.Repository.Repository;
import com.kyodude.kreditbee.api.DataModels.Photo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private LiveData<List<Photo>> photosLiveData;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final Repository repository = Repository.getInstance();

    public PageViewModel() {
        super();
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