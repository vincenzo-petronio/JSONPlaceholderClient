package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.MainModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    MainPresenter presenter;
    @BindView(R.id.lvItems)
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        initUi();
        initDependencyInjector();
        presenter.loadData();
    }

    private void initUi() {
        // VIEW
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void initDependencyInjector() {
        ((JPCApp) getApplication()).getAppComponent().plus(new MainModule(this)).inject(this);
    }

    /**
     * @param items
     */
    public void setData(List<String> items) {
        lvItems.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }
}
