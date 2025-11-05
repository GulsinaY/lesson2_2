package org.example.lesson2_4;

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amound) {
        if (amound > 0) {
            foodAmount += amound;
            System.out.println("В миску добавлено " + amound + " еды. Теперь в миске: " + " еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}