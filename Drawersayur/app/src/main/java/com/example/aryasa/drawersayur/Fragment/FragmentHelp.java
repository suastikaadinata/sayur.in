package com.example.aryasa.drawersayur.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aryasa.drawersayur.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FragmentHelp extends Fragment {
    PDFView pdfView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_help, container, false);

        pdfView = (PDFView) view.findViewById(R.id.pdfhelp);
        pdfView.fromAsset("USER MANUAL.pdf").load();

        return view;
    }
}