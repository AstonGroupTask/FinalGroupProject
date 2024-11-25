package org.example.essence;

public class Barrel extends Entity<Double, String, String> {
    private final Double volume;
    private final String storedMaterial;
    private final String materialMadeOf;

    private Barrel(BarrelBuilder builder) {
		super(builder.volume, builder.storedMaterial, builder.materialMadeOf);
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.materialMadeOf = builder.materialMadeOf;
    }

    public double getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getMaterialMadeOf() {
        return materialMadeOf;
    }

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
        return volume + " " + storedMaterial + " " + materialMadeOf;
    }
}
