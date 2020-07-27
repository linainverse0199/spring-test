package com.example.demo.domain;

public class Marmalade {
    private final long id;
    private String name = "Marmalade delicious";
    private final String taste;
    private final String shape;

    Marmalade(long id, String name, String taste, String shape) {
        this.id = id;
        this.name = name;
        this.taste = taste;
        this.shape = shape;
    }

    public static MarmaladeBuilder builder() {
        return new MarmaladeBuilder();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTaste() {
        return this.taste;
    }

    public String getShape() {
        return this.shape;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Marmalade)) return false;
        final Marmalade other = (Marmalade) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$taste = this.getTaste();
        final Object other$taste = other.getTaste();
        if (this$taste == null ? other$taste != null : !this$taste.equals(other$taste)) return false;
        final Object this$shape = this.getShape();
        final Object other$shape = other.getShape();
        if (this$shape == null ? other$shape != null : !this$shape.equals(other$shape)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Marmalade;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $taste = this.getTaste();
        result = result * PRIME + ($taste == null ? 43 : $taste.hashCode());
        final Object $shape = this.getShape();
        result = result * PRIME + ($shape == null ? 43 : $shape.hashCode());
        return result;
    }

    public String toString() {
        return "Marmalade(id=" + this.getId() + ", name=" + this.getName() + ", taste=" + this.getTaste() + ", shape=" + this.getShape() + ")";
    }

    public static class MarmaladeBuilder {
        private long id;
        private String name;
        private String taste;
        private String shape;

        MarmaladeBuilder() {
        }

        public Marmalade.MarmaladeBuilder id(long id) {
            this.id = id;
            return this;
        }

        public Marmalade.MarmaladeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Marmalade.MarmaladeBuilder taste(String taste) {
            this.taste = taste;
            return this;
        }

        public Marmalade.MarmaladeBuilder shape(String shape) {
            this.shape = shape;
            return this;
        }

        public Marmalade build() {
            return new Marmalade(id, name, taste, shape);
        }

        public String toString() {
            return "Marmalade.MarmaladeBuilder(id=" + this.id + ", name=" + this.name + ", taste=" + this.taste + ", shape=" + this.shape + ")";
        }
    }
}
