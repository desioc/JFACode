module com.claudiodesio.certs {
    requires com.claudiodesio.spi;
    //exports com.claudiodesio.certs to com.claudiodesio.factory;
    provides com.claudiodesio.spi.Document with com.claudiodesio.certs.Certificate;
}