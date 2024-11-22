package org.example.essence;

public class Barrel implements Comparable<Barrel> {
    private final double volume;
    private final String storedMaterial;
    private final String materialMadeOf;


    private Barrel(BarrelBuilder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.materialMadeOf = builder.materialMadeOf;
    }

    @Override
    public int compareTo(Barrel o) {
        int volumeComparison = Double.compare(this.volume, o.volume);
        if (volumeComparison != 0) {
            return volumeComparison;
        }

        int storedMaterialComparison = this.storedMaterial.compareTo(o.storedMaterial);
        if (storedMaterialComparison != 0) {
            return storedMaterialComparison;
        }

        return this.materialMadeOf.compareTo(o.materialMadeOf);
    }


    public static class BarrelBuilder {
        private double volume;
        private String storedMaterial;
        private String materialMadeOf;

        public BarrelBuilder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public BarrelBuilder storedMaterial(String storedMaterial) {
            this.storedMaterial = storedMaterial;
            return this;
        }

        public BarrelBuilder materialMadeOf(String materialMadeOf) {
            this.materialMadeOf = materialMadeOf;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    @Override
    public String toString() {
        return volume + storedMaterial + materialMadeOf;
    }
}
