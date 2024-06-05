package ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> sortProductsByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByPriceDescending() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public boolean areAllProductsExpensive(double priceThreshold) {
        return products.stream().allMatch(p -> p.getPrice() > priceThreshold);
    }

    public boolean isAnyProductCheap(double priceThreshold) {
        return products.stream().anyMatch(p -> p.getPrice() < priceThreshold);
    }

    public List<Product> findProductsByNameContaining(String searchTerm) {

        return products.stream().filter(p -> p.getName().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
    }
}
