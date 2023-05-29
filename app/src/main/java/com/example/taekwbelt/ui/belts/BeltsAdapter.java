//The adapter class converts our data into elements that are created on the basis of layout file "item_belt.xml"
package com.example.taekwbelt.ui.belts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.ItemBeltBinding;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;
import com.example.taekwbelt.ui.belts.BeltsViewHolder;
import com.example.taekwbelt.ui.categories.CategoriesFragment;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;


public class BeltsAdapter extends RecyclerView.Adapter <BeltsViewHolder> implements View.OnClickListener {
    private ArrayList<UBGradingItem> _arrayObjectList; // a list of color and black belts
    Context _myContext;

    public ArrayList<UBGradingItem> getArrayObjectList() {
        return _arrayObjectList;
    }

    //make general collection of belts
    public BeltsAdapter(UBGradingMaterial arrayObjectList, Context context){
        //arrayObjectList has two parts (color&black belts)
        this._arrayObjectList = arrayObjectList.getColorBelts();
        this._arrayObjectList.addAll(arrayObjectList.getBlackBelts());
        this._myContext = context;
    }

    @NonNull
    @Override
    public BeltsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());
        ItemBeltBinding binding = ItemBeltBinding.inflate(myInflater, parent, false);

        //set a listener on the element of belts list
        binding.getRoot().setOnClickListener(this);

        //set a listener on the button ">" (to the next screen)
        //binding.imageButtonNext.setOnClickListener(this);

        // perform setOnClickListener event to click on imageButtonNext(">")
        binding.imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loadNextFragment(v);
                NavController navController = Navigation.findNavController(v);
               navController.navigate(R.id.action_navigation_belts_to_navigation_selected_belt);
              //  Intent myIntent = new Intent(myInflater.getContext(), CategoriesFragment.class);

                String nameBeltGrade = binding.beltNameTextView.getText().toString(); // get text for another screen
               // myIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, nameBeltGrade); //send a text

                int imageBeltGrade = binding.imageBelt.getId();

                //launch CategoriesFragment with arguments
                //BeltsFragmentDirections.actionNavigationBeltsToNavigationSelectedBelt(nameBeltGrade,imageBeltGrade);
                //BeltsFragmentDirections.actionNavigationBeltsToNavigationSelectedBelt(imageBeltGrade);
                //navController.navigate(BeltsFragmentDirections.actionNavigationBeltsToNavigationSelectedBelt(imageBeltGrade));

            }
        });


        return new BeltsViewHolder(binding);
    }

    private void loadNextFragment(View viewItem) {
        NavController navController = Navigation.findNavController(viewItem);
        navController.navigate(R.id.action_navigation_belts_to_navigation_selected_belt);


       /*
        Fragment nextFragment = new CategoriesFragment();
        // create a FragmentManager
        //FragmentManager fManager =getSupportFragmentManager();

        // fragment transaction to add/replace fragments while activity is running
        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.addToBackStack(null);
        //fTransaction.add(nextFragment,null);
        fTransaction.replace(R.id.const_lyaout_of_selected_belt, nextFragment);//or need to send layout???
        fTransaction.commit(); // save the changes
        */
    }


    // Fill the data to be displayed at the specified position
    @Override
    public void onBindViewHolder(@NonNull BeltsViewHolder holder, int position) {
        UBGradingItem object = getArrayObjectList().get(position);

        _myContext = holder.getItemBeltBinding().getRoot().getContext();
        Activity activity = (Activity) _myContext;
        //search in resources ID-icon(int) from "grading.json"(string)
        String nameIcon = object.getIconName();
        if (nameIcon.endsWith(".png"))
            nameIcon = nameIcon.substring(0, nameIcon.length() - 4); // there's just a name without ".png"
        int myIconInt = activity.getResources().getIdentifier(nameIcon, "drawable",
                activity.getPackageName());
        // Set image associated with the grade to be displayed in UI
        holder.getItemBeltBinding().imageBelt.setImageResource(myIconInt);

        //set the name of the grade to be displayed in UI
        holder.getItemBeltBinding().beltNameTextView.setText(object.getGrade());

        // Set the image of switching to the next fragment to be displayed in UI
        holder.getItemBeltBinding().imageButtonNext.setImageResource(R.drawable.ic_navigate_next);

        // Set the line separator between elements of RecyclerView to be displayed in UI
        holder.getItemBeltBinding().viewLine.findViewById(R.id.view_line);

        //set the click tag for the element of belts list
        holder.itemView.setTag(object);//or getTag???

        // set the click tag for the next button
        holder.getItemBeltBinding().imageButtonNext.setTag(object);
    }

    //return how many items we have in our recycler view
    @Override
    public int getItemCount() {
        return getArrayObjectList() != null ? getArrayObjectList().size() : 0;
    }

    //when we click on some element of belts list it shows a text with name of grade
    //when we click on the next button ' > ' it shows another window (selected_belt.xml)
    @Override
    public void onClick(View v) {
        UBGradingItem someItem = (UBGradingItem) v.getTag();
        if (v.getId() == R.id.imageButtonNext) {
            System.out.println("Click on the button Next");

        }
        else Toast.makeText(_myContext, someItem.getGrade(), Toast.LENGTH_SHORT).show();

    }
}
