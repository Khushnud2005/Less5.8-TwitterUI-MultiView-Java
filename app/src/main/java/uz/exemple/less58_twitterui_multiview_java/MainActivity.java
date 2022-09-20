package uz.exemple.less58_twitterui_multiview_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uz.exemple.less58_twitterui_multiview_java.adapter.PostAdapter;
import uz.exemple.less58_twitterui_multiview_java.adapter.StoryAdapter;
import uz.exemple.less58_twitterui_multiview_java.model.Post;
import uz.exemple.less58_twitterui_multiview_java.model.Story;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerStory;
    RecyclerView recyclerFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        recyclerStory = findViewById(R.id.recyclerStory);
        recyclerStory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerFeed = findViewById(R.id.recyclerFeed);
        recyclerFeed.setLayoutManager(new GridLayoutManager(this, 1));

        refreshStoryAdapter(getAllStories());
        refreshFeedAdapter(getAllFeeds());
    }

    void refreshStoryAdapter(ArrayList<Story> stories) {
        StoryAdapter adapter = new StoryAdapter(this, stories);
        recyclerStory.setAdapter(adapter);
    }

    void refreshFeedAdapter(ArrayList<Post> posts) {
        PostAdapter adapter = new PostAdapter(this, posts);
        recyclerFeed.setAdapter(adapter);
    }

    ArrayList<Story> getAllStories() {
        ArrayList<Story> stories = new ArrayList<Story>();
        stories.add(new Story(R.drawable.profile1, "Queen"));
        stories.add(new Story(R.drawable.profile2, "Farkhod"));
        stories.add(new Story(R.drawable.profile3, "Xushnudbek"));
        stories.add(new Story(R.drawable.profile4, "Moonlight"));
        stories.add(new Story(R.drawable.profile5, "KunUz"));
        stories.add(new Story(R.drawable.profile6, "Muhammad"));
        stories.add(new Story(R.drawable.profile1, "Queen"));
        stories.add(new Story(R.drawable.profile2, "Farkhod"));
        stories.add(new Story(R.drawable.profile3, "Xushnudbek"));
        return stories;
    }

    ArrayList<Post> getAllFeeds() {
        ArrayList<Post> posts =new ArrayList<Post>();
        posts.add(new Post(R.drawable.profile3, "Xushnudbek Hudayberdiev", R.drawable.photo1));
        posts.add(new Post(R.drawable.profile1, "Queen\uD83D\uDC51", R.drawable.photo5,R.drawable.photo6));
        posts.add(new Post(R.drawable.profile2, "Farkhod Fayzullaev", R.drawable.photo3));
        posts.add(new Post(R.drawable.profile4, "Moonlight", "vidi"));
        posts.add(new Post(R.drawable.profile5, "KunUz", R.drawable.photo8));
        posts.add(new Post(R.drawable.profile6, "Muhammad", R.drawable.photo7));
        posts.add(new Post(R.drawable.profile1, "Queen\uD83D\uDC51", R.drawable.photo2));
        return posts;
    }
}