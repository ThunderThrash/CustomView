package it.frame.customview;

import android.widget.Toast;

/**
 * Created by brandon on 10/9/14.
 */
public class DetailPresenter {

    private MyDetailView view;

    public void setView(MyDetailView view) {
        this.view = view;
    }

    public void buttonClicked() {
        Toast.makeText(view.getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
    }
}
