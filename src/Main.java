import common.AppView;
import common.PageLoop;
import data.comparator.AppComparator;
import data.comparator.PriceComparator;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataSourceImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.models.Product;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCardView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCardView);
        ArrayList<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true),"по возрастанию цены"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false),"по убыванию цены"));
        AppView catalogView = new CatalogView(catalogChildren, shopService, catalogComparators);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);
        new PageLoop(mainView).run();

    }
}