/**
 * @author xiaopantx
 */
public class Main {

    public static void main(String[] args) {
        // System.out.println("test");
        int[] data = {29, 14, 100, 30, 2, 1, 99};
        int index = Main.search(data, 20);
        System.out.println("index = " + index);

        index = Main.search(data, 1);
        System.out.println("index = " + index);
    }

    public static int search(int[] data, int key) {
        if (data == null || data.length == 0) {
            return -1;
        }

        for (int index = 0; index < data.length; index++) {
            if (data[index] == key) {
                return index;
            }
        }

        return -1;
    }
}
