package fr.ubordeaux.ao.domain.type;

import java.util.Objects;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ddd.annotations.classes.ValueObject;
import fr.ubordeaux.ddd.annotations.fields.Immutable;
import fr.ubordeaux.ddd.annotations.methods.Getter;
import fr.ubordeaux.ddd.annotations.methods.Setter;

@ValueObject
public class Price {
    @Immutable
    private int valueInEuroCents;

    public Price(int valueInEuroCents) {
        this.setPrice(valueInEuroCents);
    }

    @Setter
    public void setPrice(int valueInEuroCents) {
        if (valueInEuroCents < 0) throw new ReferenceManagementException("prices are in Euro Cents, and therefore must be positive");
        this.valueInEuroCents = valueInEuroCents;
    }

    @Getter
    public int getPrice() {
        return this.valueInEuroCents;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Price)) return false;
        return  ((Price)other).valueInEuroCents == valueInEuroCents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueInEuroCents);
    }

    @Override
    public String toString() {
        return String.valueOf(this.valueInEuroCents);
    }
}