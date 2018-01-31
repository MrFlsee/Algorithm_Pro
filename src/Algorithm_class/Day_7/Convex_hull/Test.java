package Algorithm_class.Day_7.Convex_hull;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(ccw(new xy(0,0), new xy(1,0), new xy(1,-1)));
    }

    static long ccw(xy a, xy b, xy c) {
        return a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
    }
    static class xy {
        long x;
        long y;

        public xy(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
