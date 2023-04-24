package ch02;

public enum Unit {

    FS("Financial Services"),
    EDC("Extended Center"),
    OIL_GAS("Oil & Gas");

    private String unitName;

    Unit(String unitName) {
        this.unitName = unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}