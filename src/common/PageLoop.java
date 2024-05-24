package common;

import data.comparator.AppComparator;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    int getChildrenSize() {
        return view.children.size();
    }

    int getOptionalsSize() {
        int optionalsSize = 0;
        if (view.hesNextPage) optionalsSize++;
        optionalsSize += view.availableComparators.size();
        return optionalsSize;
    }

    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalsSize();
            Scanner in = new Scanner(System.in);
            int value = in.nextInt() - 1;
            if (value < 0 || value > fullSize) {
                System.out.println("Неверное значение страницы");
            } else if (value == fullSize) {
                break;
            } else if (value < getChildrenSize()) {
                AppView selectedView = view.children.get(value);
                new PageLoop(selectedView).run();
            } else {
                if (value == getChildrenSize() || view.hesNextPage) {
                    view.nowPage++;
                    new PageLoop(view).run();
                } else {
                    view.nowPage = 0;
                    int comparatorIndex = value - getChildrenSize()  - (view.hesNextPage ? 1 : 0);
                    view.selectedComparator = view.availableComparators.get(comparatorIndex);
                    new PageLoop(view).run();
                }
            }
        }
    }

    void displayChildren() {
        int currentIndex = 1;
        System.out.println(view.title);
        System.out.println("Выбирите вариант (от 1 до " + (getChildrenSize() + getOptionalsSize() + 1) + ")");
        for (int i = 0; i < getChildrenSize(); i++) {
            AppView view1 = view.children.get(i);
            System.out.println(currentIndex + " - " + view1.title);
            currentIndex++;
        }
        if (view.hesNextPage) {
            System.out.println(currentIndex + " - " + "Следующая страница");
            currentIndex++;
        }
        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(currentIndex + " - " + view.availableComparators.get(i).name);
            currentIndex++;
        }
        System.out.println((getChildrenSize() + getOptionalsSize()+1) + " - Назад");
    }
}

