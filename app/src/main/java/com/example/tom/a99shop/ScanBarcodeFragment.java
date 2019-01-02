package com.example.tom.a99shop;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScanBarcodeFragment extends Fragment {

    private ZXingScannerView zXingScannerView;

    public ScanBarcodeFragment() {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        QR scan Controller

        // Required empty public constructor
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)
                    getActivity(), Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions((Activity) getActivity(),
                        new String[]{Manifest.permission.CAMERA},
                        1);
            }

        }

        zXingScannerView = new ZXingScannerView(getActivity());
        getActivity().setContentView(zXingScannerView);
        zXingScannerView.startCamera();

        zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {
                zXingScannerView.stopCamera();

                if (result != null) {
                    getActivity().setContentView(R.layout.activity_main);
                    String resultString = result.getText();

                    Bundle bundle = new Bundle();
                    bundle.putString("codeId", resultString);
                    // set Fragmentclass Arguments
                    MainFragment mainFragment = new MainFragment();
                    mainFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().findFragmentById(R.id.contentMainFragment).setArguments(bundle);

//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.contentMainFragment, mainFragment).commit();
                }else if(result == null) {
                    Log.d("backcancel", "handleResult: close.");
                }

                getActivity().getSupportFragmentManager().popBackStackImmediate() ;
            }


        });







    }   // Main Method


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan_barcode, container, false);
    }




}
