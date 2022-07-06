package com.example.thinkingaboutit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {

    MainActivity mainActivity;
    ArrayList<Article> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        data = mainActivity.data;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mainActivity.fm.getBackStackEntryCount()==0) {
            mainActivity.appnameTextview.setText(R.string.app_name);
        }
    }
}
