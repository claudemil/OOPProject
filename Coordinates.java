record Coordinates(double x, double y) {
    public double distanceTo(Coordinates coordinate){
        return Math.sqrt(Math.pow(coordinate.x - x, 2) + Math.pow(coordinate.y - y, 2));
    }

}
