module com.claudiodesio.invs {
    requires com.claudiodesio.spi;
    //exports com.claudiodesio.invs to com.claudiodesio.factory;
    provides com.claudiodesio.spi.Document with com.claudiodesio.invs.Invoice;
}