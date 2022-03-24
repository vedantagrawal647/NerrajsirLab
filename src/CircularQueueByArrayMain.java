/*
Q. Reverse the First K Elements in the Queue

For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.




Input Format :
The first line of input would contain two integers N and K, separated by a single space. They denote the total number of elements in the queue and the count with which the elements need to be reversed respectively.

The second line of input contains N integers separated by a single space, representing the order in which the elements are enqueued into the queue.
Output Format:
The only line of output prints the updated order in which the queue elements are dequeued, all of them separated by a single space.
Note:
You are not required to print the expected output explicitly, it has already been taken care of. Just make the changes in the input queue itself.
Contraints :
1 <= N <= 10^6
1 <= K <= N
-2^31 <= data <= 2^31 - 1

Sample Input 1:
5 3
1 2 3 4 5
Sample Output 1:
3 2 1 4 5
Sample Input 2:
7 7
3 4 2 5 6 7 8
Sample Output 2:
8 7 6 5 2 4 3
 */
import java.util.Scanner;
class StackWIthArray {
    int arr[];
    int top;

    StackWIthArray(int size)
    {
        arr=new int[size];
        top=-1;
    }

    public boolean isStackFull()
    {
        return (top==arr.length-1) ;
    }

    public boolean isStackEmpty()
    {
        return (top==-1);
    }

    public void isPush( int value)
    {
        if(isStackFull())
        {
            System.out.println("Stack overflow");
        }
        else
        {
            top=top+1;
            arr[top]=value;
        }
    }

    public  void isPop()
    {
        if(isStackEmpty())
        {
            System.out.println("Under Flow");
        }
        else
        {
            arr[top]=0;
            top=top-1;
        }
    }

    public void display()
    {

        int i=top;
        while(i>=0)
        {
            System.out.println(arr[i]);
            i=i-1;
        }
    }

    public void reverseDisplay()
    {
        int i=arr.length-top-1;
        while(i<=top)
        {
            System.out.println(arr[i]);
            i=i+1;
        }
    }
}
class CircularQueueByArray {
    int arr[];
    int size;
    int beginning;
    int top;
    public CircularQueueByArray(int size)
    {
        arr= new int[size];
        this.size = size;
        beginning = -1;
        top = -1;
    }
    public boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isFull()
    {
        if(top+1 == beginning)
        {
            return true;
        }
        else if((beginning== 0) && (top+1 == size))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void enqueue(int value)
    {

        if(isFull())
        {
            System.out.println("overflow");
        }
        else if(isEmpty())
        {
            beginning = 0 ;
            top ++;
            arr[beginning] = value;
        }
        else
        {
            if(top+1 == size)
            {
                top= 0;
            }
            else
            {
                top++;
            }
            arr[top]= value;
        }

    }

    public  void dequeue()
    {
        if(isEmpty())
        {

            System.out.println("Empty");
        }
        else
        {

            if(beginning == top)
            {
                beginning= top = -1;
            }
            else if(beginning+1 == size) {
                beginning = 0;
            }
            else
            {
                beginning++;
            }

        }
    }
    public void traverse()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
public class CircularQueueByArrayMain {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        StackWIthArray obj1=new StackWIthArray(k);
        CircularQueueByArray obj=new CircularQueueByArray(n);
        for(int i=0;i<n;i++)
        {
            obj.enqueue(s.nextInt());
        }
        for(int i=0;i<k;i++)
        {
            obj1.isPush(obj.arr[obj.beginning]);
            obj.dequeue();
        }

        for(int i=0;i<k;i++)
        {
            obj.enqueue(obj1.arr[obj1.top]);
            obj1.isPop();
        }
        obj.traverse();



    }}