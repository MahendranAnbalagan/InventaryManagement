import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean valid   = true;
        Scanner scanner = new Scanner(System.in);
        InventaryClass product = new InventaryClass();
        while (valid) {
            System.out.println("1. Add a product.");
            System.out.println("2. Remove a prodocut.");
            System.out.println("3. Update product quantity.");
            System.out.println("4. Search for a product by name.");
            System.out.println("5. Display all product.");
            System.out.println("6. Save inventory to file");
            System.out.println("7. Load inventory from file");
            System.out.println("0. Exit");

            int option = scanner.nextInt();

            if (option < 0 || option > 8) {
                System.out.println("Invalid input... try again");
            }
            else{
                switch (option) {
                    case 1:
                        System.out.println("Enter the id of the product: ");
                        int id = scanner.nextInt();
                        System.out.println("Enter the name of the product: ");
                        String name = scanner.next();
                        System.out.println("Enter the quantity of the product: ");
                        int quantity = scanner.nextInt();
                        System.out.println("Enter the price of the product: ");
                        double price = scanner.nextDouble();
                        product.addProduct(new ProductClass(id, name, quantity, price));
                        break;
                
                    case 2:
                        System.out.println("Enter the id of the product: ");
                        int removeid = scanner.nextInt();
                        product.removeProduct(removeid);
                        System.out.println("Successfully removed! ");
                        break;
                    case 3:
                        System.out.println("Enter the id of the product: ");
                        int addid = scanner.nextInt();
                        System.out.println("Enter the quantity of the product: ");
                        int addquantity = scanner.nextInt();
                        product.updateProductQuantity(addid, addquantity);
                        break;
                    case 4:
                       System.out.println("Enter the name of the product: ");
                       String searchname = scanner.next();
                       product.searchProductByName(searchname);
                       break;
                    case 5:
                        product.getAllProducts();
                        break;
                    case 6:
                        System.out.println("Enter the filename: ");
                        String fileaname = scanner.next();
                        product.saveToFile(fileaname);
                        break;
                    case 7:
                        System.out.println("Enter the filename: ");
                        String loadfile = scanner.next();
                        product.loadFromFile(loadfile);
                        break;
                    case 0:
                        valid = false;
                        break;   
                }
            }
        }
    }
}
/*Display a menu with options:
Add a product
Remove a product
Update product quantity
Search for a product by name
Display all products
Save inventory to file
Load inventory from file
Exit
Handle user input and call appropriate methods from InventoryClass
 */