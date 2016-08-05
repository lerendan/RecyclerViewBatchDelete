package com.example.lerendan.recyclerviewbatchdelete.ui.details;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.utils.PictureUtils;

import java.io.File;

/**
 * Created by Administrator on 2016/8/5.
 */

public class ImageFragment extends DialogFragment {

    public static final String BIGIMAGE = "big_image";

    public static ImageFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(BIGIMAGE, photoFile);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        File photoFile = (File) getArguments().getSerializable(BIGIMAGE);
        Bitmap bitmap = PictureUtils.getScaleBitmap(photoFile.getPath(),getActivity());
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image,null);
        ImageView imageView = (ImageView) v.findViewById(R.id.bigimage);
        imageView.setImageBitmap(bitmap);


        return new AlertDialog.Builder(getActivity()).setView(R.layout.dialog_image).create();
    }
}
