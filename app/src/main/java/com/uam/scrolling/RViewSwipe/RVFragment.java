package com.uam.scrolling.RViewSwipe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tubb.smrv.SwipeMenuRecyclerView;
import com.uam.scrolling.R;

import java.util.ArrayList;

public class RVFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
//    private RecyclerView recyclerView;
    protected SwipeMenuRecyclerView recyclerView;
    private RVAdapter adapter;
    private ArrayList<RVModel> listContentArr= new ArrayList<>();
    private View rootView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RVFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RVFragment newInstance(String param1, String param2) {
        RVFragment fragment = new RVFragment();
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
        rootView = inflater.inflate(R.layout.fragment_rv, container, false);

        recyclerView = (SwipeMenuRecyclerView) rootView.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RVAdapter(getActivity());
        initViews();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void initViews(){
        listContentArr.add(new RVModel("02BW01803","12-01-2017","Off Highway Trucks 789C", 90));
        listContentArr.add(new RVModel("0B1P06084","12-02-2017","Articulated Trucks 740", (float) 85.5));
        listContentArr.add(new RVModel("0DFM00849","12-03-2017","Hydraulic Excavators 320D2", 70));

        adapter.setListContent(listContentArr);
        recyclerView.setAdapter(adapter);
    }
}
