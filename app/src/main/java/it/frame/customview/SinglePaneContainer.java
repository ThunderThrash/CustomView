package it.frame.customview;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * Created by brandon on 10/9/14.
 */
public class SinglePaneContainer extends FrameLayout implements Container {


    private ListView listView;

    public SinglePaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ListView) getChildAt(0);
    }

    public boolean onBackPressed() {
        if (!listViewAttached()) {
            removeViewAt(0);
            addView(listView);

            return true;
        }
        return false;
    }

    @Override
    public ListView getListView() {
        return listView;
    }

    @Override public void showItem(String item) {
        if (listViewAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail, this);
        }
        MyDetailView detailView = (MyDetailView) getChildAt(0);
        detailView.setItem(item);
    }

    @Override
    public void setDisplayHomeAsUpEnabled(ActionBar supportActionBar, boolean showHomeAsUp) {

//        if( showHomeAsUp || supportActionBar == null) return;
//
//        if (!listViewAttached()) {
//            supportActionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    private boolean listViewAttached() {
        return listView.getParent() != null;
    }
}