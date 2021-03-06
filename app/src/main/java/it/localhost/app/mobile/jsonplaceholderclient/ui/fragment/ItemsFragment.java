package it.localhost.app.mobile.jsonplaceholderclient.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.dagger.modules.ServiceModule;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Comment;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.CommentsAdapter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.OnItemClickListener;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.PostsAdapter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.ApiModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

import static butterknife.ButterKnife.bind;

/**
 *
 */
public class ItemsFragment extends Fragment implements ApiView {

    private static final String TAG = ItemsFragment.class.getSimpleName();
    private ItemsFragmentCallback mListener;
    private String bundleApiValue;
    private Unbinder mUnbinder;
    @Inject
    ApiPresenter presenter;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;

    // TODO
    // Serve un Factory per ottenere un adapter generico ed evitare di usare switch ovunque,
    // oltre che l'injection di diversi oggetti!
    @Inject
    PostsAdapter mPostsAdapter;
    @Inject
    CommentsAdapter mCommentsAdapter;

    public ItemsFragment() {
        setRetainInstance(true);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param String
     * @return A new instance of fragment ItemsFragment.
     */
    public static ItemsFragment newInstance(String param) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle args = new Bundle();
        args.putString(Constants.BUNDLE_KEY_API, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        Log.v(TAG, "onAttach");
        super.onAttach(context);

        if (context instanceof ItemsFragmentCallback) {
            mListener = (ItemsFragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        initDependencyInjector();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView");

        // BUNDLE
        try {
            bundleApiValue = getArguments().getString(Constants.BUNDLE_KEY_API);
            Log.v(TAG, bundleApiValue);
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);

            // TODO exit/turn back
        }

        // VIEW
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        initUi();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

//        if (savedInstanceState == null) {
        initPresenter();
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onDetach() {
        Log.v(TAG, "onDetach");
        super.onDetach();
        mListener = null;
        presenter.finish();
    }

    private void initDependencyInjector() {
        ((JPCApp) getActivity().getApplication()).getAppComponent().plus(new ApiModule(this), new ServiceModule()).inject(this);
    }

    private void initUi() {

        switch (bundleApiValue) {
            case "posts":
                mPostsAdapter.setOnItemClickListener(mOnItemClickListener);
                rvItems.setAdapter(mPostsAdapter);
                rvItems.setLayoutManager(new LinearLayoutManager(getContext()));
                break;
            case "comments":
                mCommentsAdapter.setOnItemClickListener(mOnItemClickListener);
                rvItems.setAdapter(mCommentsAdapter);
                rvItems.setLayoutManager(new LinearLayoutManager(getContext()));
                break;
        }
    }

    private void initPresenter() {
        presenter.requestItems(bundleApiValue);
    }

    /**
     * Listener tra Adapter e Fragment
     */
    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(Bundle bundle) {
//            Log.v(TAG, "OnItemClickListener: " + Integer.toString(((Post)bundle).getId()));

            launchNextView(bundle);

            // Passare attraverso il Presenter per fare logica!
//            presenter.onSelectedItem(Integer.toString(position));
        }
    };

    // VIEW METHOD
    @Override
    public void setItems(final List<?> items) {
        switch (bundleApiValue) {
            case "posts":
                mPostsAdapter.updateCollection((List<Post>) items);
                break;
            case "comments":
                mCommentsAdapter.updateCollection((List<Comment>) items);
                break;
        }
    }

    @Override
    public void setItem(Object item) {
        // not used
    }

    @Override
    public void showMessage(String message) {
        // TODO
    }

    @Override
    public void showProgress(boolean show) {
        // Essendo un Fragment passo il controllo all'Activity, così uso una sola ProgressBar
        // per tutto. Altrimenti è possibile inserire una progress in ogni fragment e controllarla
        // direttamente qui.
        mListener.showProgress(show);
    }

    @Override
    public void launchNextView(Bundle bundle) {
        // Essendo un Fragment passo il controllo all'Activity attraverso la Callback
        bundle.putString(Constants.BUNDLE_KEY_API, bundleApiValue);
        mListener.loadDetailsFragment(bundle);
    }

}
