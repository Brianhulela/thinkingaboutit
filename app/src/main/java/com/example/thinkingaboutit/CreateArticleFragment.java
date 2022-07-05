package com.example.thinkingaboutit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class CreateArticleFragment extends Fragment {

    MainActivity mainActivity;

    TextInputEditText titleEdittext;
    TextInputEditText articleEdittext;
    MaterialButton discardButton;
    MaterialButton addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_article_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();

        titleEdittext = view.findViewById(R.id.createTitleEdittext);
        articleEdittext = view.findViewById(R.id.createArticleEdittext);
        discardButton = view.findViewById(R.id.createDiscardButton);
        addButton = view.findViewById(R.id.createAddButton);

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0) {
                    fm.popBackStack();
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEdittext.getText().toString();
                String articleText = articleEdittext.getText().toString();
                Article article = new Article(title, articleText);
                mainActivity.data.add(article);
                mainActivity.articlesRecyclerAdapter.notifyItemInserted(mainActivity.data.size());

                FragmentManager fm = getActivity().getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0) {
                    fm.popBackStack();
                }
            }
        });
    }
}
