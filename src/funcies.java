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

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(1);
        q.insert(8);
        q.insert(4);
        q.insert(3);
        q.insert(2);
        q = removeOdd(q);
        System.out.println(q);
        System.out.println(exists(q, 4));
        System.out.println(length(q));
    }

}
