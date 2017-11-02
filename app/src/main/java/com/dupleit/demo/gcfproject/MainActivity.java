package com.dupleit.demo.gcfproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dupleit.demo.gcfproject.Network.APIService;
import com.dupleit.demo.gcfproject.Network.ApiClient;
import com.dupleit.demo.gcfproject.adapter.VideoListAdapter;
import com.dupleit.demo.gcfproject.adapter.subjectListAdapter;
import com.dupleit.demo.gcfproject.helper.Config;
import com.dupleit.demo.gcfproject.helper.GridSpacingItemDecoration;
import com.dupleit.demo.gcfproject.helper.checkInternetState;
import com.dupleit.demo.gcfproject.modal.Subject;
import com.dupleit.demo.gcfproject.modal.UserUImodel;
import com.dupleit.demo.gcfproject.modal.VideoAll;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    @BindView(R.id.linearSubjects) LinearLayout linearSubjects;
    @BindView(R.id.linearyoutube) LinearLayout linearVideoCard;
    @BindView(R.id.linearPerformance) LinearLayout linearPerformance;
    @BindView(R.id.recyclerSubjects) RecyclerView recyclerSubjects;
    @BindView(R.id.tvPerformanceInPercent) TextView tvPerformanceInPercent;
    @BindView(R.id.linearQuiz) LinearLayout linearQuiz;
    @BindView(R.id.textLine) TextView textLine;
    @BindView(R.id.quizQus) TextView quizQus;
    @BindView(R.id.radioButton1) RadioButton radioButton1;
    @BindView(R.id.radioButton2) RadioButton radioButton2;
    @BindView(R.id.radioButton3) RadioButton radioButton3;
    @BindView(R.id.radioButton4) RadioButton radioButton4;
    @BindView(R.id.quizSubjectName) TextView quizSubjectName;
    @BindView(R.id.recyclerImages) RecyclerView recyclerImages;
    @BindView(R.id.linearImages) LinearLayout linearImages;
    GridLayoutManager gridLayout;
    subjectListAdapter mAdapter;
    ArrayList<Subject> subjectArrayList = new ArrayList<>();
    ArrayList<VideoAll> videoArrayList= new ArrayList<>();
    VideoListAdapter videoListAdapter;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gridLayout = new GridLayoutManager(getApplicationContext(),3);
        recyclerSubjects.setLayoutManager(gridLayout);
        recyclerSubjects.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        recyclerSubjects.setItemAnimator(new DefaultItemAnimator());
        recyclerSubjects.setHasFixedSize(true);
        mAdapter = new subjectListAdapter(getApplicationContext(), subjectArrayList);
        recyclerSubjects.setAdapter(mAdapter);

        YouTubePlayerSupportFragment frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_view);
        frag.initialize(Config.DEVELOPER_KEY, this);

        videoListAdapter = new VideoListAdapter(getApplicationContext(),videoArrayList);

        recyclerImages.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerImages.setHasFixedSize(true);
        recyclerImages.setAdapter(videoListAdapter);

        if (!checkInternetState.getInstance(getApplicationContext()).isOnline()) {
            Toast.makeText(getApplicationContext(), "Please Check Your Internet Connection!", Toast.LENGTH_SHORT).show();
        }else {
            new LongOperation(getApplicationContext()).execute();

        }
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            //  String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, "Not initialised", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.cueVideo(Config.YOUTUBE_VIDEO_CODE);
            // Hiding player controls
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    public class LongOperation extends AsyncTask<Void, Integer, String> {

        Context ctx;
        public LongOperation(Context context) {
            this.ctx = context;

        }


        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            //pDialog.setIndeterminate(true);
            pDialog.setTitle("Fetching Data");
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
           showpDialog();
        }

        @Override
        protected String doInBackground(Void... params) {

            APIService service = ApiClient.getClient().create(APIService.class);
            Call<UserUImodel> userCall = service.getUidata("test");
            userCall.enqueue(new Callback<UserUImodel>() {
                @Override
                public void onResponse(Call<UserUImodel> call, Response<UserUImodel> response) {

                    if (response.body().getStatus()) {
                        // Log.d("mytags",""+response.body().getUserData().getUserShow().getSubjectShow());
                        if (response.body().getUserData().getUserShow().getSubjectShow().equals("1")) {
                            linearSubjects.setVisibility(View.VISIBLE);
                            for (int i = 0; i < response.body().getUserData().getSubject().size(); i++) {
                                Log.d("mytags", Config.Web_path + response.body().getUserData().getSubject().get(i).getSubImg());
                                subjectArrayList.add(new Subject(response.body().getUserData().getSubject().get(i).getSubId(), response.body().getUserData().getSubject().get(i).getSubImg(), response.body().getUserData().getSubject().get(i).getSubName(), response.body().getUserData().getSubject().get(i).getStatus()));
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                        if (response.body().getUserData().getUserShow().getVideoShow().equals("1")){
                            linearVideoCard.setVisibility(View.VISIBLE);
                        } 

                        if (response.body().getUserData().getUserShow().getPerformanceShow().equals("1")){
                            linearPerformance.setVisibility(View.VISIBLE);
                            for (int i = 0; i <response.body().getUserData().getPerformance().size() ; i++) {
                                tvPerformanceInPercent.setText(response.body().getUserData().getPerformance().get(i).getPerformance()+"%");
                                textLine.setText("You have shown "+response.body().getUserData().getPerformance().get(i).getPerformance()+"% improvement in score over last 5 test");
                            }
                        }

                        if (response.body().getUserData().getUserShow().getQuizShow().equals("1")){
                            linearQuiz.setVisibility(View.VISIBLE);
                            for (int i = 0; i <response.body().getUserData().getQuizShow().size() ; i++) {
                                quizSubjectName.setText(response.body().getUserData().getQuizShow().get(i).getSubjectName());
                                quizQus.setText(response.body().getUserData().getQuizShow().get(i).getQuestion());
                                radioButton1.setText(response.body().getUserData().getQuizShow().get(i).getOption1());
                                radioButton2.setText(response.body().getUserData().getQuizShow().get(i).getOption2());
                                radioButton3.setText(response.body().getUserData().getQuizShow().get(i).getOption3());
                                radioButton4.setText(response.body().getUserData().getQuizShow().get(i).getOption4());
                            }
                        }

                        if (response.body().getUserData().getUserShow().getAllvideoShow().equals("1")){
                            linearImages.setVisibility(View.VISIBLE);
                            for (int i = 0; i <response.body().getUserData().getVideoAll().size() ; i++) {
                                // Log.d("mytags","http://192.168.1.4/gcfapp/"+response.body().getUserData().getVideoAll().get(i).getSubImg());
                                videoArrayList.add(new VideoAll(response.body().getUserData().getVideoAll().get(i).getVideoid(),response.body().getUserData().getVideoAll().get(i).getImagePath(),response.body().getUserData().getVideoAll().get(i).getName(),response.body().getUserData().getVideoAll().get(i).getInstitute(),response.body().getUserData().getVideoAll().get(i).getViews(),response.body().getUserData().getVideoAll().get(i).getCourse()));
                            }
                            videoListAdapter.notifyDataSetChanged();
                        }

                    }else{
                        Toast.makeText(MainActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserUImodel> call, Throwable t) {
                    Log.d("onFailure", t.toString());
                }
            });

            return null;

        }



        @Override
        protected void onPostExecute(String result) {
            hidepDialog();

        }
    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
    //to hide progress
    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
