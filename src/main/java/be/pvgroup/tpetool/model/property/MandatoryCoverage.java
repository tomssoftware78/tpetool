package be.pvgroup.tpetool.model.property;

import java.math.BigDecimal;

public class MandatoryCoverage {

    private BigDecimal liability;
    private BigDecimal contents;
    private BuildingEvaluation buildingEvaluation;

    public BigDecimal getLiability() {
        return liability;
    }

    public void setLiability(BigDecimal liability) {
        this.liability = liability;
    }

    public BigDecimal getContents() {
        return contents;
    }

    public void setContents(BigDecimal contents) {
        this.contents = contents;
    }

    public BuildingEvaluation getBuildingEvaluation() {
        return buildingEvaluation;
    }

    public void setBuildingEvaluation(BuildingEvaluation buildingEvaluation) {
        this.buildingEvaluation = buildingEvaluation;
    }

    @Override
    public String toString() {
        return "MandatoryCoverage{" +
                "liability=" + liability +
                ", contents=" + contents +
                ", buildingEvaluation=" + buildingEvaluation +
                '}';
    }

    public static final class MandatoryCoverageBuilder {
        private BigDecimal liability;
        private BigDecimal contents;
        private BuildingEvaluation buildingEvaluation;

        private MandatoryCoverageBuilder() {
        }

        public static MandatoryCoverageBuilder aMandatoryCoverage() {
            return new MandatoryCoverageBuilder();
        }

        public MandatoryCoverageBuilder withLiability(BigDecimal liability) {
            this.liability = liability;
            return this;
        }

        public MandatoryCoverageBuilder withContents(BigDecimal contents) {
            this.contents = contents;
            return this;
        }

        public MandatoryCoverageBuilder withBuildingEvaluation(BuildingEvaluation buildingEvaluation) {
            this.buildingEvaluation = buildingEvaluation;
            return this;
        }

        public MandatoryCoverage build() {
            MandatoryCoverage mandatoryCoverage = new MandatoryCoverage();
            mandatoryCoverage.setLiability(liability);
            mandatoryCoverage.setContents(contents);
            mandatoryCoverage.setBuildingEvaluation(buildingEvaluation);
            return mandatoryCoverage;
        }
    }
}
