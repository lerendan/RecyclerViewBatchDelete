package com.example.lerendan.recyclerviewbatchdelete.ui.frame;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.bean.Crime;
import com.example.lerendan.recyclerviewbatchdelete.bean.CrimeLab;
import com.example.lerendan.recyclerviewbatchdelete.ui.details.ContentFragment;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/3.
 */

public class ContentPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID="crime_id";
    private ViewPager  mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext,UUID crimeID){
        Intent intent = new Intent(packageContext,ContentPagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeID);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_pager);

        UUID crimeID = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime  =mCrimes.get(position);
                return ContentFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for (int i = 0; i < mCrimes.size(); i++) {
            if(mCrimes.get(i).getId().equals(crimeID)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
