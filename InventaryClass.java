
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InventaryClass {
    private ArrayList<ProductClass> product;

    public InventaryClass(){
        this.product = new ArrayList<>();
    }
    public void addProduct(ProductClass productClass){
       try {
        product.add(productClass);
        System.out.println("Succcessfully added!");
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
        
    }

    public void removeProduct(int id){
        try {
            for (int i = 0; i < product.size(); i++) {
                if (product.get(i).getId() == id) {
                    product.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error.....");
        }
        
    }

    public void updateProductQuantity(int id, int quantity){
        try {
            for (ProductClass productClass : product) {
                if (productClass.getId() == id) {
                    productClass.setQuantity(quantity);
                    System.out.println("Successfully Updated!");
            }
                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchProductByName(String name){
        try {
            for (ProductClass products : product) {
                if (products.getName()== name) {
                    System.out.println(products.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllProducts(){
        try {
            for (ProductClass productClass : product) {
                System.out.println(productClass);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (ProductClass products : product) {
            writer.write(products.getId() + "," + products.getName() + "," + product.getQuantity() + "," + product.getPrice());
            writer.newLine();
        }
        writer.close();
    }

    public void loadFromFile(String filaname) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filaname));
        String line;
        product.clear();
        while ((line = reader.readLine()) != null) {
            String[] parts =  line.split(line);
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            product.add(new ProductClass(id, name, quantity, price));
        }
        reader.close();

    }

}
/*Fields: A collection of ProductClass objects (e.g., ArrayList<ProductClass>)
Methods:
addProduct(ProductClass product)
removeProduct(int id)
updateProductQuantity(int id, int quantity)
searchProductByName(String name)
getAllProducts()
saveToFile(String filename)
loadFromFile(String filename) */
