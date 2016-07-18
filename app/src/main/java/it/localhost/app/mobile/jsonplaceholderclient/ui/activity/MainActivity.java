package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.MainModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    MainPresenter presenter;
    @BindView(R.id.lvItems)
    ListView lvItems;
    @BindView(R.id.pb)
    ProgressBar progress;

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
//    public void setData(List<String> items) {
//        lvItems.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
//    }
    @OnItemClick(R.id.lvItems)
    public void onItemsClick(int position) {
        String s = (String) lvItems.getItemAtPosition(position);
        switch (s) {
            case "posts":
                break;
            case "comments":
                break;
            case "albums":
                break;
            case "photos":
                break;
            case "todos":
                break;
            case "users":
                break;

            default:
                break;
        }
    }

    @Override
    public void setItems(List<String> items) {
        lvItems.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progress.setVisibility(View.VISIBLE);
        } else {
            progress.setVisibility(View.GONE);
        }
    }
}
