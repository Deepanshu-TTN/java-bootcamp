package BuilderPattern;

public class Main {
    static void houseMockWithoutBuilder() {
        // Bad code, keep making constructors
        House basicHouse = new House(4, 2);
        House fancyHouse = new House(6, 3, true, true, "Tile");
        System.out.println(basicHouse);
        System.out.println(fancyHouse);
    }

    static void houseMockWithBuilder() {
        // More code behind the surface to implement but reads easy wherever used.
        // Limitations - update code in main class and builder, more complex
        // also when inheriting a class with builder, we cant override the builder since its a static method.
        // trick - use with generics #TODO practice this.
        HouseWithBuilder basicHouse = new HouseWithBuilder.Builder(4, 2)
                .build();
        HouseWithBuilder fancyHouse = new HouseWithBuilder.Builder(6, 3)
                .hasGarage(true)
                .hasGarden(true)
                .roofType("Tile")
                .build();

        System.out.println(basicHouse);
        System.out.println(fancyHouse);
    }

    public static void main(String[] args) {
        houseMockWithoutBuilder();
        houseMockWithBuilder();
    }
}

class House {
    private int windows;
    private int doors;
    private boolean hasGarage;
    private boolean hasGarden;
    private String roofType;

    public House(int windows, int doors) {
        this.windows = windows;
        this.doors = doors;
    }

    public House(int windows, int doors, boolean hasGarage) {
        this(windows, doors);
        this.hasGarage = hasGarage;
    }

    public House(int windows, int doors, boolean hasGarage, boolean hasGarden) {
        this(windows, doors, hasGarage);
        this.hasGarden = hasGarden;
    }

    public House(int windows, int doors, boolean hasGarage, boolean hasGarden, String roofType) {
        this(windows, doors, hasGarage, hasGarden);
        this.roofType = roofType;
    }
    @Override
    public String toString() {
        return "House{" +
                "windows=" + windows +
                ", doors=" + doors +
                ", hasGarage=" + hasGarage +
                ", hasGarden=" + hasGarden +
                ", roofType='" + roofType + '\'' +
                '}';
    }
}


class HouseWithBuilder {
    private int windows;
    private int doors;
    private boolean hasGarage;
    private boolean hasGarden;
    private String roofType;

    private HouseWithBuilder(Builder builder) {
            this.windows = builder.windows;
            this.doors = builder.doors;
            this.hasGarage = builder.hasGarage;
            this.hasGarden = builder.hasGarden;
            this.roofType = builder.roofType;
        }

    public static class Builder {
        private int windows;
        private int doors;
        private boolean hasGarage;
        private boolean hasGarden;
        private String roofType;

        public Builder(int windows, int doors) {
            this.windows = windows;
            this.doors = doors;
        }

        public Builder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public Builder roofType(String roofType) {
            this.roofType = roofType;
            return this;
        }

        public HouseWithBuilder build() {
            return new HouseWithBuilder(this);
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "windows=" + windows +
                ", doors=" + doors +
                ", hasGarage=" + hasGarage +
                ", hasGarden=" + hasGarden +
                ", roofType='" + roofType + '\'' +
                '}';
    }
}
