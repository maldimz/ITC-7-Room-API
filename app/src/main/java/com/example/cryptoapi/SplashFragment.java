package com.example.cryptoapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashFragment extends Fragment {

    Animation topAnim, fadeAnim, bottomAnim;
    ImageView ivGambar;
    TextView tvJudul;
    LinearLayout llBack;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SplashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SplashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SplashFragment newInstance(String param1, String param2) {
        SplashFragment fragment = new SplashFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        topAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_anim);
        fadeAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_anim);

        llBack = view.findViewById(R.id.ll_back);
        ivGambar = view.findViewById(R.id.iv_gambar);
        tvJudul = view.findViewById(R.id.tv_judul);

        llBack.setAnimation(fadeAnim);
        ivGambar.setAnimation(bottomAnim);
        tvJudul.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MenuFragment menuFragment = new MenuFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_main, menuFragment);
                transaction.commit();
                Log.d("Loading", "run: " + "Masuk ke Menu!");
            }
        },3000);

        return view;
    }
}