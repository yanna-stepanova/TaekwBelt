// A class of a terminology vocabulary when a user selects Terminology category of the selected Taekwondo Belt

package com.stargiant.taekwbelt.ui.terminologies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stargiant.taekwbelt.R;
import com.stargiant.taekwbelt.databinding.FragmentTerminologiesBinding;

/**
 * A fragment representing a list of Items.
 */
public class TerminologiesFragment extends Fragment {

    private FragmentTerminologiesBinding binding;
    private TerminologiesAdapter terminAdapter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //hide bottom navigation from activity_main.xml
        getActivity().requireViewById(R.id.botNavView).setVisibility(View.GONE);
        binding = FragmentTerminologiesBinding.inflate(inflater, container, false);
        terminAdapter = new TerminologiesAdapter(TerminologiesFragmentArgs.
                fromBundle(requireArguments()).getParserTerminologies(), inflater);
        binding.listTerminologies.setAdapter(terminAdapter);
        return binding.getRoot();
    }
}