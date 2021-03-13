javac -d mods --module-source-path src src/com.claudiodesio.spi/module-info.java src/com.claudiodesio.spi/com/claudiodesio/spi/* src/com.claudiodesio.invs/module-info.java src/com.claudiodesio.invs/com/claudiodesio/invs/* src/com.claudiodesio.certs/module-info.java src/com.claudiodesio.certs/com/claudiodesio/certs/* src/com.claudiodesio.factory/module-info.java src/com.claudiodesio.factory/com/claudiodesio/factory/* src/com.claudiodesio.handlers/module-info.java src/com.claudiodesio.handlers/com/claudiodesio/handlers/* src/com.claudiodesio.client/module-info.java src/com.claudiodesio.client/com/claudiodesio/client/*

jar --create --file=lib/com.claudiodesio.spi.jar --module-version=1.0 -C mods/com.claudiodesio.spi .
jar --create --file=lib/com.claudiodesio.invs.jar --module-version=1.0 -C mods/com.claudiodesio.invs .
jar --create --file=lib/com.claudiodesio.certs.jar --module-version=1.0 -C mods/com.claudiodesio.certs .
jar --create --file=lib/com.claudiodesio.factory.jar --module-version=1.0 -C mods/com.claudiodesio.factory .
jar --create --file=lib/com.claudiodesio.handlers.jar --module-version=1.0 -C mods/com.claudiodesio.handlers .
jar --create --file=lib/com.claudiodesio.client.jar --module-version=1.0 --main-class=com.claudiodesio.client.TrademarkClient -C mods/com.claudiodesio.client .

pause;