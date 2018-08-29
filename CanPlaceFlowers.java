/**
 * Created by anshul on 29/08/18.
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, i = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(c.canPlaceFlowers(new int[]{0}, 0));

    }
}
