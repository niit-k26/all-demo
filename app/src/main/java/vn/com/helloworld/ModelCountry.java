package vn.com.helloworld;

/**
 * Created by Lrandom on 5/26/18.
 */

public class ModelCountry {
    String name;
    String population;

    public String getName() {
        return name;
    }

    public ModelCountry setName(String name) {
        this.name = name;
        return this;
    }

    public String getPopulation() {
        return population;
    }

    public ModelCountry setPopulation(String population) {
        this.population = population;
        return this;
    }
}
