package com.example.lalamove.myapplication.dummy;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.lalamove.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 12;

    public static Context context;

    // ADDED FOR RAGE COMICS
    private static int[] mImageResIds;
    private static String[] mNames;
    private static String[] mDescriptions;
    private static String[] mUrls;

    public DummyContent(Context context)
    {
        this.context=context;
    }

    // TODO: WHAT IS THIS AND WHY DOES IT HAVE TO BE STATIC?
    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static DummyItem createDummyItem(int position) {
        // TODO: fix the parameters: imageId, name, details


        // Get rage face names
        final Resources resources  = context.getResources();
        mNames = resources.getStringArray(R.array.names);
        mDescriptions = resources.getStringArray(R.array.descriptions);
        mUrls = resources.getStringArray(R.array.urls);

        // Get rage face images.
        final TypedArray typedArray = resources.obtainTypedArray(R.array.images);
        final int imageCount = mNames.length;
        mImageResIds = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageResIds[i] = typedArray.getResourceId(i, 0);
        }
        typedArray.recycle();

        return new DummyItem(mImageResIds[position], mNames[position], mDescriptions[position]);
    }

//    private static String makeDetails(int position) {
//        // TODO: change dummy details to rage comics details here
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final int imageId;
        public final String name;
        public final String details;

        public DummyItem(int imageId, String name, String details) {
            this.imageId = imageId;
            this.name = name;
            this.details = details;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}