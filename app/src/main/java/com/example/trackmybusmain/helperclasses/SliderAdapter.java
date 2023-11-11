package com.example.trackmybusmain.helperclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.trackmybusmain.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.onboardingfirst,
            R.drawable.onboardingsecond,
            R.drawable.onboardingthird
    };

    int headings[] = {
            R.string.onboardHeadingFirst,
            R.string.onboardHeadingSecond,
            R.string.onboardHeadingThird
    };

    int descriptions[] = {
            R.string.onboardDescFirst,
            R.string.onboardDescSecond,
            R.string.onboardDescThird
    };


    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }


    //The instantiateItem() method is called by the PagerAdapter class when it needs to create a new view for a
    //given position. The position parameter is passed to the instantiateItem() method as an argument.
    //The PagerAdapter class is responsible for managing the views that are displayed in a ViewPager. It keeps track of
    //the current position of the ViewPager and calls the instantiateItem() method to create a new view for the next
    //or previous position when the user scrolls the ViewPager.

    @NonNull
    @Override
    //container here is the view group on which we are changing the data
    //position is passed by viewpager itself when created to change the context on the slide
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //request system to use service of the design
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //now inside view we have the design we have taken the slides layout as view with help of inflater
        //inflater converts layout to view
        View view = layoutInflater.inflate(R.layout.slideslayout,container,false);

        ImageView imageView = view.findViewById(R.id.sliderImage);
        TextView heading = view.findViewById(R.id.sliderHeading);
        TextView desc = view.findViewById(R.id.sliderDescription);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    //here when the position changed means slide changed the container aka viewpager containing the slide layout will
    //destroyed
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
