package com.example.giselamercade.bykesharing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giselamercade.bykesharing.bike.BikeContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BykeSharingListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    List<BikeContent.Bike> bikes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BykeSharingListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BykeSharingListFragment newInstance(int columnCount) {
        BykeSharingListFragment fragment = new BykeSharingListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            if(bikes == null){
                bikes = new ArrayList<>();
            }
            BikeContent.Bike bike = new BikeContent.Bike(bundle.getString("idBike"), bundle.getString("detailBike"), "");
            bikes.add(bike);


        }


//
//        Intent intent = getIntent();
//        String action = intent.getAction();
//        String type = intent.getType();
//
//        String idBike = null;
//        String newBike = null;
//
//        if (Intent.ACTION_SEND.equals(action) && type != null) {
//            if ("text/plain".equals(type)) {
//
//                String sharedText = intent.getStringExtra("id");
//                if (sharedText != null) {
//
//                    idBike = sharedText;
//                }
//                sharedText = intent.getStringExtra("detail");
//                if (sharedText != null) {
//
//                    newBike = sharedText;
//                }
//
//
//            }
//
//            if(idBike != null && newBike != null){
//                BikeContent.Bike bike = new BikeContent.Bike(idBike,newBike, "");
//
//                ItemFragment itemFragment = (ItemFragment)
//                        getFragmentManager().findFragmentById(R.id.article_fragment);
//
//                itemFragment.newBike(bike);
//            }
 //       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bykesharinglistfragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }


            /////////
            if(bikes == null){
                bikes = new ArrayList<>();
            }


            bikes.add(new BikeContent.Bike("Bike1", " First Bike", ""));
            bikes.add(new BikeContent.Bike("Bike2", " Second Bike", ""));
            bikes.add(new BikeContent.Bike("Bike3", " Third Bike", ""));
            bikes.add(new BikeContent.Bike("Bike4", " Fourth Bike", ""));
            bikes.add(new BikeContent.Bike("Bike5", " Fifth Bike", ""));
            bikes.add(new BikeContent.Bike("Bike6", " Sixth Bike", ""));



          //  recyclerView.setAdapter(new MyItemRecyclerViewAdapter(bikes, mListener));
            recyclerView.setAdapter(new MyBykeSharingListFragmentRecyclerViewAdapter(bikes, mListener));
        }
        return view;
    }

    public void addNewBike(BikeContent.Bike newBike){
        if(bikes == null){
            bikes = new ArrayList<>();
        }
        bikes.add(newBike);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(BikeContent.Bike item);

    }

}
