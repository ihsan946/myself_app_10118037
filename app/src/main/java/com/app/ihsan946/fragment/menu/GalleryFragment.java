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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.adapter.AdapterGallery;
import com.app.ihsan946.akb_uts.R;
import com.app.ihsan946.model.modelDaily;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        final View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView3 = view.findViewById(R.id.recycle_view3);
        recyclerView3.setLayoutManager(new GridLayoutManager(fragment, 2));
        modelDaily model = new modelDaily();

        //gallery
        int[] gambar_gallery = {
                R.drawable.gallery_1, R.drawable.gallery_2, R.drawable.gallery_3, R.drawable.gallery_4,
                R.drawable.gallery_5, R.drawable.gallery_6, R.drawable.gallery_7, R.drawable.gallery_8,
                R.drawable.gallery_9, R.drawable.gallery_10, R.drawable.gallery_11, R.drawable.gallery_12
        };
        model.setFoto_gallery(gambar_gallery);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterGallery adapter = new AdapterGallery(fragment, model.getFoto_gallery());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView3.setAdapter(adapter);
                    }

                });
            }
        }).start();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Gallery");
    }
}