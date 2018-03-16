package q02;

import java.util.Objects;

public class Combination {
    private int restOfWeight;
    private int itemChosen;

    public Combination() {
    }

    public Combination(int restOfWeight, int itemChosen) {
        this.restOfWeight = restOfWeight;
        this.itemChosen = itemChosen;
    }

    public int getRestOfWeight() {
        return restOfWeight;
    }

    public void setRestOfWeight(int restOfWeight) {
        this.restOfWeight = restOfWeight;
    }

    public int getItemChosen() {
        return itemChosen;
    }

    public void setItemChosen(int itemChosen) {
        this.itemChosen = itemChosen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return restOfWeight == that.restOfWeight &&
                itemChosen == that.itemChosen;
    }

    @Override
    public int hashCode() {

        return Objects.hash(restOfWeight, itemChosen);
    }
}
