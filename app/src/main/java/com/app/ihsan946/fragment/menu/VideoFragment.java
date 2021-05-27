package com.app.ihsan946.fragment.menu;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 24 Mei 2021
//
//

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.adapter.AdapterMusikFav;
import com.app.ihsan946.adapter.AdapterVideo;
import com.app.ihsan946.akb_uts.R;
import com.app.ihsan946.model.modelDaily;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
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

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        modelDaily model = new modelDaily();

        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView4 = view.findViewById(R.id.recycle_view4);
        final RecyclerView recyclerView5 = view.findViewById(R.id.recycle_view5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        recyclerView4.setLayoutManager(layoutManager);
        recyclerView5.setLayoutManager(layoutManager2);
        //


        //

        String[] uri_video = {
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.cleanbandit_ratherbe,
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.a7x_seizetheday,
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.simpleplan_untitled
        };
        String[] judul_video = {
                "Clean Bandit - Rather Be", "A7X - Seize The Day", "Simple Plan - Untitled"
        };
        String[] judul_lagu_fav = {
                "Simple Plan - Welcome To My Life", "The Hoobastank - Reason",
                "Kygo - Stay", "Petit Biscuit - Sunset Lover", "Passenger - Let Her Go",
                "Peterpan - Kukatakan Dengan Indah", "Peterpan - Kisah Cintaku",
                "Chriye - Menunggumu", "Ed Sheeran - Photograph", "The Chainsmokers - All We Know",
                "Andmesh Kamaleng - Cinta Luar Biasa"
        };

        model.setUri_video(uri_video);
        model.setJudul_video(judul_video);
        model.setJudul_musik_fav(judul_lagu_fav);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterVideo adapter = new AdapterVideo(fragment, model.getUri_video(), model.getJudul_video());
                final AdapterMusikFav adapter2 = new AdapterMusikFav(fragment, model.getJudul_musik_fav());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView4.setAdapter(adapter);
                        recyclerView5.setAdapter(adapter2);

                    }

                });
            }
        }).start();

        // Inflate the layout for this fragment
        return view;
    }
}