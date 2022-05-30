package curriculum.C9;

// https://leetcode.com/problems/rectangle-area/description/
public class RectangleArea {
    public static void main(String[] args) {
        int ax1 = -3262, ay1 = 5364, ax2 = -3257, ay2 = 5375, bx1 = -3264, by1 = 5364, bx2 = -3259, by2 = 5375;
        System.out.println(new RectangleArea().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlapArea = Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0)
                * Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);

        System.out.println(area1 + ", " + area2 + ", " + overlapArea);

        return area1 + area2 - overlapArea;
    }
}
