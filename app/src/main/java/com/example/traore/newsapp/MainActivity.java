package com.example.traore.newsapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ItemsListFragment.OnListItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Handles the event when the fragment list item is selected
    @Override
    public void onItemSelected(Item item) {
        // For phone, launch detail activity using intent
        Intent intent = new Intent(this, ItemDetailActivity.class);
        // Embed the serialized item
        intent.putExtra("item", item);
        // Start the activity
        startActivity(intent);
    }
}
