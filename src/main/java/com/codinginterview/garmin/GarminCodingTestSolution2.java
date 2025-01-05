package com.codinginterview.garmin;

import java.util.*;

public class GarminCodingTestSolution2 {
    static class World {
        public enum Continent {
            AFRICA("Africa"),
            ANTARCTICA("Antarctica"),
            ASIA("Asia"),
            AUSTRALIA_OCEANIA("Australia/Oceania"),
            EUROPE("Europe"),
            NORTH_AMERICA("North America"),
            SOUTH_AMERICA("South America");

            private final String name;

            Continent(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        public enum Country {
            BANGLADESH("Bangladesh", 164689383, Continent.ASIA),
            BRAZIL("Brazil", 212559417, Continent.SOUTH_AMERICA),
            CHINA("China", 1439323776, Continent.ASIA),
            DR_CONGO("DR Congo", 89561403, Continent.AFRICA),
            EGYPT("Egypt", 102334404, Continent.AFRICA, Continent.ASIA),
            ETHIOPIA("Ethiopia", 114963588, Continent.AFRICA),
            FRANCE("France", 65273511, Continent.EUROPE),
            GERMANY("Germany", 83783942, Continent.EUROPE),
            INDIA("India", 1380004385, Continent.ASIA),
            INDONESIA("Indonesia", 273523615, Continent.ASIA),
            IRAN("Iran", 83992949, Continent.ASIA),
            ITALY("Italy", 60461826, Continent.EUROPE),
            JAPAN("Japan", 126476461, Continent.ASIA),
            MEXICO("Mexico", 128932753, Continent.NORTH_AMERICA),
            NIGERIA("Nigeria", 206139589, Continent.AFRICA),
            PAKISTAN("Pakistan", 220892340, Continent.ASIA),
            PHILIPPINES("Philippines", 109581078, Continent.ASIA),
            RUSSIA("Russia", 145934462, Continent.EUROPE, Continent.ASIA),
            SOUTH_AFRICA("South Africa", 59308690, Continent.AFRICA),
            TANZANIA("Tanzania", 59734218, Continent.AFRICA),
            THAILAND("Thailand", 69799978, Continent.ASIA),
            TURKEY("Turkey", 84339067, Continent.EUROPE, Continent.ASIA),
            UNITED_KINGDOM("United Kingdom", 67886011, Continent.EUROPE),
            UNITED_STATES("United States", 331002651, Continent.NORTH_AMERICA),
            VIETNAM("Vietnam", 97338579, Continent.ASIA);

            private final String name;
            private final Integer population;
            private final List<Continent> continents;

            Country(String name, int population, Continent... continents) {
                this.name = name;
                this.population = population;
                this.continents = new ArrayList<>(Arrays.asList(continents));
            }

            public String getName() {
                return name;
            }

            public Integer getPopulation() {
                return population;
            }

            public List<Continent> getContinents() {
                return continents;
            }
        }

        // Returns the countries with territory in the provided continent, ordered by population (decreasing).
        public static List<String> countriesByPopulation(Continent continent) {
            List<Country> countries = new ArrayList<>(Arrays.asList(Country.values()));
            return countries.stream().filter(country -> country.getContinents().contains(continent))
                    .sorted((c1,c2)-> c2.getPopulation().compareTo(c1.getPopulation()))
                    .map(Country::getName).toList();
        }
    }

    public static void main(String[] args) throws Exception {
        Map<World.Continent, List<String>> testCases = new HashMap<>();
        testCases.put(World.Continent.AFRICA, Arrays.asList("Nigeria", "Ethiopia", "Egypt", "DR Congo", "Tanzania", "South Africa"));
        testCases.put(World.Continent.ANTARCTICA, new ArrayList<>());
        testCases.put(World.Continent.ASIA, Arrays.asList("China", "India", "Indonesia", "Pakistan", "Bangladesh", "Russia", "Japan", "Philippines", "Egypt", "Vietnam", "Turkey", "Iran", "Thailand"));
        testCases.put(World.Continent.AUSTRALIA_OCEANIA, new ArrayList<>());
        testCases.put(World.Continent.EUROPE, Arrays.asList("Russia", "Turkey", "Germany", "United Kingdom", "France", "Italy"));
        testCases.put(World.Continent.NORTH_AMERICA, Arrays.asList("United States", "Mexico"));
        testCases.put(World.Continent.SOUTH_AMERICA, Arrays.asList("Brazil"));

        for (World.Continent continent : testCases.keySet()) {
            List<String> resultingCountries = World.countriesByPopulation(continent);
            List<String> expectedCountries = testCases.get(continent);
            if (!Objects.equals(expectedCountries, resultingCountries)) {
                throw new Exception();
            } else {
                System.out.println("success");
            }
        }
        System.out.println("Success!");
    }

}

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings
