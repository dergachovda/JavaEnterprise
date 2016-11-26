package bugs.bug_4_RectanglePlus_class_should_not_be_abstract;

public class RectanglePlus implements Relatable {

    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public RectanglePlus() {
        origin = new Point(0, 0);
    }

    public RectanglePlus(Point p) {
        origin = p;
    }

    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }

    public RectanglePlus(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method required to implement
    // the Relatable interface
    public int isLarger(Relatable other) {
        RectanglePlus otherRect
                = (RectanglePlus) other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "RectanglePlus{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Relatable relatable = new RectanglePlus(3,2);
        Relatable relatable2 = new RectanglePlus(4,1);
        switch (relatable.isLarger(relatable2)) {
            case -1:
                System.out.println(relatable2 + " - is larger");
                break;
            case 1:
                System.out.println(relatable + " - is larger");
                break;
            case 0:
                System.out.println("are equal");
                break;
        }
    }
}

class Point {
    int top;
    int left;
    int x;
    int y;

    public Point(int t, int l) {
        top = t;
        left = l;
    }
}
