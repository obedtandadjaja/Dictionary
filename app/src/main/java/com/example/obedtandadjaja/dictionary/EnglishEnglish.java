package com.example.obedtandadjaja.dictionary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by obedtandadjaja on 8/17/15.
 */
public class EnglishEnglish extends Fragment{

    private EditText word_search;
    private Button search;
    private TextView translation_text;
    private TranslationDataSource translation_data_source;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.english_english, container, false);

        word_search = (EditText) rootView.findViewById(R.id.editText);
        translation_text = (TextView) rootView.findViewById(R.id.textView);
        translation_text.setMovementMethod(new ScrollingMovementMethod());

        translation_data_source = new TranslationDataSource(getActivity());

        search = (Button) rootView.findViewById(R.id.button);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translation_text.setText("");

                ArrayList<Translation> translation_array_long = translation_data_source.getEngEngTranslation(word_search.getText().toString());

                if(translation_array_long.size() > 0)
                {
                    translation_text.append(Html.fromHtml("<p><b>Source: Wikipedia</b></p>"));

                    for(int i = 0; i < translation_array_long.size(); i++)
                    {
                        translation_text.append(Html.fromHtml("<p>" + translation_array_long.get(i).getTranslation() + "</p>"));
                    }

                    translation_text.append(Html.fromHtml("<br/><br/>"));
                }
                else
                {
                    translation_text.append("Word is not Found!");
                }
            }
        });
        return rootView;
    }
}
