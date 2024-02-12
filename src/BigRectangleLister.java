import java.awt.*;
import java.util.ArrayList;
import java.util.List;





public class BigRectangleLister {

    public static void main(String[] args) {
        List<Rectangle> rectangles = createRectangles();
        List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());
        System.out.println("Big rectangles:");
        for (Rectangle rectangle : bigRectangles) {
            System.out.println(recttostring(rectangle));
        }
    }
    public static List<Rectangle> createRectangles() {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(1, 3));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(6, 7));
        rectangles.add(new Rectangle(9, 2));
        rectangles.add(new Rectangle(7, 11));
        rectangles.add(new Rectangle(4, 12));
        rectangles.add(new Rectangle(7, 10));
        rectangles.add(new Rectangle(2, 8));
        rectangles.add(new Rectangle(5, 7));
        return rectangles;
    }



    //collects all rectangles that pass the filter
    public static List<Rectangle> collectAll(List<Rectangle> rectangles, Filter filter)
    {
        List<Rectangle> result = new ArrayList<>();
        for (Rectangle rectangle : rectangles)
        {
            if (filter.accept(rectangle))
            {
                result.add(rectangle);
            }
        }
        return result;
    }

    //converts a rectangle to a string
    public static String recttostring(Rectangle rectangle)
    {
        return "Rectangle width= " + rectangle.getWidth() + ", height= " + rectangle.getHeight();
    }
}