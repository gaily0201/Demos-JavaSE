package sort;   
  
import java.util.Arrays;   
import java.util.Comparator;   
import java.util.Random;   
  
/**  
 * ����ӿڣ����е������㷨��Ҫ�̳иó����࣬����Ҫ�������е�  
 * Ԫ��Ҫ���бȽ�������������Ԫ����ʵ����Comparable�ӿ�  
 *   
 * @author jzj  
 * @date 2009-12-5  
 *  
 * @param <E>  
 */  
public abstract class Sort<E extends Comparable<E>> {   
  
    public final Comparator<E> DEFAULT_ORDER = new DefaultComparator();   
    public final Comparator<E> REVERSE_ORDER = new ReverseComparator();   
  
    /**  
     * �����㷨����ʵ�֣���������ָ����Ԫ�ؽ�������  
     * @param array ����������  
     * @param from ������  
     * @param end �ŵ�����  
     * @param c �Ƚ���
     */  
    public abstract void sort(E[] array, int from, int end, Comparator<E> c);   
  
    /**  
     * ��������ָ�����ֽ�������  
     * @param from ������  
     * @param len �ŵ�����  
     * @param array ����������  
     * @param c �Ƚ���  
     */  
    public void sort(int from, int len, E[] array, Comparator<E> c) {   
        sort(array, 0, array.length - 1, c);   
    }   
  
    /**  
     * ����������������򣬿���ʹ���Լ�������Ƚ�����Ҳ��ʹ�ø����ṩ�������Ƚ���  
     * @param array ����������  
     * @param c �Ƚ���  
     */  
    public final void sort(E[] array, Comparator<E> c) {   
        sort(0, array.length, array, c);   
    }   
  
    /**  
     * ����������������򣬲���Ĭ������Ƚ���  
     * @param array ����������  
     */  
    public final void sort(E[] array) {   
        sort(0, array.length, array, this.DEFAULT_ORDER);   
    }   
  
    //Ĭ�ϱȽ�����һ��Ϊ���򣬵��Ƿ��������򻹵ÿ�E������ʵ��Comparable�ӿڵģ�   
    private class DefaultComparator implements Comparator<E> {   
        public int compare(E o1, E o2) {   
            return o1.compareTo(o2);   
        }   
    }   
  
    //����Ƚ���������պ���Ĭ�ϱȽ����෴   
    private class ReverseComparator implements Comparator<E> {   
        public int compare(E o1, E o2) {   
            return o2.compareTo(o1);   
        }   
    }   
  
    /**  
     * ���������е�����Ԫ�ص�λ��  
     * @param array ������������  
     * @param i ��һ��Ԫ��  
     * @param j �ڶ���Ԫ��  
     */  
    protected final void swap(E[] array, int i, int j) {   
        if (i != j) {//ֻ�в���ͬһλ��ʱ���轻��   
            E tmp = array[i];   
            array[i] = array[j];   
            array[j] = tmp;   
        }   
    }   
  
    /**  
     * ����Ԫ�غ���  
     * @param array ���ƶ�������  
     * @param startIndex ���ĸ���ʼ��  
     * @param endIndex ���ĸ�Ԫ��ֹ  
     */  
    protected final void move(E[] array, int startIndex, int endIndex) {   
        for (int i = endIndex; i >= startIndex; i--) {   
            array[i + 1] = array[i];   
        }   
    }   
  
    /**  
     * ��ָ���Ĳ���������Ԫ�غ��ƣ�����ָ��ÿ��Ԫ�ؼ�ļ��  
     * @param array ����������  
     * @param startIndex �����￪ʼ��  
     * @param endIndex ���ĸ�Ԫ��ֹ  
     * @param step ����  
     */  
    protected final void move(E[] array, int startIndex, int endIndex, int step) {   
        for (int i = endIndex; i >= startIndex; i -= step) {   
            array[i + step] = array[i];   
        }   
    }   
  
    //���Է���   
    @SuppressWarnings("unchecked")   
    public static final <E extends Comparable<E>> void testSort(Sort<E> sorter, E[] array) {   
  
        if (array == null) {   
            array = randomArray();   
        }   
        //Ϊ�˵ڶ��������追��һ��   
        E[] tmpArr = (E[]) new Comparable[array.length];   
        System.arraycopy(array, 0, tmpArr, 0, array.length);   
  
        System.out.println("Դ - " + Arrays.toString(tmpArr));   
  
        sorter.sort(array, sorter.REVERSE_ORDER);   
        System.out.println("�� - " + Arrays.toString(array));   
  
        sorter.sort(tmpArr, sorter.DEFAULT_ORDER);   
        System.out.println("�� - " + Arrays.toString(tmpArr));   
    }   
  
    //�����������   
    @SuppressWarnings("unchecked")   
    private static <E extends Comparable<E>> E[] randomArray() {   
        Random r = new Random(System.currentTimeMillis());   
        Integer[] a = new Integer[r.nextInt(30)];   
        for (int i = 0; i < a.length; i++) {   
            a[i] = new Integer(r.nextInt(100));   
        }   
        return (E[]) a;   
    }   
} 