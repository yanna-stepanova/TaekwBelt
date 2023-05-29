package com.example.taekwbelt.ui.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.SelectedBeltBinding;
import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {
    private CategoriesAdapter categoriesAdapter;
    private SelectedBeltBinding binding;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }

    //need???
    //try to find a way comeback to screen "BeltsFragment"
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = SelectedBeltBinding.bind(view);

       // binding.selectedBeltImage.setImageResource(CategoriesFragmentArgs.fromBundle(requireArguments()).getImageFromBeltsFragment());
       // binding.selectedBeltName.setText(CategoriesFragmentArgs.fromBundle(requireArguments()).getNameFromBeltsFragment());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CategoriesViewModel categoriesViewModel =
                new ViewModelProvider(this).get(CategoriesViewModel.class); //don't need???

        binding = SelectedBeltBinding.inflate(inflater, container, false);
        categoriesAdapter = new CategoriesAdapter(initCategories(), inflater);
        binding.listCategories.setAdapter(categoriesAdapter);
        binding.selectedBeltName.setText("Selected belt");//it's temporary name, need to change
        binding.selectedBeltImage.setImageResource(R.drawable.belt_icon);//it's temporary image, need to change


/*
        //there will be transition to next screen (yet not create)
        binding.listCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
 */
        return binding.getRoot();
    }

    //initialization  a list view
    private List<CategoryModel> initCategories(){
        List<CategoryModel> myList = new ArrayList<CategoryModel>();
        myList.add(new CategoryModel(R.drawable.icon_requirements, "Requirements"));
        myList.add(new CategoryModel(R.drawable.icon_patterns, "Patterns"));
        myList.add(new CategoryModel(R.drawable.icon_terminology, "Terminology"));
        return myList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
