package it.localhost.app.mobile.jsonplaceholderclient.ui.fragment;


import com.google.gson.Gson;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.PostAdapter;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

/**
 *
 */
public class ItemDetailsFragment extends Fragment implements ApiView {

    private static final String TAG = ItemDetailsFragment.class.getSimpleName();
    private ItemsFragmentCallback mListener;
    private String bundleApiValue, bundleItem;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;

    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bundle Bundle
     * @return A new instance of fragment ItemDetailsFragment.
     */
    public static ItemDetailsFragment newInstance(Bundle bundle) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        fragment.setArguments(bundle);
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
            bundleItem = getArguments().getString(Constants.BUNDLE_KEY_ITEM);
            Log.v(TAG, bundleApiValue);
            Log.v(TAG, bundleItem);
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);

            // TODO exit/turn back
        }

        // VIEW
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        initPresenter();
    }

    @Override
    public void onDetach() {
        Log.v(TAG, "onDetach");
        super.onDetach();
        mListener = null;
    }

    private void initDependencyInjector() {
        // not used
    }

    private void initPresenter() {
        // not used

        // In questo caso il Presenter è l'Adapter direttamente.
        Post post = new Gson().fromJson(bundleItem, Post.class);
        setItem(post);
    }

    // VIEW METHOD
    @Override
    public void setItems(List<?> items) {
        // not used
    }

    @Override
    public void setItem(Object item) {
        PostAdapter adapter = new PostAdapter((Post) item);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showMessage(String message) {
        // TODO
    }

    @Override
    public void showProgress(boolean show) {
        mListener.showProgress(show);
    }

    @Override
    public void launchNextView(Bundle bundle) {
        // not used
    }
}
