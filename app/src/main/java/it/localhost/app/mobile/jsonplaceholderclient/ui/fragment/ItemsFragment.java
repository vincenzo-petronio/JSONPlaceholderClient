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
import it.localhost.app.mobile.jsonplaceholderclient.JPCApp;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.dagger.modules.ServiceModule;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import it.localhost.app.mobile.jsonplaceholderclient.ui.activity.ApiView;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.OnItemClickListener;
import it.localhost.app.mobile.jsonplaceholderclient.ui.adapter.PostsAdapter;
import it.localhost.app.mobile.jsonplaceholderclient.ui.dagger.modules.ApiModule;
import it.localhost.app.mobile.jsonplaceholderclient.ui.presenter.ApiPresenter;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

/**
 *
 */
public class ItemsFragment extends Fragment implements ApiView {

    private static final String TAG = ItemsFragment.class.getSimpleName();
    private ItemsFragmentCallback mListener;
    private String bundleApiValue;
    @Inject
    ApiPresenter presenter;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;


    public ItemsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param String
     * @return A new instance of fragment ItemsFragment.
     */
    public static ItemsFragment newInstance(String param) {
        Log.i(TAG, param);
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
            Log.i(TAG, bundleApiValue);
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
        ((JPCApp) getActivity().getApplication()).getAppComponent().plus(new ApiModule(this), new ServiceModule()).inject(this);
    }

    private void initPresenter() {
        presenter.requestItems();
    }

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(View itemView, int position) {
            Log.v(TAG, "OnItemClickListener: " + Integer.toString(position));

//            itemView.

//                Post post = ((List<Post>)items).get(position);

            // Passare attraverso il Presenter per fare logica!
//            presenter.onSelectedItem(Integer.toString(position));

        }
    };

    // VIEW METHOD
    @Override
    public void setItems(final List<?> items) {
        PostsAdapter adapter = new PostsAdapter((List<Post>) items, getContext());
        adapter.setOnItemClickListener(mOnItemClickListener);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showProgress(boolean show) {
        // Essendo un Fragment passo il controllo all'Activity, così uso una sola ProgressBar
        // per tutto. Altrimenti è possibile inserire una progress in ogni fragment e controllarla
        // direttamente qui.
        mListener.showProgress(show);
    }

    @Override
    public void launchNextView() {
        // Essendo un Fragment passo il controllo all'Activity attraverso la Callback
        mListener.loadDetailsFragment();
    }

}
