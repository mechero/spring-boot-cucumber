package io.tpd.springbootcucumber;

import java.util.ArrayList;

public final class Bag {

    private final ArrayList<String> things;

    Bag() {
        things = new ArrayList<>();
    }

    void add(final String something) {
        things.add(something);
    }

    // Needed for the JSON serializer
    public ArrayList<String> getThings() {
        return things;
    }
}
