package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    public OrderView(ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }
final ShopService shopService;
    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите своё имя");
        String name = in.nextLine();
        System.out.println("Введите свой телефон");
        String phone = in.nextLine();

        shopService.createOrder(name, phone, "address", "cash", "18-19 hors");
    }
}
