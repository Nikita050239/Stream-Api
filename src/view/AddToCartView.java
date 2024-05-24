package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    public AddToCartView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("введите id продукта");
        String produktId = in.nextLine();
        if (produktId == null) return;
        System.out.println("введите количество");
        int count = in.nextInt();
        final boolean res = shopService.addToCart(produktId, count);
        if (res){
            System.out.println("Товар добавлен");
        }else {
            System.out.println("Не удалось добавить товар");
        }
    }
}
