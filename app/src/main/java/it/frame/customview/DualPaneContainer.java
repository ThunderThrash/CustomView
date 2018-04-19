package it.frame.customview;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by brandon on 10/9/14.
 */
public class DualPaneContainer extends LinearLayout implements Container {

    private MyDetailView detailView;
    private ListView listView;

    public DualPaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ListView) getChildAt(0);
        detailView = (MyDetailView) getChildAt(1);
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void setDisplayHomeAsUpEnabled(ActionBar supportActionBar, boolean showHomeAsUp) { }


    @Override
    public ListView getListView() {
        return listView;
    }

    @Override public void showItem(String item) {
        detailView.setItem(item);
    }
}
