import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;




public class BigRectangleLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = createRectangles();
        List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());
        System.out.println("Large rectangles:");
        for (Rectangle rectangle : bigRectangles) {
            System.out.println(recttostring(rectangle));
        }
    }


    public static List<Rectangle> createRectangles() {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2, 5));
        rectangles.add(new Rectangle(8, 12));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(6, 9));
        return rectangles;
    }


    public static List<Rectangle> collectAll(List<Rectangle> rectangles, Filter filter) {
        List<Rectangle> result = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                result.add(rectangle);
            }
        }
        return result;
    }

    public static String recttostring(Rectangle rectangle) {
        return "Rectangle[width= " + rectangle.getWidth() + ", height= " + rectangle.getHeight() + "]";
    }
}