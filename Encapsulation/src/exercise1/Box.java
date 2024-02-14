package exercise1;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length); //umesto direktnog postavljanja vrednosti pozivamo set metode zato sto one u sebi sadrze validaciju
        this.setWidth(width);
        this.setHeight(height);

    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if(length <= 0){ //validacija, da li je duzina manja ili jednaka 0 (sto je zabranjeno)
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
    //Surface Area = 2*l*w + 2*l*h + 2*w*h
    public double calculateSurfaceArea(){
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    //Lateral Surface Area = 2*l*h + 2*w*h

    public double calculateLateralSurfaceArea(){
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    //Volume = l*w*h

    public double calculateVolume(){
        return this.length * this.width * this.height;
    }
}
