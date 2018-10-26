package com.krumuda.project1eksplorasiandroid;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalDataFragment extends Fragment {
    Profile profile;

    public PersonalDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profile = new Profile("Ikra", "13517106", "STEI / Informatics", "ikraduya - 082281752675");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_data, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Profile");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* Set TextInputEditText text */
        TextInputEditText nameInput = (TextInputEditText) getView().findViewById(R.id.name_input);
        nameInput.setText(profile.getName());

        TextInputEditText nimInput = (TextInputEditText) getView().findViewById(R.id.nim_input);
        nimInput.setText(profile.getNim());

        TextInputEditText facultyMajorInput = (TextInputEditText) getView().findViewById(R.id.facultymajor_input);
        facultyMajorInput.setText(profile.getFacultyMajor());

        TextInputEditText contactInput = (TextInputEditText) getView().findViewById(R.id.contact_input);
        contactInput.setText(profile.getContact());
    }
}
