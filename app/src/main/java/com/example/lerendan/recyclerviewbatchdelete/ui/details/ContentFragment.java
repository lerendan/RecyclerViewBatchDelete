package com.example.lerendan.recyclerviewbatchdelete.ui.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.bean.Crime;
import com.example.lerendan.recyclerviewbatchdelete.bean.CrimeLab;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lerendan on 2016/8/3.
 */

public class ContentFragment extends Fragment{

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogData";
    private static final int REQUEST_DATE = 0;

    private EditText edt_title;
    private Button btn_data;
    private CheckBox cb_solved;
    private Crime mCrime;


    public static ContentFragment newInstance(UUID crimeID){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID,crimeID);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment,container,false);

        edt_title = (EditText) view.findViewById(R.id.title);
        btn_data = (Button) view.findViewById(R.id.data);
        cb_solved = (CheckBox) view.findViewById(R.id.solved);

        UUID crimeID = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeID);

        edt_title.setText(mCrime.getTitle());
        updateDate();
        cb_solved.setChecked(mCrime.isSolved());

        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                DataPickerFragment dialog = DataPickerFragment.newInstance(mCrime.getData());
                dialog.setTargetFragment(ContentFragment.this,REQUEST_DATE);
                dialog.show(manager,DIALOG_DATE);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode!= Activity.RESULT_OK){
            return;
        }

        if(requestCode==REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra(DataPickerFragment.EXTRA_DATE);
            mCrime.setData(date);
            updateDate();

        }
    }

    private void updateDate() {
        btn_data.setText(mCrime.getData().toString());
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_content,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_delete_crime:
                CrimeLab.get(getActivity()).delete(mCrime);
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
