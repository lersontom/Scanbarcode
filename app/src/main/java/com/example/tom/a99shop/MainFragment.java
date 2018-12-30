package com.example.tom.a99shop;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Button buttonScaner;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        buttonScaner = getView().findViewById(R.id.button_scan);
        buttonScaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMainFragment,
                        new ScanBarcodeFragment()).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Bundle bundle = this.getArguments();
//    try {
//        String codeId = bundle.getString("codeId");
//        Toast.makeText(getActivity(), codeId, Toast.LENGTH_SHORT).show();
//
//        if (codeId == null)
//            codeId = "";
//
//        Toast.makeText(getActivity(), "Code Id : " + codeId,
//                Toast.LENGTH_LONG).show();
//    }catch (Exception e){
//        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
//    }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }



}
