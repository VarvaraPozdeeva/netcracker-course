package work_2.com.netcracker.Ball;

import work_2.com.netcracker.Ball.Ball;

import java.util.Objects;

public class Container {
    private int x1;
    private int y1;
    private  int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }
    public  int getWidth(){
        return x2-x1;
    }
    public int getHeight(){
        return y2-y1;
    }
    public boolean collides(Ball ball){
        int radius = ball.getRadius();
        if((ball.getX() - radius) > x1 &&
           (ball.getX() + radius) < x2 &&
           (ball.getY() - radius) > y1 &&
           (ball.getY() + radius) < y2)
            return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Container container = (Container) o;
        return x1 == container.x1 &&
                y1 == container.y1 &&
                x2 == container.x2 &&
                y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode += 31*hashcode + x1;
        hashcode += 31*hashcode + x2;
        hashcode += 31*hashcode + y1;
        hashcode += 31*hashcode + y2;
        return hashcode;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 +"," + y1 +
                "),(" + x2 +"," + y2 + ")]";
    }
}
