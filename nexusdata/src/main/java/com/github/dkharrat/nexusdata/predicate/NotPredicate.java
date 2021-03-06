package com.github.dkharrat.nexusdata.predicate;

public class NotPredicate implements Predicate {
    private final Predicate predicate;

    public NotPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Boolean evaluate(Object object) {
        return !predicate.evaluate(object);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotPredicate that = (NotPredicate) o;

        if (!predicate.equals(that.predicate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ~predicate.hashCode();
    }
}