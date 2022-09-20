package uz.exemple.less58_twitterui_multiview_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import uz.exemple.less58_twitterui_multiview_java.R;
import uz.exemple.less58_twitterui_multiview_java.model.Story;


public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Story> items;

    public StoryAdapter(Context context, ArrayList<Story> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_story,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story item = items.get(position);
        holder.iv_profile.setImageResource(item.getProfile());
        holder.tv_fullname.setText(item.getFullname());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        TextView tv_fullname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
}
