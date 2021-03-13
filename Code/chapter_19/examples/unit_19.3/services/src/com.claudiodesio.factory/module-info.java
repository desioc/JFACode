module com.claudiodesio.factory {
    requires com.claudiodesio.spi;
    exports com.claudiodesio.factory to com.claudiodesio.handlers;
    uses com.claudiodesio.spi.Document;
}