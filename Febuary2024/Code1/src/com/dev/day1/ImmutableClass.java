package com.dev.day1;

public final class ImmutableClass implements Cloneable {

    private final int data;

    public int getData() {
        return data;
    }

    public ImmutableClass(int data) {
        this.data = data;
    }

    // Shallow clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep clone
    public ImmutableClass deepClone() {
        return new ImmutableClass(this.data);
    }

    @Override
    public int hashCode() {
        // Use a simple algorithm for hashCode, you can customize based on your requirements
        return Integer.hashCode(data);
    }

    public static void main(String[] args) {
        ImmutableClass original = new ImmutableClass(42);

        try {
            // Shallow cloning
            ImmutableClass shallowClone = (ImmutableClass) original.clone();

            // Deep cloning
            ImmutableClass deepClone = original.deepClone();

            System.out.println("Original data: " + original.getData());
            System.out.println("Shallow Cloned data: " + shallowClone.getData());
            System.out.println("Deep Cloned data: " + deepClone.getData());

            // Check hash codes
            System.out.println("Original hashCode: " + original.hashCode());
            System.out.println("Shallow Clone hashCode: " + shallowClone.hashCode());
            System.out.println("Deep Clone hashCode: " + deepClone.hashCode());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
