
class Box<Dish> {

    private Dish dish;

    public void put(Dish dish) {
        this.dish = dish;
    }

    public Dish get() {
        return this.dish;
    }
}
