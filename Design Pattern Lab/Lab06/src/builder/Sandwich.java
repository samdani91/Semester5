package builder;

public class Sandwich {
    private final BreadType bread;
    private final FilingType filling;
    private final SpreadType spread;

    private Sandwich(SandwichBuilder builder) {
        this.bread = builder.bread;
        this.filling = builder.filling;
        this.spread = builder.spread;
    }

    @Override
    public String toString() {
        return "builder.Sandwich [Bread=" + bread + ", Filling=" + filling + ", Spread=" + spread + "]";
    }

    public static class SandwichBuilder {
        private BreadType bread;
        private FilingType filling;
        private SpreadType spread;

        public SandwichBuilder setBread(BreadType bread) {
            this.bread = bread;
            return this;
        }

        public SandwichBuilder setFilling(FilingType filling) {
            this.filling = filling;
            return this;
        }

        public SandwichBuilder setSpread(SpreadType spread) {
            this.spread = spread;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }
    }
}
