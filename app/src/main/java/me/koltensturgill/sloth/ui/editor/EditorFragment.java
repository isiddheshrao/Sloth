package me.koltensturgill.sloth.ui.editor;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import me.koltensturgill.sloth.KeyboardBarAdapter;
import me.koltensturgill.sloth.R;

public class EditorFragment extends Fragment {

    private EditorViewModel mViewModel;
    ArrayList<KeyboardButton> buttons;
    private EditText editText;

    public static EditorFragment newInstance() {
        return new EditorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.editor_fragment, container, false);

        //Setup for the keyboard button bar recycler view
        EditText dummyText = (EditText) view.findViewById(R.id.et_editor);
        RecyclerView buttonBar = (RecyclerView) view.findViewById(R.id.rvKeyboardBar);
        buttons = KeyboardButton.createButtonList();
        KeyboardBarAdapter rvAdapter = new KeyboardBarAdapter(buttons, dummyText);
        buttonBar.setAdapter(rvAdapter);
        buttonBar.setLayoutManager(new LinearLayoutManager(getContext(),
                                   LinearLayoutManager.HORIZONTAL,false));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.et_editor);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditorViewModel.class);
        // TODO: Use the ViewModel
    }



}
