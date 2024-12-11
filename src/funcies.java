public class funcies {
    public static Queue<Integer> removeOdd(Queue<Integer> q) {
        int n;
        Queue<Integer> nq = new Queue<>();
        while (!q.isEmpty()) {
            n = q.remove();
            if (n % 2 == 0)
                nq.insert(n);
        }
        return nq;
    }

    public static<T> Queue<T> copy(Queue<T> q)
    {
        Queue<T> c = new Queue<>(), a = new Queue<>();
        T n;
        while(!q.isEmpty())
        {
            n=q.remove();
            c.insert(n);
            a.insert(n);
        }
        while(!a.isEmpty())
        {
            q.insert(a.remove());
        }
        return c;
    }

    public static boolean exists(Queue<Integer> q, int n) {
        Queue<Integer> a = copy(q);
        int num;
        while (!a.isEmpty()) {
            num = a.remove();
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public static<T> void spilledOn(Queue<T> src, Queue<T> dst)
    {
        while(!src.isEmpty())
        {
            dst.insert(src.remove());
        }
    }

    public static void insertSorted(Queue<Integer> q, int x)
    {
        Queue<Integer> a = new Queue<>();
        while(!q.isEmpty() && q.head()<x)
            a.insert(q.remove());
        a.insert(x);
        spilledOn(q, a);
        spilledOn(a, q);
    }

    public static int length(Queue<Integer> q)
    {
        Queue<Integer> w = copy(q);
        int c = 0;
        while(!w.isEmpty())
        {
            w.remove();
            c++;
        }
        return c;
    }

    public static void threeInARow(Queue<Character> q)
    {
        char c;
        int count = 0;
        Queue<Character> w = new Queue<>();
        while(!q.isEmpty())
        {
            c = q.head();
            while(q.remove()==c)
                count++;
            if(count>=3)
            {
                for(int i = 0; i<count; i++)
                    w.insert(c);
            }
            count=0;
        }
        spilledOn(w, q);
    }

    public static Boolean mathSeries(Queue<Integer> q)
    {
                if (q.isEmpty() || q.head() == null) return true;

        Queue<Integer> w = copy(q);
        int dif, prev, first = w.remove();
        if (w.isEmpty()) return true; // Single element is an arithmetic series.
        int second = w.remove(); // Corrected to remove the second element
        dif = second - first;
        prev = second;

        while (!w.isEmpty()) {
            int current = w.remove();
            if (current - prev != dif) {
                return false;
            }
            prev = current;
        }
        return true;
    }

    public static void main(String[] args) {
//        Queue<Integer> q = new Queue<>();
//        q.insert(1);
//        q.insert(8);
//        q.insert(4);
//        q.insert(3);
//        q.insert(2);
//        q = removeOdd(q);
//        System.out.println(q);
//        System.out.println(exists(q, 4));
//        System.out.println(length(q));

        Queue<Character> testQueue1 = new Queue<>();
        testQueue1.insert('a');
        testQueue1.insert('a');
        testQueue1.insert('a');
        testQueue1.insert('b');
        testQueue1.insert('b');
        testQueue1.insert('c');

        System.out.println("Original Queue: " + testQueue1);
        threeInARow(testQueue1);
        System.out.println("Queue after threeInARow: " + testQueue1);

        // Test for mathSeries
        Queue<Integer> testQueue2 = new Queue<>();
        testQueue2.insert(2);
        testQueue2.insert(4);
        testQueue2.insert(6);
        testQueue2.insert(8);

        System.out.println("Arithmetic series test (should be true): " + mathSeries(testQueue2));

        Queue<Integer> testQueue3 = new Queue<>();
        testQueue3.insert(3);
        testQueue3.insert(6);
        testQueue3.insert(10);
        testQueue3.insert(13);

        System.out.println("Non-arithmetic series test (should be false): " + mathSeries(testQueue3));

        Queue<Integer> testQueue4 = new Queue<>();
        testQueue4.insert(5);
        System.out.println("Single element series test (should be true): " + mathSeries(testQueue4));

        Queue<Integer> testQueue5 = new Queue<>();
        System.out.println("Empty queue test (should be true): " + mathSeries(testQueue5));
    }

}
