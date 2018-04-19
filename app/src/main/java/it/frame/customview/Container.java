package it.frame.customview;

import android.support.v7.app.ActionBar;
import android.widget.ListView;

/**
 * Created by brandon on 10/9/14.
 */
public interface Container {
    public ListView getListView();
    public void showItem(String item);
    public boolean onBackPressed();
    public void setDisplayHomeAsUpEnabled(ActionBar supportActionBar, boolean showHomeAsUp);
}
