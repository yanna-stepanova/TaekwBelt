// A  class of display selected belt with information about it
// and with a list of grading material categories
package com.example.taekwbelt.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.SelectedBeltBinding;
import com.example.taekwbelt.models.UBGradingPattern;
import com.example.taekwbelt.models.UBGradingRequirement;
import com.example.taekwbelt.models.UBTerminologyItem;
import com.example.taekwbelt.ui.categories.CategoriesFragmentDirections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CategoriesFragment extends Fragment {
    private CategoriesAdapter categoriesAdapter;
    private SelectedBeltBinding binding;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //CategoriesViewModel categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class); //don't need???

        //when back up from screens where bottom navigation is "GONE", it is "GONE" and there
        getActivity().requireViewById(R.id.botNavView).setVisibility(View.VISIBLE);
        binding = SelectedBeltBinding.inflate(inflater, container, false);
        categoriesAdapter = new CategoriesAdapter(initCategories(), inflater);
        binding.listCategories.setAdapter(categoriesAdapter);

        //set arguments from a screen of belts list
        binding.selectedBeltName.setText(CategoriesFragmentArgs.
                fromBundle(requireArguments()).getParserItem().getGrade());
        binding.selectedBeltImage.setImageResource(CategoriesFragmentArgs.
                fromBundle(requireArguments()).getImageFromBeltsFragment());

        binding.listCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavHostFragment topLevelHost = (NavHostFragment) requireActivity().
                        getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                //use Optional instead of to check data for null and NullPointerException
                NavController topNavController = Optional.ofNullable(topLevelHost.getNavController()).get();

                //selected type of category from the list
                String nameCategory = categoriesAdapter.getCategoryModel(position).getNameCategory();
                switch (nameCategory) {
                    case "Requirements":
                        ArrayList<UBGradingRequirement> arrayListRequir = CategoriesFragmentArgs.
                                fromBundle(requireArguments()).getParserItem().getRequirements();
                        UBGradingRequirement[] massivRequir = arrayListRequir.toArray(
                                                                     new UBGradingRequirement[0]);
                        topNavController.navigate(CategoriesFragmentDirections.actionCategoriesFragmentToNavigationRequirements(massivRequir));
                                //.actionTabsFragmentToNavigationRequirements(massivRequir));
                        break;

                    case "Patterns":
                        ArrayList<UBGradingPattern> arrayListPattern = CategoriesFragmentArgs.
                                fromBundle(requireArguments()).getParserItem().getGradingPatterns();
                        UBGradingPattern[] massivPattern = arrayListPattern.toArray(
                                                                          new UBGradingPattern[0]);
                        topNavController.navigate(CategoriesFragmentDirections.actionCategoriesFragmentToNavigationPatterns(massivPattern));
                                //.actionTabsFragmentToNavigationPatterns(massivPattern));
                        break;

                    case "Terminology":
                        ArrayList<UBTerminologyItem> arrayListTermin = CategoriesFragmentArgs.
                                fromBundle(requireArguments()).getParserItem().getTerminologies();
                        UBTerminologyItem[] massivTermin = arrayListTermin.toArray(
                                                                        new UBTerminologyItem[0]);
                        topNavController.navigate(CategoriesFragmentDirections.actionCategoriesFragmentToNavigationTerminologies(massivTermin));
                                //.actionTabsFragmentToNavigationTerminologies(massivTermin));
                        break;

                    default: break;
                }
            }
        });

        return binding.getRoot();
    }

    //initialization  a list view
    private List<CategoryModel> initCategories() {
        List<CategoryModel> myList = new ArrayList<>();
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
