package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import dagger.android.AndroidInjection;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.MainModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.MainPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.util.NotificationFactory;

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
        initDependencyInjector();

        super.onCreate(savedInstanceState);

        initUi();
        initPresenter();
    }

    private void initUi() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void initDependencyInjector() {
//        ((JPCApp) getApplication()).getAppComponent().plus(new MainModule(this)).inject(this);
        AndroidInjection.inject(this);
    }

    private void initPresenter() {
        presenter.requestItems();
    }

    @OnItemClick(R.id.lvItems)
    public void onItemsClick(int position) {
        String s = (String) lvItems.getItemAtPosition(position);
        presenter.onSelectedItem(s.toLowerCase());
    }

    @Override
    public void setItems(List<String> items) {
        lvItems.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        NotificationFactory.createToastLongNotification(this, message).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progress.setVisibility(View.VISIBLE);
        } else {
            progress.setVisibility(View.GONE);
        }
    }

    @Override
    public void launchNextActivity(Activity activity, Bundle bundle) {
        startActivity(new Intent(this, activity.getClass()).putExtras(bundle));
    }
}
