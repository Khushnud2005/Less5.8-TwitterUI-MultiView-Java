package uz.exemple.less58_twitterui_multiview_java.adapter;

import static android.text.TextUtils.isEmpty;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import uz.exemple.less58_twitterui_multiview_java.R;
import uz.exemple.less58_twitterui_multiview_java.model.Post;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Post> items;

    int ITEM_DOUBLE_PHOTO_VIEW = 0;
    int ITEM_PHOTO_VIEW = 1;
    int ITEM_VIDEO_VIEW = 2;

    public PostAdapter(Context context, ArrayList<Post> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Post item = items.get(position);
        if (item.getPhoto2() != null){
            return ITEM_DOUBLE_PHOTO_VIEW;
        }else if (item.getVideo() != null){
            return ITEM_VIDEO_VIEW;
        }
        return ITEM_PHOTO_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_DOUBLE_PHOTO_VIEW){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_2xphoto_post,parent,false);
            return new DoublePhotoViewHolder(view);
        }else if(viewType == ITEM_VIDEO_VIEW){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_post,parent,false);
            return new VideoViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post,parent,false);
        return new SinglePhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post item = items.get(position);
        if (holder instanceof SinglePhotoViewHolder){
            ShapeableImageView iv_profile = ((SinglePhotoViewHolder) holder).iv_profile;
            ShapeableImageView iv_post = ((SinglePhotoViewHolder) holder).iv_post;
            TextView tv_fullname = ((SinglePhotoViewHolder) holder).tv_fullname;

            iv_profile.setImageResource(item.getProfile());
            iv_post.setImageResource(item.getPhoto());
            tv_fullname.setText(item.getFullname());
        }
        if (holder instanceof DoublePhotoViewHolder){
            ShapeableImageView iv_profile = ((DoublePhotoViewHolder) holder).iv_profile;
            ShapeableImageView iv_post = ((DoublePhotoViewHolder) holder).iv_post;
            ShapeableImageView iv_post2 = ((DoublePhotoViewHolder) holder).iv_post2;
            TextView tv_fullname = ((DoublePhotoViewHolder) holder).tv_fullname;

            iv_profile.setImageResource(item.getProfile());
            iv_post.setImageResource(item.getPhoto());
            iv_post2.setImageResource(item.getPhoto2());
            tv_fullname.setText(item.getFullname());
        }
        if (holder instanceof VideoViewHolder){
            ShapeableImageView iv_profile = ((VideoViewHolder) holder).iv_profile;
            VideoView vv_video_post = ((VideoViewHolder) holder).vv_video_post;
            TextView tv_fullname = ((VideoViewHolder) holder).tv_fullname;

            iv_profile.setImageResource(item.getProfile());
            tv_fullname.setText(item.getFullname());
            context = ((VideoViewHolder) holder).itemView.getContext();

            String path = "android.resource://uz.exemple.less58_twitterui_multiview_java/raw/"+item.getVideo();



            vv_video_post.setVideoURI(Uri.parse(path));
            MediaController mediaController = new MediaController(context);

            vv_video_post.setMediaController(mediaController);


            //vv_video_post.setOnCompletionListener(myVideoViewCompletionListener);
            //vv_video_post.setOnPreparedListener(MyVideoViewPreparedListener);
            //vv_video_post.setOnErrorListener(myVideoViewErrorListener);

            vv_video_post.requestFocus();
            vv_video_post.start();

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class SinglePhotoViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        ShapeableImageView iv_post;
        TextView tv_fullname;
        public SinglePhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_post = itemView.findViewById(R.id.iv_post);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
    public class DoublePhotoViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        ShapeableImageView iv_post;
        ShapeableImageView iv_post2;
        TextView tv_fullname;
        public DoublePhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_post = itemView.findViewById(R.id.iv_post);
            iv_post2 = itemView.findViewById(R.id.iv_post2);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
    public class VideoViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        VideoView vv_video_post;
        TextView tv_fullname;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            vv_video_post = itemView.findViewById(R.id.vv_video_post);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }

    MediaPlayer.OnCompletionListener myVideoViewCompletionListener
            = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer arg0) {
            Toast.makeText(context,
                    "End of Video",
                    Toast.LENGTH_LONG).show();
        }
    };

    MediaPlayer.OnPreparedListener MyVideoViewPreparedListener
            = new MediaPlayer.OnPreparedListener() {

        @Override
        public void onPrepared(MediaPlayer arg0) {
            Toast.makeText(context,
                    "Media file is loaded and ready to go",
                    Toast.LENGTH_LONG).show();

        }
    };

    MediaPlayer.OnErrorListener myVideoViewErrorListener
            = new MediaPlayer.OnErrorListener() {

        @Override
        public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
            Toast.makeText(context,
                    "Error!!!",
                    Toast.LENGTH_LONG).show();
            return true;
        }
    };
}
