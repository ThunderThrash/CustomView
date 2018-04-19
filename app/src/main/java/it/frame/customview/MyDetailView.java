package it.frame.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by brandon on 10/9/14.
 */
public class MyDetailView extends LinearLayout {
    TextView textView;
    DetailPresenter presenter;

    public MyDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        presenter = new DetailPresenter();
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        presenter.setView(this);
        textView = findViewById(R.id.text);
        findViewById(R.id.button).setOnClickListener(v -> presenter.buttonClicked());
    }

    public void setItem(String item) {
        textView.setText(item);
    }
}
