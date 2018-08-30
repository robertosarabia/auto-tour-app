package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * This is our own custom constructor.
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists
     *
     * @param context The current context. Used to inflate the layout file.
     * @param locations   A List of Location objects to display in a list.
     */
    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name from the current Location object and
        // set this text on the name_text_view TextView
        nameTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID address_text_view
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the address from the current Location object and
        // set this text on the address_text_view TextView
        addressTextView.setText(currentLocation.getLocationAddress());

        // Find the TextView in the list_item.xml layout with the ID phone_text_view
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone_text_view);
        // Get the phone number from the current Location object and
        // set this text on the phone_text_view TextView
        phoneTextView.setText(currentLocation.getLocationPhone());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the ImageView to the image resource specified in the current Location
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Set the color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 text views)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
