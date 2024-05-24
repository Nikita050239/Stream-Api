package common;

import data.comparator.AppComparator;
import data.models.Product;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public boolean hesNextPage = false;
    public AppComparator<Product> selectedComparator;
    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();

    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }


    public void action() {
    }
}
