package com.example.traore.newsapp;

        import android.content.Intent;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements ItemsListFragment.OnListItemSelectedListener{

    private boolean isTwoPane ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        determinePaneLayout();
    }

    // Handles the event when the fragment list item is selected
    @Override
    public void onItemSelected(Item item) {

        if (isTwoPane) { // single activity with list and detail
            // Replace framelayout with new detail fragment
            ItemDetailFragment fragmentItem = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        } else { // go to separate activity
            // launch detail activity using intent
            Intent intent = new Intent(this, ItemDetailActivity.class);
            // Embed the serialized item
            intent.putExtra("item", item);
            startActivity(intent);
        }
    }

    private void determinePaneLayout() {
        FrameLayout fragmentItemDetail = findViewById(R.id.flDetailContainer);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
            isTwoPane = true;
            ItemsListFragment fragmentItemsList =(ItemsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentItemsList);
            fragmentItemsList.setActivateOnItemClick(true);
        }
    }


}
