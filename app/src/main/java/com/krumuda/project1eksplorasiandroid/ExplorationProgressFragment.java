package com.krumuda.project1eksplorasiandroid;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExplorationProgressFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "com.krumuda.project1eksplorasiandroid.MESSAGE";
    public static final String EXTRA_TITLE = "com.krumuda.project1eksplorasiandroid.EXTRA_TITLE";
    static final Integer TOPIC = 0;
    static final Integer PROJECT = 1;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;

    public ExplorationProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exploration_progress, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Exploration Progress");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expandableListView = (ExpandableListView) getView().findViewById(R.id.expandable_listview);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
    }

    // Setting headers and childs to expandable listview
    void setItems(){
        // Array list for header
        final ArrayList<String> header = new ArrayList<String>(
                Arrays.asList("User Interface", "User Input", "Multiscreen Apps", "Project 1", "Networking", "Data Storage", "Firebase", "Project 2")
        );
        ArrayList<String> subHeader = new ArrayList<String>(
                Arrays.asList("01/09/18 - 16/09/18", "17/09/18 - 30/09/18", "01/10/18 - 14/10/18", "15/10/18 - 28/10/18", "29/10/18 - 11/11/18", "12/11/18 - 25/11/18", "26/11/18 - 09/12/18", "10/12/18 - 31/12/18")
        );
        final ArrayList<Integer> listType = new ArrayList<Integer>(
                Arrays.asList(TOPIC, TOPIC, TOPIC, PROJECT, TOPIC, TOPIC, TOPIC, PROJECT)
        );
        final ArrayList<String> description = new ArrayList<String>(
                Arrays.asList("","","","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fermentum, nisl sed molestie bibendum, lectus justo cursus purus, a pharetra nibh erat in purus. Aenean velit ipsum, pellentesque a neque eu, euismod accumsan nisi. Donec vel augue quis dui tincidunt consequat. Integer egestas non magna ac suscipit. Sed lobortis diam consectetur nibh accumsan ullamcorper. Proin turpis libero, viverra ultrices risus et, ultricies euismod nisl. Pellentesque eget ipsum nec dolor eleifend consectetur. Duis placerat maximus mi.",
                        "","","","Sed aliquam venenatis lectus, a semper nunc commodo gravida. Proin euismod velit ligula, eget bibendum neque tempor ac. Duis consequat suscipit placerat. Curabitur et lectus id erat maximus lacinia a suscipit leo. Morbi eget tristique odio. Suspendisse varius sollicitudin neque, vitae ullamcorper eros porttitor nec. Suspendisse ac ex ultricies lorem sodales euismod. Curabitur in volutpat eros, quis maximus tellus. Integer interdum nunc erat, vel porttitor nibh rutrum a. Vivamus id iaculis risus. Fusce auctor diam at nibh dapibus blandit. Nam imperdiet sed orci in vestibulum. Mauris ut luctus felis. Proin diam tortor, egestas congue vulputate eu, rhoncus nec velit.")
        );

        // Array list for child items
        List<String>[] childList = new ArrayList[8];
        childList[0] = new ArrayList<String>(
                Arrays.asList("Building Layout Part 1", "Building Layout Part 2", "Practice Set Building Layout")
        );
        childList[1] = new ArrayList<String>(
                Arrays.asList("Making an App Interactive Part 1", "Making an App Interactive Part 2", "Practice Set Making an App Interactive", "Object Oriented Part 1", "Object Oriented Part 2")
        );
        childList[2] = new ArrayList<String>(
                Arrays.asList("Intent dan Aktivitas", "Data, Loop, dan Kelas Khusus", "Gambar dan Mempercantik Visual", "Audio dan Libraries", "Fragmen")
        );
        childList[3] = new ArrayList<String>(
                Arrays.asList("View Description")
        );
        childList[4] = new ArrayList<String>(
                Arrays.asList("Parsing JSON", "Jaringan HTTP", "Thread dan Paralellisme", "Preferensi")
        );
        childList[5] = new ArrayList<String>(
                Arrays.asList("Pelajaran 1", "Pelajaran 2", "Pelajaran 3", "Pelajaran 4")
        );
        childList[6] = new ArrayList<String>(
                Arrays.asList("Saturday", "Sunday", "Monday")
        );
        childList[7] = new ArrayList<String>(
                Arrays.asList("View Description")
        );

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding header and childs to hash map
        for (int i=0; i<header.size(); i++) {
            hashMap.put(header.get(i), childList[i]);
        }

        adapter = new ExpandableListAdapter(getActivity(), header, subHeader, listType, hashMap);
        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(TAG, "onChildClick: " + childPosition);
                if (listType.get(groupPosition) == PROJECT) {
                    Intent i = new Intent(getActivity(), ProjectDescriptionActivity.class);
                    i.putExtra(EXTRA_MESSAGE, description.get(groupPosition));
                    i.putExtra(EXTRA_TITLE, header.get(groupPosition));
                    startActivity(i);
                }
                // auto generated
                return false;
            }
        });
    }
}
