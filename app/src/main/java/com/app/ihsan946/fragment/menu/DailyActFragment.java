package com.app.ihsan946.fragment.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.adapter.AdapterRVDaily;
import com.app.ihsan946.akb_uts.R;
import com.app.ihsan946.model.modelDaily;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyActFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyActFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DailyActFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyActFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyActFragment newInstance(String param1, String param2) {
        DailyActFragment fragment = new DailyActFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_daily_act, container, false);
        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.recycle_view1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        modelDaily model = new modelDaily();


        //
        String[] subjects = {
                "Bersepeda", "Jogging", "Main Game", "Belajar"
        };
        int[] subjects2 = {R.drawable.daily_1, R.drawable.daily_2, R.drawable.daily_3, R.drawable.daily_4};
        model.setSubjects(subjects);
        model.setSubjects2(subjects2);
        //

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterRVDaily adapter = new AdapterRVDaily(model.getSubjects(), model.getSubjects2(), fragment);
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }

                });
            }
        }).start();

        // Inflate the layout for this fragment
        return view;
    }


    //

    //

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Daily Activity");
    }

}