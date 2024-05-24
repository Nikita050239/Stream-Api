package view;

import common.AppView;
import common.Pageinable;
import data.comparator.AppComparator;
import data.comparator.PriceComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Comparator;

public class CatalogView extends AppView implements Pageinable {
    final ShopService shopService;
    public CatalogView(ArrayList<AppView> children, ShopService shopService, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparators.addAll(comparators);
        if (!availableComparators.isEmpty()){
            selectedComparator = availableComparators.get(0);
        }
    }
    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectedComparator.comparator);
        hesNextPage = catalog.size() == pageLimit;
        for (Product product: catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
