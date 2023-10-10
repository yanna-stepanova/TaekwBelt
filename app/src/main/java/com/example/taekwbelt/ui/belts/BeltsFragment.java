// Class of our started display with a list of belts
package com.example.taekwbelt.ui.belts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taekwbelt.databinding.FragmentBeltsBinding;
import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BeltsFragment extends Fragment {
    private FragmentBeltsBinding beltsFragmentBinding;
    private BeltsAdapter beltsAdapter;
    BeltsViewModel beltsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        beltsViewModel = new ViewModelProvider(this).get(BeltsViewModel.class);
        try {
            beltsViewModel.init();
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        beltsViewModel.getBeltsListLD().observe(this, new Observer<>() {
            @Override
            public void onChanged(List<UBGradingItem> ubGradingItems) {
                beltsAdapter.notifyDataSetChanged();
            }
        });

        beltsFragmentBinding = FragmentBeltsBinding.inflate(inflater, container, false);

        beltsAdapter = new BeltsAdapter(beltsViewModel.getBeltsListLD().getValue(), getActivity());
        beltsFragmentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        beltsFragmentBinding.recyclerView.setAdapter(beltsAdapter);
        beltsFragmentBinding.recyclerView.setHasFixedSize(true);

        return beltsFragmentBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        beltsFragmentBinding = null;
    }

}