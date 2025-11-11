package org.example.lesson2_4;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public int getMaxRunDistance() {
        return 200;
    }

    @Override
    public int getMaxSwimDistance() {
        return 0;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (foodAmount <= 0) {
            System.out.println(name + ": количество еды должно быть положительным");
            return;
        }
        if (bowl.decreaseFood(foodAmount)) {
            isFull = true;
            System.out.println(name + "поел" + foodAmount + " еды и теперь сыт");
        } else {
            System.out.println(name + ": в миске недостаточно еды. Необходимо: " + foodAmount + " Доступно: " + bowl.getFoodAmount());
        }
    }

    public void eat(Bowl bowl) {
        eat(bowl, 10);
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}