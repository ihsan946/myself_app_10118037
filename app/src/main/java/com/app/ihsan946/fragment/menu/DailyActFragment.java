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

import com.app.ihsan946.adapter.AdapterFLDaily;
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
        final FragmentActivity fragment2 = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.recycle_view1);
        final RecyclerView recyclerView2 = view.findViewById(R.id.recycle_view2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment2, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);
        modelDaily model = new modelDaily();


        //daily activity
        String[] subjects = {
                "Bersepeda", "Jogging", "Main Game", "Belajar"
        };
        int[] subjects2 = {R.drawable.daily_1, R.drawable.daily_2, R.drawable.daily_3, R.drawable.daily_4};
        String[] subjects3 = {"Tidak terlalu sering, kalo lagi pengen aja", "Kalo ada temen ngajak", "Kalo lagi Bosen",
                "Kalo lagi ada tugas dan lagi semangat mencari hal baru"};

        model.setSubjects(subjects);
        model.setSubjects2(subjects2);
        model.setSubjects3(subjects3);

        //friendlist
        String[] nama = {
                "Tassyakur Pasya", "Fatahilla Satria Bima Seno", "Dian Rosa Pratama"
        };
        int[] foto_profile = {
                R.drawable.profile_pasya, R.drawable.profile_fath, R.drawable.profile_dian
        };
        model.setNama_friendlist(nama);
        model.setFoto_profile(foto_profile);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterRVDaily adapter = new AdapterRVDaily(fragment, model.getSubjects(), model.getSubjects2(), model.getSubjects3());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);


                    }

                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterFLDaily adapter = new AdapterFLDaily(fragment, model.getNama_friendlist(), model.getFoto_profile());
                fragment2.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView2.setAdapter(adapter);
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