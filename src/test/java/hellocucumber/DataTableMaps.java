package hellocucumber;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class DataTableMaps {
    private final List<Product> products = new ArrayList<>();

    @Given("I am on the product inventory page")
    public void iAmOnTheProductInventoryPage() {

    }

    @When("I add the following products:")
    public void iAddTheFollowingProducts(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : data) {
            assertTrue(product.containsKey("Name"));
            assertTrue(product.containsKey("Quantity"));
            assertTrue(product.containsKey("Price"));

            Product p = new Product(
                product.get("Name"),
                product.get("Quantity"),
                product.get("Price")
            );

            products.add(p);
        }
    }

    @Then("the products should be added to the inventory")
    public void theProductsShouldBeAddedToTheInventory() {
        assertNotNull(products);
        assertFalse(products.isEmpty());
        // Logic to verify products are added to the inventory

        assertEquals(2, products.size());
        assertTrue(products.stream().anyMatch(p -> p.getName().equals("Laptop") && p.getQuantity() == 10 && p.getPrice() == 1000));
        assertTrue(products.stream().anyMatch(p -> p.getName().equals("Smartphone") && p.getQuantity() == 20 && p.getPrice() == 500));
    }
}
