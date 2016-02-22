package xyz.akedia.android.moodleonmobile.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xyz.akedia.android.moodleonmobile.R;
import xyz.akedia.android.moodleonmobile.ThreadDetailsActivity;

/**
 * Created by ashish on 21/2/16.
 */
public class CourseThreadAdapter extends RecyclerView.Adapter<CourseThreadAdapter.CourseViewHolder>{

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView threadTitle, threadSummary, threadDate;

        CourseViewHolder(final View itemView, final Activity activity) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            threadTitle = (TextView)itemView.findViewById(R.id.thread_title);
            threadSummary = (TextView)itemView.findViewById(R.id.thread_description);
            threadDate = (TextView)itemView.findViewById(R.id.thread_date);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(activity,ThreadDetailsActivity.class);
                    intent.putExtra("courseCode",threadTitle.getText().toString());
                    activity.startActivity(intent);
                    //Toast.makeText(itemView.getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    List<String[]> threadList;
    Activity parentActivity;

    public CourseThreadAdapter(List<String[]> list,Activity activity){
        this.threadList = list;
        this.parentActivity = activity;
    }
    @Override
    public int getItemCount() {
        return threadList.size();
    }
    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_course_thread, viewGroup, false);
        CourseViewHolder courseViewHolder = new CourseViewHolder(v,parentActivity);
        return courseViewHolder;
    }
    @Override
    public void onBindViewHolder(CourseViewHolder courseViewHolder, int i) {
        String[] thread = threadList.get(i);
        courseViewHolder.threadTitle.setText(thread[0]);
        courseViewHolder.threadSummary.setText(thread[1]);
        courseViewHolder.threadDate.setText(thread[2]);
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}