package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import com.google.gson.Gson;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

/**
 *
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private static final String TAG = PostsAdapter.class.getSimpleName();
    private List<Post> posts;
    private Context context;
    private static OnItemClickListener sOnItemClickListener;

    /**
     * Costruttore
     *
     * @param posts   List<Post>
     * @param context Context
     */
    public PostsAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    /**
     * @return Context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param onItemClickListener OnItemClickListener
     */
    public static void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        sOnItemClickListener = onItemClickListener;
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvSubTitle)
        TextView tvSubTitle;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            // LISTENER
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Post post = posts.get(getLayoutPosition());

                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.BUNDLE_KEY_ITEM, new Gson().toJson(post));

                    sOnItemClickListener.onItemClick(bundle);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.fragment_items_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = posts.get(position);

        //GUARD-CLAUSE
        if (post == null) {
            Log.e(TAG, "Post NULL!!!");
            return;
        }

        holder.tvTitle.setText(post.getTitle());
        try {
            holder.tvSubTitle.setText(String.format(Locale.getDefault(), "%d", post.getUserId()));
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);
        }

    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }

}
