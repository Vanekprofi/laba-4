package ru.shul.points;

public class Point implements Cloneable {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode(){ return 31 * x + y; }

    @Override
    public String toString(){ return "{"+x+"; "+y+"}"; }

    @Override
    public Point clone(){
        return new Point(x,y);
    }
}
