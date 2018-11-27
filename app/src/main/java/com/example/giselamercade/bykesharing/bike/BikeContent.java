package com.example.giselamercade.bykesharing.bike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BikeContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Bike> ITEMS = new ArrayList<Bike>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Bike> ITEM_MAP = new HashMap<String, Bike>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createBikeItem(i));
        }
    }

    private static void addItem(Bike item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Bike createBikeItem(int position) {
        return new Bike(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Bike {
        public final String id;
        public final String content;
        public final String details;

        public Bike(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
