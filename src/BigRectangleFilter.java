import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    //accepts a rectangle if its perimeter is greater than 10
    public boolean accept(Object x)
    {
        //if x is not a rectangle, return false
        if (!(x instanceof Rectangle rectangle))
        {
            return false;
        }
        return (2 * (rectangle.getWidth() + rectangle.getHeight())) > 10;
    }
}