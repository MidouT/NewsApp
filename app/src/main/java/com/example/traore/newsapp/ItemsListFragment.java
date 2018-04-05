package com.example.traore.newsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemsListFragment extends Fragment {

    private ArrayAdapter<Item> adapterItems ;
    private ListView listView ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Create arrayList from Items fixtures
        ArrayList<Item> items = Item.getItems();
        //Adapter based on items
        adapterItems = new ArrayAdapter<Item>(getActivity(), android.R.layout.simple_list_item_activated_1, items);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        //Attach adapter to listView
        listView = view.findViewById(R.id.lvItems);
        listView.setAdapter(adapterItems);
        // Return view
        return view;
    }
}
