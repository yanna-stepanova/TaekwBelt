//The adapter class converts our data into elements that are created on the basis of layout file "item_belt.xml"
package com.example.taekwbelt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taekwbelt.databinding.ItemBeltBinding;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

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

        //set a listener on the element of belts list and a listener on a button ">" (to the next)
        binding.getRoot().setOnClickListener(this);
        binding.imageButtonNext.setOnClickListener(this);

        return new BeltsViewHolder(binding);
    }

    // Fill the data to be displayed at the specified position
    @Override
    public void onBindViewHolder(@NonNull BeltsViewHolder holder, int position) {
        UBGradingItem object = getArrayObjectList().get(position);
        _myContext = holder.getItemBeltBinding().getRoot().getContext();
        Activity activity = (Activity) _myContext;
        //set the name of the grade to be displayed in UI
        holder.getItemBeltBinding().beltNameTextView.setText(object.getGrade());

        //search in resources ID-icon(int) from "grading.json"(string)
        String nameIcon = object.getIconName();
        if (nameIcon.endsWith(".png"))
            nameIcon = nameIcon.substring(0, nameIcon.length() - 4); // there's just a name without ".png"
        int myIconInt = activity.getResources().getIdentifier(nameIcon, "drawable",
                activity.getPackageName());
        // Set image associated with the grade to be displayed in UI
        holder.getItemBeltBinding().imageBelt.setImageResource(myIconInt);
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
    //when we click on the next button ' > ' it shows another window
    @Override
    public void onClick(View v) {
        UBGradingItem someItem = (UBGradingItem) v.getTag();
        if (v.getId() == R.id.imageButtonNext) {
            System.out.println("Click on the button Next");
        }
        else Toast.makeText(_myContext, someItem.getGrade(), Toast.LENGTH_SHORT).show();
    }
}
