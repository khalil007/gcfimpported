package com.dupleit.demo.gcfproject;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dupleit.demo.gcfproject.Network.APIService;
import com.dupleit.demo.gcfproject.Network.ApiClient;
import com.dupleit.demo.gcfproject.adapter.subjectListAdapter;
import com.dupleit.demo.gcfproject.helper.GridSpacingItemDecoration;
import com.dupleit.demo.gcfproject.helper.checkInternetState;
import com.dupleit.demo.gcfproject.modal.Subject;
import com.dupleit.demo.gcfproject.modal.UserUImodel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.linearSubjects)
    LinearLayout linearSubjects;

    @BindView(R.id.linearVideoCard)
    LinearLayout linearVideoCard;

    @BindView(R.id.linearPerformance)
    LinearLayout linearPerformance;

    @BindView(R.id.recyclerSubjects)
    RecyclerView recyclerSubjects;
    GridLayoutManager gridLayout;
    subjectListAdapter mAdapter;

    @BindView(R.id.tvPerformanceInPercent)
    TextView tvPerformanceInPercent;

    @BindView(R.id.textLine)
            TextView textLine;
    ArrayList<Subject> subjectArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gridLayout = new GridLayoutManager(getApplicationContext(),3);
        recyclerSubjects.setLayoutManager(gridLayout);
        recyclerSubjects.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerSubjects.setItemAnimator(new DefaultItemAnimator());
        recyclerSubjects.setHasFixedSize(true);
        mAdapter = new subjectListAdapter(getApplicationContext(), subjectArrayList);
        recyclerSubjects.setAdapter(mAdapter);

        LoadUiData();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void LoadUiData() {
        if (!checkInternetState.getInstance(getApplicationContext()).isOnline()) {
            Toast.makeText(this, "No Connection Found", Toast.LENGTH_SHORT).show();
        }else {
            APIService service = ApiClient.getClient().create(APIService.class);
            Call<UserUImodel> userCall = service.getUidata("test");
            userCall.enqueue(new Callback<UserUImodel>() {
                @Override
                public void onResponse(Call<UserUImodel> call, Response<UserUImodel> response) {
                    if (response.body().getStatus()) {


                       // Log.d("mytags",""+response.body().getUserData().getUserShow().getSubjectShow());
                        if (!response.body().getUserData().getUserShow().getSubjectShow().equals("1")){
                            linearSubjects.setVisibility(View.GONE);
                        }else{
                            for (int i = 0; i <response.body().getUserData().getSubject().size() ; i++) {
                                Log.d("mytags","http://192.168.1.4/gcfapp/"+response.body().getUserData().getSubject().get(i).getSubImg());
                                subjectArrayList.add(new Subject(response.body().getUserData().getSubject().get(i).getSubId(),response.body().getUserData().getSubject().get(i).getSubImg(),response.body().getUserData().getSubject().get(i).getSubName(),response.body().getUserData().getSubject().get(i).getStatus()));
                                mAdapter.notifyDataSetChanged();
                            }
                        }

                        if (!response.body().getUserData().getUserShow().getVideoShow().equals("1")){
                            linearVideoCard.setVisibility(View.GONE);
                        }else{

                        }

                        if (!response.body().getUserData().getUserShow().getPerformanceShow().equals("1")){
                            linearPerformance.setVisibility(View.GONE);
                        }else{
                            tvPerformanceInPercent.setText(response.body().getUserData().getPerformance().getPerformance()+"%");
                            textLine.setText("You have shown "+response.body().getUserData().getPerformance().getPerformance()+"% improvement in score over last 5 test");
                        }

                        if (!response.body().getUserData().getUserShow().getQuizShow().equals("1")){

                        }

                        if (!response.body().getUserData().getUserShow().getAllvideoShow().equals("1")){

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
        }
    }

}
