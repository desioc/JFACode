module shop.billing {
    exports shop.billing.items;
    exports shop.billing.availablefunctions;
    exports shop.billing.internalalgorithms;
    opens shop.billing.internalalgorithms to shop.gui;
}