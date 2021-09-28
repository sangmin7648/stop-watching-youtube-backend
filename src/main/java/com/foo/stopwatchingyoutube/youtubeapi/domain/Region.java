package com.foo.stopwatchingyoutube.youtubeapi.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Region {
    private final String regionName;

    public Region(String regionName) {
        validateRegion(regionName);
        this.regionName = regionName;
    }

    private void validateRegion(String regionName) {
        var REGION_PATTERN = "^[a-zA-z]{2}$";
        if (!regionName.matches(REGION_PATTERN))
            throw new IllegalArgumentException("region must be 2 characters");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName);
    }

    @Override
    public String toString() {
        return "Region{" +
            "regionName='" + regionName + '\'' +
            '}';
    }
}
