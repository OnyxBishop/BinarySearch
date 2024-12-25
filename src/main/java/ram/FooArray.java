package ram;

import java.util.Comparator;

public class FooArray {

    //region byte[]
    public static int binarySearch(byte[] a, byte key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            byte middleValue = a[middle];

            if (middleValue < key)
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }
    //endregion

    //region char[]
    public static int binarySearch(char[] a, char key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            char middleValue = a[middle];

            if (middleValue < key)
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }
    //endregion[][]

    //region double[]
    public static int binarySearch(double[] a, double key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            double middleValue = a[middle];

            if (middleValue < key || Double.isNaN(middleValue))
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else {
                long middleBits = Double.doubleToLongBits(middleValue);
                long keyBits = Double.doubleToLongBits(key);
                if (middleBits == keyBits)
                    return middle;
                else if (middleBits < keyBits)
                    low = middle + 1;
                else
                    high = middle - 1;
            }
        }
        return -(low + 1);
    }
    //endregion

    //region float[]
    public static int binarySearch(float[] a, float key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            float middleValue = a[middle];

            if (middleValue < key || Float.isNaN(middleValue))
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else {
                int middleBits = Float.floatToIntBits(middleValue);
                int keyBits = Float.floatToIntBits(key);
                if (middleBits == keyBits)
                    return middle;
                else if (middleBits < keyBits)
                    low = middle + 1;
                else
                    high = middle - 1;
            }
        }
        return -(low + 1);
    }
    //endregion

    //region int[]
    public static int binarySearch(int[] a, int key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            int middleValue = a[middle];

            if (middleValue < key)
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }

    public static int binarySearch(long[] a, long key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            long middleValue = a[middle];

            if (middleValue < key)
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }
    //endregion

    //region short[]
    public static int binarySearch(short[] a, short key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            short middleValue = a[middle];

            if (middleValue < key)
                low = middle + 1;
            else if (middleValue > key)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }
    //endregion

    //region Comparator
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        if (c == null)
            throw new NullPointerException("Comparator cannot be null");

        rangeCheck(a.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            T middleValue = a[middle];
            int cmp = c.compare(middleValue, key);

            if (cmp < 0)
                low = middle + 1;
            else if (cmp > 0)
                high = middle - 1;
            else
                return middle;
        }
        return -(low + 1);
    }
    //endregion

    private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > arrayLength)
            throw new ArrayIndexOutOfBoundsException(toIndex);
    }
}
