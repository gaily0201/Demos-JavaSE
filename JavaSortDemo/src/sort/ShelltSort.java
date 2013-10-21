package sort;   
  
import java.util.Comparator;   
  
/**  
 * ϣ�������㷨  
 * @author jzj  
 * @date 2009-12-5  
 *   
 * @param <E>  
 */  
public class ShelltSort<E extends Comparable<E>> extends Sort<E> {   
  
    /**  
     * �����㷨��ʵ�֣���������ָ����Ԫ�ؽ�������  
     * @param array �����������  
     * @param from �����￪ʼ����  
     * @param end �ŵ�����  
     * @param c �Ƚ���  
     */  
    public void sort(E[] array, int from, int end, Comparator<E> c) {   
        //��ʼ������ʵ��Ϊÿ�ֵķ�����   
        int step = initialStep(end - from + 1);   
  
        //��һ��ѭ���Ƕ������ִν���ѭ����(step + 1) / 2 - 1 Ϊ��һ�ֲ���ֵ   
        for (; step >= 1; step = (step + 1) / 2 - 1) {   
            //��ÿ�����ÿ���������ѭ��   
            for (int groupIndex = 0; groupIndex < step; groupIndex++) {   
  
                //��ÿ�����ֱ�Ӳ�������   
                insertSort(array, groupIndex, step, end, c);   
            }   
        }   
    }   
  
    /**  
     * ֱ�Ӳ�������ʵ��  
     * @param array ����������  
     * @param groupIndex ��ÿ�ֵ���һ���������  
     * @param step ����  
     * @param end ��������Ҫ���ĸ�Ԫ��ֹ  
     * @param c �Ƚ���  
     */  
    private void insertSort(E[] array, int groupIndex, int step, int end, Comparator<E> c) {   
        int startIndex = groupIndex;//�����￪ʼ����   
        int endIndex = startIndex;//�ŵ�����   
        /*  
         * �ŵ�������Ҫ����õ����ӿ�ʼ����Ԫ�ؿ�ʼ����step�������������Ԫ���Ƿ������鷶Χ�ڣ�  
         * ��������鷶Χ�ڣ������ѭ����ֱ�������������鷶Χ  
         */  
        while ((endIndex + step) <= end) {   
            endIndex += step;   
        }   
  
        // iΪÿС����ĵڶ���Ԫ�ؿ�ʼ   
        for (int i = groupIndex + step; i <= end; i += step) {   
            for (int j = groupIndex; j < i; j += step) {   
                E insertedElem = array[i];   
                //��������������һ��Ԫ�ؿ�ʼ���ҵ�һ�����ڴ������Ԫ��   
                if (c.compare(array[j], insertedElem) >= 0) {   
                    //�ҵ������󣬴Ӳ���㿪ʼ�������Ԫ�غ���һλ   
                    move(array, j, i - step, step);   
                    array[j] = insertedElem;   
                    break;   
                }   
            }   
        }   
    }   
  
    /**  
     * �������鳤�����ʼ����  
     *   
     * ����ѡ�񲽳��Ĺ�ʽΪ��2^k-1,2^(k-1)-1,...,15,7,3,1 ������2^k ��һ��Ϊ�ò������У�k  
     * Ϊ�����ִ�  
     *   
     * ��ʼ������step = 2^k-1   
     * ��ʼ����Լ��������step < len - 1 ��ʼ������ֵҪС�����鳤�Ȼ�Ҫ��һ��ֵ����  
     * Ϊ��һ�ַ���ʱ������Ҫ��Ϊһ�飬�������鱾��ĳ��Ⱦ�С�ڵ���4��  
     *   
     * ������������ϵ�Կ��Ե�֪��2^k - 1 < len - 1 ��ϵʽ������kΪ�ִΣ������ 2^k �� ��ʽ  
     * ת���� step ���ʽ���� 2^k-1 ��ʹ�� (step + 1)*2-1 �滻����Ϊ step+1 �൱�ڵ�k-1  
     * �ֵĲ����������� step+1 �����ϳ��� 2 ���൱�� 2^k �ˣ��������������鳤�ȵĹ�ϵ����ʽΪ  
     * (step + 1)*2 - 1 < len -1  
     *   
     * @param len ���鳤��  
     * @return  
     */  
    private static int initialStep(int len) {   
        /*  
         * ��ʼֵ����Ϊ������ʽ�е���С����������С�����Ƶ������ʼ����ֵ�����������¹�ʽ����:  
         * 1,3,7,15,...,2^(k-1)-1,2^k-1  
         * ������鳤��С�ڵ���4ʱ������Ϊ1��������С�ڵ���4�����鲻�ҷ��飬��ʱֱ���˻�Ϊֱ�Ӳ�  
         * ������  
         */  
        int step = 1;   
  
        //��̽��һ�������Ƿ�������������������������򲽳���Ϊ��һ����   
        while ((step + 1) * 2 - 1 < len - 1) {   
            step = (step + 1) * 2 - 1;   
        }   
  
        System.out.println("��ʼ���� - " + step);   
        return step;   
    }   
  
    /**  
     * ����  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 8, 2, 6, 3, 7, 10 };   
        ShelltSort<Integer> shellSort = new ShelltSort<Integer>();   
        Sort.testSort(shellSort, intgArr);   
        Sort.testSort(shellSort, null);   
    }   
}   
