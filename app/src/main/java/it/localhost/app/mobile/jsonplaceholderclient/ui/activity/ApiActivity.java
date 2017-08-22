package it.localhost.app.mobile.jsonplaceholderclient.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemDetailsFragment;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragment;
import it.localhost.app.mobile.jsonplaceholderclient.ui.fragment.ItemsFragmentCallback;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

public class ApiActivity extends DaggerAppCompatActivity implements ItemsFragmentCallback {

    private static final String TAG = ApiActivity.class.getSimpleName();
    private String bundleApiValue;
    @BindView(R.id.pb)
    ProgressBar progress;
    @Inject
    ItemsFragment mItemsFragment;
    @Inject
    ItemDetailsFragment mItemDetailsFragment;

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

    private void initUi() {
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
    }

    private void initFragment() {
//        Fragment itemsFragment = ItemsFragment.newInstance(bundleApiValue);
        mItemsFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragItems, mItemsFragment)
                .commit();
    }

    // FRAGMENT CALLBACK
    @Override
    public void loadDetailsFragment(Bundle bundle) {
        getSupportFragmentManager()
                .beginTransaction()
//                .replace(R.id.fragItems, ItemDetailsFragment.newInstance(bundle))
                .replace(R.id.fragItems, mItemDetailsFragment)
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
