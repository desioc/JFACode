module shop.sale {
    exports shop.sales.items;
    exports shop.sales.availablefunctions;
    //exports shop.sales.internalalgorithms;
    requires transitive shop.billing;
}