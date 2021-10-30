package airRoutes.utils;

import java.util.Objects;

/**
 * The Airport class describes an airport and its most
 * important attributes. It is simply used for data storage
 * and doesn't provide any special functions.
 *
 * @author  David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since   28.10.2021
 */
public class Airport {
    private final String country;
    private final String location;
    private String name;
    private String abbreviation;

    /**
     * constructor
     * @param country the country where the airport is located
     * @param location the exact location of the airport (city, region)
     * @param name the full name of the airport
     * @param abbreviation the official tag of the airport in the flight industry
     */
    public Airport(String country, String location, String name, String abbreviation){
        this.country = country;
        this.location = location;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    //Getters
    public String getCountry() {
        return country;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    // necessary in order for HashMap to work properly
    @Override
    public boolean equals(Object obj) {
        // check if payload is Instance of airport before casting
        if (obj == null) return false;
        if (!(obj instanceof Airport)) return false;

        // casting Object to Airport
        Airport airport = (Airport) obj;

        return
                this.country.equalsIgnoreCase(airport.getCountry()) &&
                this.location.equalsIgnoreCase(airport.getLocation()) &&
                this.name.equalsIgnoreCase(airport.getName()) &&
                this.abbreviation.equalsIgnoreCase(airport.getAbbreviation());
    }

    @Override
    public int hashCode(){
        // generate a custom hash
        return Objects.hash(this.country, this.location, this.name, this.abbreviation);
    }
}
