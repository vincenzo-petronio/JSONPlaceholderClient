package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;

/**
 *
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private static final String TAG = PostAdapter.class.getSimpleName();
    private Post post;

    /**
     * Costruttore
     *
     * @param post Post
     */
    public PostAdapter(Post post) {
        this.post = post;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvUserId)
        TextView tvUserId;
        @BindView(R.id.tvId)
        TextView tvId;
        @BindView(R.id.tvBody)
        TextView tvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.fragment_item_details_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //GUARD-CLAUSE
        if (post == null) {
            Log.e(TAG, "Post NULL!!!");
            return;
        }

        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());
        try {
            holder.tvUserId.setText(String.format(Locale.getDefault(), "%d", post.getUserId()));
            holder.tvId.setText(String.format(Locale.getDefault(), "%d", post.getId()));
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
