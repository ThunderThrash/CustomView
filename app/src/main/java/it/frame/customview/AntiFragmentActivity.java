package it.frame.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AntiFragmentActivity extends AppCompatActivity {

    private Container container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anti_fragment);

        container = findViewById(R.id.container);
//        container.setDisplayHomeAsUpEnabled(getSupportActionBar(),true);

        ListView listView = container.getListView();

        ListAdapter adapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,DummyContent.ITEMS);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {

            DummyContent.DummyItem dummyItem = (DummyContent.DummyItem) adapter.getItem(position);
            String item = dummyItem.content;

            container.showItem(item);
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // todo: goto back activity from here
//
//                onBackPressed();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override public void onBackPressed() {

        if (!container.onBackPressed()) {

            finish();
        }
    }

    public Container getContainer() {
        return container;
    }
}
