import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;




//import java.awt.Rectangle;
public class BigRectangleLister {
    public static void main(String[] args)
    {
        List<Rectangle> rectangles = createRectangles();
        List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());
        System.out.println("Large rectangles:");
        for (Rectangle rectangle : bigRectangles)
        {
            System.out.println(recttostring(rectangle));
        }
    }

        //creates a list of rectangles
    public static List<Rectangle> createRectangles()
    {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2, 5));
        rectangles.add(new Rectangle(8, 12));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(6, 9));
        rectangles.add(new Rectangle(3, 5));
        rectangles.add(new Rectangle(1, 10));
        rectangles.add(new Rectangle(6, 5));
        rectangles.add(new Rectangle(7, 9));
        rectangles.add(new Rectangle(9, 4));
        rectangles.add(new Rectangle(7, 8));
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
        return "Rectangle[width= " + rectangle.getWidth() + ", height= " + rectangle.getHeight() + "]";
    }
}