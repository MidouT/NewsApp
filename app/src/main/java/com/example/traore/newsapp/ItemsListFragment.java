package com.example.traore.newsapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemsListFragment extends Fragment {

    private ArrayAdapter<Item> adapterItems ;
    private ListView listView ;

    private OnListItemSelectedListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Create arrayList from Items fixtures
        ArrayList<Item> items = Item.getItems();
        //Adapter based on items
        adapterItems = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, items);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        //Attach adapter to listView
        listView = view.findViewById(R.id.lvItems);
        listView.setAdapter(adapterItems);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                // Retrieve item based on position
                Item item = adapterItems.getItem(position);
                // Fire selected listener event with item
                listener.onItemSelected(item); // <--------------
            }
        });
        // Return view
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener) {
            listener = (OnListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()+ " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }

    public interface OnListItemSelectedListener {
        void onItemSelected(Item item);
    }
}
