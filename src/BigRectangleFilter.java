import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (!(x instanceof Rectangle rectangle)) {
            return false;
        }
        return (2 * (rectangle.getWidth() + rectangle.getHeight())) > 10;
    }
}