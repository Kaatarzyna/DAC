package dac.task.exceptions;

public class ItemNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "Item not found";
    }

}
