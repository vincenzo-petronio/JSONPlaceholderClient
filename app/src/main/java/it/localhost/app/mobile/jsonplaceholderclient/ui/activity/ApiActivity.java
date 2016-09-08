package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemDetailsFragment;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragment;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragmentCallback;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

public class ApiActivity extends AppCompatActivity implements ItemsFragmentCallback {

    private static final String TAG = ApiActivity.class.getSimpleName();
    private String bundleApiValue;
    @BindView(R.id.pb)
    ProgressBar progress;
    //    @Inject
//    ApiPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        // BUNDLE
        try {
            bundleApiValue = getIntent().getExtras().getString(Constants.BUNDLE_KEY_API);
            Log.i(TAG, bundleApiValue);
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);
            finish();
            return;
        }

        initDependencyInjector();
        initUi();
        if (savedInstanceState == null) {
            initFragment();
        }
        
        /**
         * Il Presenter lo utilizzo per il Fragment,
         * non per l'Activity che attualmente non ha compiti e non contiene dati.
         * Tutta la logica è nel Fragment!
         * Eventualmente si poteva utilizzare lo stesso Presenter per dialogare con l'Interactor
         * sia dall'Activity che dal Fragment figlio.
         */
//        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initDependencyInjector() {
//        ((JPCApp) getApplication()).getAppComponent().plus(new ApiModule()).inject(this);
    }

    private void initUi() {
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
    }

    private void initFragment() {
        Fragment itemsFragment = ItemsFragment.newInstance(bundleApiValue);
        itemsFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragItems, itemsFragment)
                .commit();
    }

//    private void initPresenter() {
//        presenter.requestItems();
//    }

    // FRAGMENT CALLBACK
    @Override
    public void loadDetailsFragment(Bundle bundle) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragItems, ItemDetailsFragment.newInstance(bundle))
                .commit();
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
