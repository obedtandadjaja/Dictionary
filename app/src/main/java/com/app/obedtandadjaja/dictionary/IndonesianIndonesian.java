package com.app.obedtandadjaja.dictionary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.obedtandadjaja.dictionary.R;

/**
 * Created by obedtandadjaja on 8/17/15.
 */
public class IndonesianIndonesian extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.indonesian_indonesian, container, false);

        return rootView;
    }
}
