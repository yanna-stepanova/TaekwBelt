// The adapter class converts our data into elements that are created on the basis
// of layout file "item_belt.xml"
package com.example.taekwbelt.ui.belts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.ItemBeltBinding;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import java.util.ArrayList;

public class BeltsAdapter extends RecyclerView.Adapter <BeltsViewHolder> implements View.OnClickListener {
    private ArrayList<UBGradingItem> _arrayObjectList; // a list of color and black belts
    private Context _myContext;

    public Context getMyContext() {
        return _myContext;
    }

    public void setMyContext(Context someContext) {
        this._myContext = someContext;
    }

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

        //set a listener on the element of belts list:
        //overridden method 'onClick' will be called here for every component of the row
        binding.getRoot().setOnClickListener(this);
        return new BeltsViewHolder(binding);
    }

    //convert data of icon from "grading.json"(string) for searching in resources-file((int)ID-icon)
    public int getNameSearchingIconBelt (String rawNameIcon){
        if (rawNameIcon.endsWith(".png"))
            rawNameIcon = rawNameIcon.substring(0, rawNameIcon.length() - 4); // there's just a name without ".png"
        return getMyContext().getResources().
                getIdentifier(rawNameIcon, "drawable", getMyContext().getPackageName());
    }

    // Fill the data to be displayed at the specified position
    @Override
    public void onBindViewHolder(@NonNull BeltsViewHolder holder, int position) {
        UBGradingItem object = getArrayObjectList().get(position);
        setMyContext(holder.getItemBeltBinding().getRoot().getContext());

        int myIconInt = getNameSearchingIconBelt(object.getIconName());
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

    // return how many items we have in our recycler view
    @Override
    public int getItemCount() {
        return getArrayObjectList() != null ? getArrayObjectList().size() : 0;
    }

    //when we click on some element of belts list it shows another window (selected_belt.xml)
    @Override
    public void onClick(View v) {
        UBGradingItem someItem = (UBGradingItem) v.getTag(); //it's selected belt from our list
        NavController navController = Navigation.findNavController(v);

        // send id of icon too
        // because icon's information is transmitted like type 'string' in json
        // but there it's converted to drawable type (int) in 'getNameSearchingIconBelt'
        int myIcon = getNameSearchingIconBelt(someItem.getIconName());
        navController.navigate(BeltsFragmentDirections.actionBeltsFragmentToCategoriesFragment(someItem, myIcon));
              //  .actionNavigationBeltsToNavigationSelectedBelt(someItem, myIcon));
    }
}
