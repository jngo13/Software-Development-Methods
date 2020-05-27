// LAB 9: Recursion, Pt. 1

public class Recursion {
    
    public static void main(String[] args) 
    {
        int[] values = {19, 12, 13, 14, 17, 18, 16, 14, 11};
        int[] maxMinResults = maxMin(values, 0, values.length - 1);
        System.out.println(maxMinResults[0] + " and " + maxMinResults[1]);
    }

    /*  maxMin() - Return an array containing the minimum and maximum values of the input array.
     *  @param list: an array of ints as input
     *  @param first: the first index of the list (for recursion)
     *  @param last: the last index of the list (for recursion)
     *  
     *  Identify a base case, and work it out so that the array returns the min and max values.
     *  Then, identify what the method does to recursively arrive at the base case.
     *  
     *  @return: an int array, one index is minimum and the other is the maximum value.
     */
    public static int[] maxMin(int[] list, int first, int last){
        
        if(first>=last) {
            return new int[] {list[first], list[first]};
        }
        
        if(first==last-1) {
            if(list[first]<list[last]) 
                return new int[] {list[first],list[last]};
            else
                return new int[] {list[last],list[first]};
            }
        
        int[] firstHalf = maxMin(list, first, (last+first)/2);
        int[] secondHalf = maxMin(list, ((last+first)/2) +1, last);
        
        int[] maxMinArray = new int[] {Math.min(firstHalf[0], secondHalf[0]), Math.max(firstHalf[1], secondHalf[1])};
        return maxMinArray;
        
        }
    }
