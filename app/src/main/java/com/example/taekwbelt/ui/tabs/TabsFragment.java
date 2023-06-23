//A class...
package com.example.taekwbelt.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.MainActivity;
import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTabsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class TabsFragment extends Fragment {
    private FragmentTabsBinding binding;
    BottomNavigationView myBotNavView;
    TabsAdapter tabsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTabsBinding.inflate(inflater, container, false);

        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.botNavView, navController);

        Toolbar myToolBar = binding.tabsToolbar.findViewById(R.id.tabsToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolBar);
        NavigationUI.setupWithNavController(myToolBar, navController);

//        AppBarConfiguration appBarConfiguration =
//                new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupWithNavController(myToolBar, navController, appBarConfiguration);

        myToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                // add code here that execute on click of navigation button
              // NavController navController = Navigation.findNavController(view);
               int idCurrentFragment = navController.getCurrentDestination().getId();
               if (idCurrentFragment == R.id.navigation_selected_belt){
                    navController.popBackStack();
                } else if (idCurrentFragment == R.id.navigation_about) {
                    navController.popBackStack();
               }
            }
        });

        myBotNavView = binding.botNavView.findViewById(R.id.botNavView);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding = FragmentTabsBinding.bind(view);
//        //connect navigation component to BottomNavigationView
//        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
//        NavController navController = navHostFragment.getNavController();
//        NavigationUI.setupWithNavController(binding.botNavView, navController);

        // using toolbar as ActionBar
//        Toolbar myToolBar = binding.tabsToolbar.findViewById(R.id.tabsToolbar); // get the reference of Toolbar
//        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolBar);
//
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                navController.getGraph()).build(); // use 'navController.getGraph()'
//
//       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.botNavView, navController);
//
//        myToolBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // add code here that execute on click of navigation button
//                // NavController navController = Navigation.findNavController(view);
//                int idCurrentFragment = navController.getCurrentDestination().getId();
//                if (idCurrentFragment == R.id.navigation_selected_belt){
//                    navController.popBackStack();
//                } else if (idCurrentFragment == R.id.navigation_about) {
//                    navController.popBackStack();
//                }
//
//            }
//        });


    }
}
