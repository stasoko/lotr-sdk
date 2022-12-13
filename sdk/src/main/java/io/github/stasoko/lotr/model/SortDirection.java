package io.github.stasoko.lotr.model;

/**
 * An enum representing sort direction
 */
@SuppressWarnings("unused")
public enum SortDirection {
    /**
     * Sort from lowest to highest
     */
    ASC,
    /**
     * Sort from highest to lowest
     */
    DSC;

    /**
     * A method to generate the URL parameter string based on the inputted param name
     *
     * @param  param  the name of the sort param
     * @return  the string to be appended to the URL to trigger the sort
     */
    public String getUrlString(String param) {
        return "?sort=" + param + ":" + name().toLowerCase();
    }
}
