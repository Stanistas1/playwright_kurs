package pl.stanistas.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanistas.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class zadanieDomowe3 extends BaseTest {
    @Test
    void test_homework1() {
        List<Product> products = getProducts();

        System.out.println(products);

        List<Integer> prices = new ArrayList<>();
        products.forEach(p -> prices.add(p.getPrice()));
        Assertions.assertTrue(prices.stream().allMatch(p -> p > 15));
    }

    @Test
    void test_homework2() {
        List<Product> products = getProducts();
        List<String> names = new ArrayList<>();
        products.forEach(p -> names.add(p.getName()));
        System.out.println(names);
        Assertions.assertTrue(names.stream().allMatch(n -> n.contains("Printed")));
    }

    private List<Product> getProducts() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dresses")).first().click();

        List<Locator> productLocators = page.locator(".product_list .ajax_block_product").all();

        List<Product> products = new ArrayList<>();
        productLocators.forEach(p -> {
            Integer price = Integer.valueOf(p.locator(".right-block .content_price .price").innerText().replace("$", ""));
            String name = p.locator(".right-block .product-name ").innerText();

            products.add(new Product(name, price));
        });
        return products;
    }
}
