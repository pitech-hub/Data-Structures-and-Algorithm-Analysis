public class StackArray {
    private int maxSize;
    private int[] stack;
    private int top;

    // Constructor
    public StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    // Menambahkan data ke stack
    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack Penuh!");
        } else {
            stack[++top] = data;
            System.out.println(data + " berhasil ditambahkan.");
        }
    }

    // Menghapus data dari stack
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Kosong!");
        } else {
            System.out.println("Data yang keluar: " + stack[top--]);
        }
    }

    // Melihat data teratas
    public void peek() {
        if (top == -1) {
            System.out.println("Stack Kosong!");
        } else {
            System.out.println("Data teratas: " + stack[top]);
        }
    }

    // Menampilkan isi stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack Kosong!");
        } else {
            System.out.print("Isi Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Program utama
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.peek();

        stack.pop();

        stack.display();
    }
}