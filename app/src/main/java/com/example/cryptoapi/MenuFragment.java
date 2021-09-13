package com.example.cryptoapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cryptoapi.database.Dao;
import com.example.cryptoapi.database.Database;
import com.example.cryptoapi.database.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    boolean isScrolling = false, halMax = false;
    int currentItem, totalItem, scrollItems, page=10, first, max;
    LinearLayoutManager manager;
    ProgressBar progressBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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

        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        Database databaseROOM = Database.getInstance(getActivity());
        Dao dao = databaseROOM.dao();
        RecyclerView.Adapter adapter;

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        List<Entity> entities = dao.getAllData();

        max=entities.size();
        ArrayList<Entity> dump = new ArrayList<>();

        for (int i=0;i<page;i++){
            dump.add(entities.get(i));
        }

        progressBar = view.findViewById(R.id.pb_rc);
        RecyclerView recyclerView = view.findViewById(R.id.rc_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        adapter = new Adapter(getActivity(), dump);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = manager.getChildCount();
                totalItem = manager.getItemCount();
                scrollItems = manager.findFirstVisibleItemPosition();
                Log.d("Check current", String.valueOf(currentItem));
                Log.d("Check totalItem", String.valueOf(totalItem));
                Log.d("Check scroll", String.valueOf(scrollItems));
                if(isScrolling && (currentItem + scrollItems == totalItem) && page <100){
                    isScrolling = false;
                    progressBar.setVisibility(getView().VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            first=page;
                            page=page+10;
                            for(int i=first;i<page;i++){
                                dump.add(entities.get(i));
                                adapter.notifyDataSetChanged();
                                progressBar.setVisibility(getView().GONE);
                            }
                        }
                    },1000);
                }else if((currentItem + scrollItems == 100) && !halMax){
                    halMax = true;
                    Toast.makeText(getActivity(), "Halaman Max!", Toast.LENGTH_SHORT).show();
                }else if(currentItem + scrollItems != 100)
                    halMax = false;
            }


        });


        return view;
    }

}