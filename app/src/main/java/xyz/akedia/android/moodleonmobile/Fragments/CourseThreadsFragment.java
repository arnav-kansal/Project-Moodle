package xyz.akedia.android.moodleonmobile.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.akedia.android.moodleonmobile.Adapters.CourseThreadAdapter;
import xyz.akedia.android.moodleonmobile.R;

/**
 * Created by ashish on 21/2/16.
 */
public class CourseThreadsFragment extends Fragment {
    List<String[]> threadList;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_course_thread_fragment,container,false);
        init(v);
        return v;
    }
    public void setVals(List<String[]> list){
        this.threadList = list;
    }

    private void init(View view){
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.courseList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        CourseThreadAdapter adapter = new CourseThreadAdapter(threadList,getActivity());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark,R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //after refresh complete set this
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
