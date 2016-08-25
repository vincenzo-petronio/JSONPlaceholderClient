package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;

/**
 *
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Post> posts;
    private Context context;

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
     *
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvSubTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvSubTitle = (TextView) itemView.findViewById(R.id.tvSubTitle);
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
            return;
        }

        holder.tvTitle.setText(post.getTitle());
        holder.tvSubTitle.setText(String.format(Locale.getDefault(), "%d", post.getUserId()));
    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }


}
