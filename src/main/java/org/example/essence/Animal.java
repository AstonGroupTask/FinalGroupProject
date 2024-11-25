package org.example.essence;

public class Animal implements Comparable<Animal> {
    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private Animal(AnimalBuilder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;
    }

    @Override
    public int compareTo(Animal o) {
        int speciesComparison = this.species.compareTo(o.species);
        if (speciesComparison != 0) {
            return speciesComparison;
        }

        int eyeColorComparison = this.eyeColor.compareTo(o.eyeColor);
        if (eyeColorComparison != 0) {
            return eyeColorComparison;
        }

        return Boolean.compare(this.hasFur, o.hasFur);
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public static class AnimalBuilder {
        private String species;
        private String eyeColor;
        private boolean hasFur;

        public AnimalBuilder species(String species) {
            this.species = species;
            return this;
        }

        public AnimalBuilder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public AnimalBuilder hasFur(boolean hasFur) {
            this.hasFur = hasFur;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    @Override
    public String toString() {
        return species + " " + eyeColor +  " " + hasFur;


    }
}