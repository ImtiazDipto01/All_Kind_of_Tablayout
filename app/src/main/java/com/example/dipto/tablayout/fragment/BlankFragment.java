package com.example.dipto.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dipto.tablayout.R;

import java.util.HashMap;

public class BlankFragment extends Fragment {

    String id = "" ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Bundle bundle = this.getArguments();
            if (bundle != null) {
                id = this.getArguments().getString("id");
                Log.d("TAB_ID:", id) ;
            }
        }
        else{
            // fragment is no longer visible
        }
    }
}
