package com.leonenko.epi._13_sort;

/**
 * Created by Alex on 5/12/2017.
 */
public class _132_MergeSortedArrays {

    static void mergeIntoBig(int[] smallArray, int[] bigArray) {
        var bigIdx = bigArray.length - smallArray.length - 1;
        var smallIdx = smallArray.length - 1;
        var writeIdx = bigArray.length - 1;

        while (bigIdx >= 0 && smallIdx >= 0) {
            bigArray[writeIdx--] = smallArray[smallIdx] > bigArray[bigIdx]
                    ? smallArray[smallIdx--] : bigArray[bigIdx--];
        }

        while (smallIdx >= 0) {
            bigArray[writeIdx--] = smallArray[smallIdx--];
        }
    }

}
