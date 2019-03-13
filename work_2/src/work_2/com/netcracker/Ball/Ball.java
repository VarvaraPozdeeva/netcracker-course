package work_2.com.netcracker.Ball;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction){
        this.x = x;
        this.y = y;
        this.radius = radius;

        xDelta =(float)( speed * Math.cos(direction));
        yDelta = (float)((-1) * speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public  void move(){
        x+= xDelta;
        y+= yDelta;
    }
    public  void reflectHorizontal(){
        xDelta = -xDelta;
    }
    public void reflectVertical(){
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x +"," + y +
                "), speed=(" + xDelta +", " + yDelta +")]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Ball ball = (Ball) o;
        return Float.compare(ball.x, x) == 0 &&
                Float.compare(ball.y, y) == 0 &&
                radius == ball.radius &&
                Float.compare(ball.xDelta, xDelta) == 0 &&
                Float.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode += 31*hashcode + Float.floatToIntBits(x);
        hashcode += 31*hashcode + Float.floatToIntBits(y);
        hashcode += 31*hashcode + Float.floatToIntBits(xDelta);
        hashcode += 31*hashcode + Float.floatToIntBits(yDelta);
        hashcode += 31*hashcode + radius;
        return hashcode;
    }
}
