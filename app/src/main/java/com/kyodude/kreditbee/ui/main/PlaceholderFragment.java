package com.kyodude.kreditbee.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import com.kyodude.kreditbee.R;
import com.kyodude.kreditbee.ViewModels.PageViewModel;
import com.kyodude.kreditbee.adapters.photoAdapter;
import com.kyodude.kreditbee.api.DataModels.Photo;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */

@AndroidEntryPoint
public class PlaceholderFragment extends Fragment {

    private static final String ARG_ALBUM_ID = "Album_Id";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ALBUM_ID, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int albumId = 1;
        if (getArguments() != null) {
            albumId = getArguments().getInt(ARG_ALBUM_ID);
        }
        pageViewModel.setAlbumId(albumId);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final RecyclerView rv_fragment = root.findViewById(R.id.rv_fragment);
        final ProgressBar progressBar = root.findViewById(R.id.Loader);
        photoAdapter adapter = new photoAdapter(getContext());
        rv_fragment.setAdapter(adapter);
        rv_fragment.setLayoutManager(new GridLayoutManager(getContext(), 3));
        pageViewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) progressBar.setVisibility(View.VISIBLE);
                else progressBar.setVisibility(View.GONE);
            }
        });
        pageViewModel.getPhotosLiveData().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(@Nullable List<Photo> s) {
                adapter.setData(s);
                pageViewModel.getIsLoading().postValue(false);
            }
        });
        return root;
    }
}