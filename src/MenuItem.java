import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas MenuItem untuk merepresentasikan item menu
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Kelas Order untuk merepresentasikan pesanan
class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double calculateTotal() {
          double total = 0;
                  for (MenuItem item : items) {
                      total += item.getPrice();
                  }
                  return total;
    }
}

// Kelas Restaurant untuk mengelola pemesanan
public class Restaurant {
    private List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Goreng", 15000));
        menu.add(new MenuItem("Ayam Penyet", 25000));
        menu.add(new MenuItem("Sate", 30000));
        menu.add(new MenuItem("Es Teh", 5000));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rp " + item.getPrice());
        }
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        restaurant.displayMenu();
        System.out.println("Silakan masukkan nomor menu yang ingin dipesan (0 untuk selesai):");

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice > 0 && choice <= restaurant.menu.size()) {
                order.addItem(restaurant.menu.get(choice - 1));
                System.out.println("Item ditambahkan ke pesanan.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        // Menampilkan nota pemesanan
        System.out.println("Nota Pemesanan:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item.getName() + " - Rp " + item.getPrice());
        }
        System.out.println("Total: Rp " + order.calculateTotal());
        scanner.close();
    }
}