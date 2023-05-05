public enum Planet {
    MERCURY(1, 0, 57_910_000, 2_439.7, null, VENUS),
    VENUS(2, 108_200_000, 41_400_000, 6_051.8, MERCURY, EARTH),
    EARTH(3, 149_600_000, 50_000, 6_371, VENUS, MARS),
    MARS(4, 227_940_000, 24_600_000, 3_389.5, EARTH, JUPITER),
    JUPITER(5, 778_330_000, 50_000_000, 69_911, MARS, SATURN),
    SATURN(6, 1_429_400_000, 10_000_000, 58_232, JUPITER, URANUS),
    URANUS(7, 2_870_990_000L, 9_000_000, 25_362, SATURN, NEPTUNE),
    NEPTUNE(8, 4_498_250_000L, 7_000_000, 24_622, URANUS, null);

    private final int positionFromSun;
    private final long distanceFromSun; // in km
    private final long distanceFromPreviousPlanet; // in km
    private final double radius; // in km
    private final Planet previousPlanet;
    private final Planet nextPlanet;

    Planet(int positionFromSun, long distanceFromPreviousPlanet, long distanceFromNextPlanet, double radius, Planet previousPlanet, Planet nextPlanet) {
        this.positionFromSun = positionFromSun;
        this.distanceFromPreviousPlanet = distanceFromPreviousPlanet;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        this.nextPlanet = nextPlanet;
        if (previousPlanet == null) {
            this.distanceFromSun = distanceFromNextPlanet;
        } else {
            this.distanceFromSun = previousPlanet.distanceFromSun + distanceFromPreviousPlanet + distanceFromNextPlanet;
        }
    }

    public int getPositionFromSun() {
        return positionFromSun;
    }

    public long getDistanceFromSun() {
        return distanceFromSun;
    }

    public long getDistanceFromPreviousPlanet() {
        return distanceFromPreviousPlanet;
    }

    public double getRadius() {
        return radius;
    }

    public Planet getPreviousPlanet() {
        return previousPlanet;
    }

    public Planet getNextPlanet() {
        return nextPlanet;
    }
}
