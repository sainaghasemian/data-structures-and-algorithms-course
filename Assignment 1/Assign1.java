
import java.lang.Math;
import java.io.FileWriter;
import java.io.IOException;
//@author Saina Ghasemian-Roudsari
//UCID:30113011
//@version 2.3
//@since 1.0


public class Assign1 {
    
    public static void main(String args[]) throws Exception 
    {
        int arg1 = args.length;
        int size;
        int order = 0;

        if(arg1 < 1){
            System.out.println("Error, size must be greater than 1");
            System.exit(1);
        }

        if((args[0].toLowerCase().compareTo("ascending") != 0) && (args[0].toLowerCase().compareTo("descending") != 0) && (args[0].toLowerCase().compareTo("random") != 0)){
        
            System.out.println("Error, order not found, order must be either:ascending, descending, or random");
        }

        //For checking users algorithm input:
        if (args[2].equalsIgnoreCase("insertion") || args[2].equalsIgnoreCase("selection") || args[2].equalsIgnoreCase("merge") || args[2].equalsIgnoreCase("quick"))
            ;
        else
            throw new Exception("Error algorithm not found, algorithm must be either: insertion, selection, merge or quick");
        //Size is the number of items in the integer array to be sorted
        size = Integer.parseInt(args[1]);

        if (args[3].contains(".txt") == false){
            args[3]+= ".txt"; 
        } 
        //To create the output file

        if (args[0].toLowerCase().compareTo("ascending") == 0)
            order = 1;
        else if (args[0].toLowerCase().compareTo("descending") == 0)
            order = 2;
        else if (args[0].toLowerCase().compareTo("random") ==0)
            order = 3; 
        //arg3 contains txt file
        

        Assign1 x = new Assign1(); 

        int[] array = x.create_intarray(size, order);
        //Making an array

        if(args[2].equalsIgnoreCase("insertion"))
        {
            System.out.println("Insertion Sort:");
            long startTime = System.nanoTime();
            x.insertion_sort(array);
            long finalTime = System.nanoTime();
            long elapsedTime = finalTime - startTime;
            System.out.printf("Insertion sort complete. Time elapsed: " + elapsedTime/Math.pow(10, 9) + "s");
            write output = new write(args[3], size, array);
            output.fileWrite();
        }

        if(args[2].equalsIgnoreCase("selection"))
        {
            System.out.println("Selection Sort:");
            long startTime = System.nanoTime();
            x.selection_sort(array);
            long finalTime = System.nanoTime();
            long elapsedTime = finalTime - startTime;
            System.out.printf("Selection sort complete. Time elapsed: " + elapsedTime/Math.pow(10, 9) + "s");
            write output = new write(args[3], size, array);
            output.fileWrite();
        }

        if(args[2].equalsIgnoreCase("merge"))
        {
            System.out.println("Merge Sort:");
            long startTime = System.nanoTime();
            x.merge_sort(array, 0, array.length-1);
            long finalTime = System.nanoTime();
            long elapsedTime = finalTime - startTime;
            System.out.printf("Merge sort complete. Time elapsed: " + elapsedTime/Math.pow(10, 9) + "s");
            write output = new write(args[3], size, array);
            output.fileWrite();
        }

        if(args[2].equalsIgnoreCase("quick"))
        {
            System.out.println("Qucik Sort:");
            long startTime = System.nanoTime();
            x.quick_sort(array, 0, array.length-1);
            long finalTime = System.nanoTime();
            long elapsedTime = finalTime - startTime;
            System.out.printf("Quick sort complete. Time elapsed: " + elapsedTime/Math.pow(10, 9) + "s");
            write output = new write(args[3], size, array);
            output.fileWrite();
            
        }

    }
  

    //Selection Sort method refrence:
    //Sorintg.java from CPSC 319 D2L Shell
    public void selection_sort(int array[]) {
		int length = array.length;
		
		for(int i=0;i<length-1;i++) {
			int min_index = i; 
			for(int j=i+1;j<length;j++) {
				if(array[j]<array[min_index]) {
					min_index=j;
				}
			}
			int temp = array[min_index];
			array[min_index]=array[i];
			array[i]=temp;
		}
		
	}

    //Insertion Sort method refrence:
    //Sorintg.java from CPSC 319 D2L Shell
    public void insertion_sort(int array[]) {
		int length = array.length;
		
		for(int i=1;i<length;i++) {
			int key = array[i];
			int j = i-1;
			while(j>=0 && array[j]>key) {
				array[j+1]=array[j]; // Moving forward the current value 
				j=j-1;
			}
			array[j+1]=key;
		}
	}

    //Merge Sort method refrence:
    //https://www.geeksforgeeks.org/merge-sort/
    public void merge_sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        // Create temp arrays 
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        // Merge the temp arrays 
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Quick Sort method refrence:
    //https://stackabuse.com/quicksort-in-java/

    // A function to swap two elements (combining swap and partition)
    static int swap(int[] arr, int start, int end)
    {
        int pivot = end;
        int left = start; 
        for(int i = start; i < end; i++)
        {
            if(arr[i] < arr[pivot])
            {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                left++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = temp;
        return left;
    }

    public void quick_sort(int[] arr, int low, int high)
    {
        if (high <= low) return;
        int pivot = swap(arr, low, high);
        quick_sort(arr, low, pivot-1);
        quick_sort(arr, pivot+1, high);
    }
    
    public int[] create_intarray(int size, int random_order)
    {
        int[] int_array = new int[size];
        int random = Integer.MAX_VALUE;


        if(random_order == 1){
            for(int i = 0; i < int_array.length-1;i++){
                int_array[i] = i;
            }
        }
        else if(random_order ==2){
            for(int i = 0; i < int_array.length-1;i++){
                int_array[i] = int_array.length - i;
            }
        }
        else if(random_order ==3){
        for(int i = 0; i < int_array.length; i++){
            int_array[i] = (int)Math.random() * random;
        }
    }
        return int_array;
    }

}

class write{
private String file = new String();
private int size;
private int[] array = new int[size];
    public write(String file, int size, int[] array){
        this.file = file;
        this.size = size;
        this.array = array; 
    }

    public void fileWrite() 
    {
        try{
            FileWriter write = new FileWriter(this.file);
            for(int i: this.array){
                write.write(Integer.toString(i) + "\r\n");
            }
            write.close();
        } catch (IOException OutputFileHasError){
            OutputFileHasError.printStackTrace();
        }
    }
}