package sort;   
  
import java.util.Comparator;   
  
/**  
 *  ֱ�Ӳ��������㷨  
 * @author jzj  
 * @date 2009-12-5  
 *   
 * @param <E>  
 */  
public class InsertSort<E extends Comparable<E>> extends Sort<E> {   
  
    /**  
     * �����㷨��ʵ�֣���������ָ����Ԫ�ؽ�������  
     * @param array �����������  
     * @param from �����￪ʼ����  
     * @param end �ŵ�����  
     * @param c �Ƚ���  
     */  
    public void sort(E[] array, int from, int end, Comparator<E> c) {   
  
        /*  
         * ��һ��ѭ�����Դ����루���򣩵�Ԫ�ؽ���ѭ��  
         * �Ӵ���������ϵĵڶ���Ԫ�ؿ�ʼѭ���������һ��Ԫ�أ�������ֹ  
         */  
        for (int i = from + 1; i <= end; i++) {   
            /*  
             * �ڶ���ѭ�����������������ѭ�����Ҵ������������һ��Ԫ�ؿ�ʼ���ѭ��  
             * �ҵ���һ�����ڴ������Ԫ��  
             * ���������ʼԪ��ֻ��һ������ΪԴ����ĵ�һ��Ԫ�أ�һ��Ԫ���������������  
             */  
            for (int j = 0; j < i; j++) {   
                E insertedElem = array[i];//�����뵽���������Ԫ��   
                //���������������һ��Ԫ�ؿ�ʼ���ҵ�һ�����ڴ������Ԫ��   
                if (c.compare(array[j], insertedElem) > 0) {   
                    //�ҵ������󣬴Ӳ���㿪ʼ�������Ԫ�غ���һλ   
                    move(array, j, i - 1);   
                    //��������Ԫ�ز��뵽����������   
                    array[j] = insertedElem;   
                    break;   
                }   
            }   
        }   
  
        //=======������java.util.Arrays�Ĳ��������㷨��ʵ��   
        /*  
         * ���㷨�������Ƚϼ��һj�㣬�е���ð���㷨��  
         * �������߼��Ϸֳ�ǰ���������ϣ�ǰ��ļ������Ѿ���������Ԫ�أ������漯��Ϊ�������  
         * ���ϣ�ÿ���ڲ�ѭ�Ӻ��漯�����ó�һ��Ԫ�أ�ͨ��ð�ݵ���ʽ����ǰ�漯�����һ��Ԫ�ؿ�  
         * ʼ��ǰ�Ƚϣ��������ǰ��Ԫ�ش��ں���Ԫ�أ��򽻻�������ѭ���˳�  
         *   
         * �ܸо����������е�ֹ֣���Ȼ�ǲ�������Ӧ�������ҵ�����㣬�����ٽ��������Ԫ�ز�  
         * �뵽�Ĳ�����ϣ���ô����Ԫ�ؾͱ�Ȼ����ƣ��о��㷨���������Ʋ�ƥ����������������ʵ  
         * �ֱȣ���ʵ��һ���ģ�ֻ���������Ҳ���㣬���ҵ���һ���Խ����Ԫ������ƣ������㷨ȴ  
         * ����һ����һ����һ��һ����������Ԫ����ǰ��  
         */  
        /*  
        for (int i = from; i <= end; i++) {  
            for (int j = i; j > from && c.compare(array[j - 1], array[j]) > 0; j--) {  
                swap(array, j, j - 1);  
            }  
        }  
        */  
    }   
  
    /**  
     * ����  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 1, 2, 6, 3, 8, 0, 7 };   
        InsertSort<Integer> insertSort = new InsertSort<Integer>();   
        Sort.testSort(insertSort, intgArr);   
        Sort.testSort(insertSort, null);   
    }   
}  
