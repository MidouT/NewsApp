package com.example.traore.newsapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailFragment extends Fragment {

    private Item item ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (Item) getArguments().getSerializable("item");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvBody = view.findViewById(R.id.tvBody);
        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        // Return view
        return view;
    }


    // ItemDetailFragment.newInstance(item)
    public static ItemDetailFragment newInstance(Item item) {
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        itemDetailFragment.setArguments(args);
        return itemDetailFragment;
    }
}
