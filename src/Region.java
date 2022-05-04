
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region {
    public int x, y, width, height;

    public Region(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getMidX() {
        return this.x + this.width / 2;
    }

    public int getMidY() {
        return this.y + this.height / 2;
    }

    public int getBottom() {
        return this.y + this.height;
    }

    public int getRight() {
        return this.x + this.width;
    }

    public Region duplicate() {
        return new Region(x, y, width, height);
    }
}