import java.util.*;

class Maxheap {
    int a[];
    int maxsize;
    int heapsize;

    Maxheap(int maxsize) {
        heapsize = 0;
        this.maxsize = maxsize;
        a = new int[maxsize];
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
        if (maxsize == heapsize) {
            System.out.println("overflow");
            return;
        }

        int i = heapsize;
        a[i] = x;
        heapsize++;

        while (i != 0 && a[parent(i)] < a[i]) {
            int temp = a[i];
            a[i] = a[parent(i)];
            a[parent(i)] = temp;
            i = parent(i);
        }
    }

    void removemax() {
        if (heapsize <= 0) {
            System.out.println("empty heap");
        } else if (heapsize == 1) {
            heapsize--;
        } else {
            a[0] = a[heapsize - 1];
            heapsize--;
            Maxheapify(0);
        }
    }

    void Maxheapify(int i) {
        int l = lchild(i);
        int r = rchild(i);
        int largest = i;

        if (l < heapsize && a[l] > a[i]) {
            largest = l;
        }
        if (r < heapsize && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            Maxheapify(largest);
        }
    }

    void display() {
        for (int i = 0; i < heapsize; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    int getMax() {
        return a[0];
    }

    int cursize() {
        return heapsize;
    }
    public static void main(String args[]) {
        Maxheap h = new Maxheap(15);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            h.insert(element);
        }

        System.out.println(h.cursize());
        System.out.println(h.getMax());

        h.removemax();
        System.out.println(h.cursize());

        h.insert(14);
        h.insert(5);
        h.display();

        System.out.println(h.cursize());
        System.out.println(h.getMax());
    }
}
