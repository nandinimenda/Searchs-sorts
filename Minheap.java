import java.util.*;

class Minheap {
    int a[];
    int minsize;
    int heapsize;

    Minheap(int minsize) {
        heapsize = 0;
        this.minsize = minsize;
        a = new int[minsize];
    }

    int lchild(int i) {
        return 2 * i + 1;
    }

    int rchild(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void insert(int x) {
        if (minsize == heapsize) {
            System.out.println("overflow");
            return;
        }

        int i = heapsize;
        a[i] = x;
        heapsize++;

        while (i != 0 && a[parent(i)] > a[i]) {
            int temp = a[i];
            a[i] = a[parent(i)];
            a[parent(i)] = temp;
            i = parent(i);
        }
    }

    void removemin() {
        if (heapsize == 0) {
            System.out.println("empty heap");
        } else if (heapsize == 1) {
            heapsize--;
        } else {
            a[0] = a[heapsize - 1];
            heapsize--;
            heapify(0);
        }
    }

    void heapify(int i) {
        int l = lchild(i);
        int r = rchild(i);
        int smallest = i;

        if (l < heapsize && a[l] < a[i]) {
            smallest = l;
        }
        if (r < heapsize && a[r] < a[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            heapify(smallest);
        }
    }

    void display() {
        for (int i = 0; i < heapsize; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    int getMin() {
        return a[0];
    }

    int cursize() {
        return heapsize;
    }

    public static void main(String args[]) {
        Minheap h = new Minheap(15);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            h.insert(element);
        }

        System.out.println(h.cursize());
        System.out.println(h.getMin());

        h.removemin();
        System.out.println(h.cursize());

        h.insert(14);
        h.display();

        System.out.println(h.cursize());
        System.out.println(h.getMin());
    }
}