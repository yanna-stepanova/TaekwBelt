package com.example.taekwbelt.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taekwbelt.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {
    private final String[] _emailToAdress = new String[]{"upgradebelt@gmail.com"};
    private final String _subjectEmail = "Taekwondo Belt Android";

    private FragmentAboutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AboutViewModel aboutViewModel =
                new ViewModelProvider(this).get(AboutViewModel.class);

        binding = FragmentAboutBinding.inflate(inflater, container, false);
        binding.btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail(_emailToAdress, _subjectEmail);
            }
        });
        /*
        final TextView textView = binding.textNameAbout;
        aboutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return binding.getRoot();
    }

    public void composeEmail(String[] email, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}