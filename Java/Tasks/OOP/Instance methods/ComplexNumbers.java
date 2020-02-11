class Complex {

    double real;
    double image;

    public void add(Complex number) {
        real += number.real;
        image += number.image;
    }

    public void subtract(Complex number) {
        real -= number.real;
        image -= number.image;
    }
}
