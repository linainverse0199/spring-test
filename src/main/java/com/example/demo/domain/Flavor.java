package com.example.demo.domain;

public class Flavor {
    private long id;
    private String color;

    public Flavor() {
    }

    public long getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Flavor)) return false;
        final Flavor other = (Flavor) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$color = this.getColor();
        final Object other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Flavor;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        return result;
    }

    public String toString() {
        return "Flavor(id=" + this.getId() + ", color=" + this.getColor() + ")";
    }
}
