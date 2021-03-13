module com.claudiodesio.phonebook.factory {
  exports com.claudiodesio.phonebook.factory to com.claudiodesio.phonebook.test;
  requires com.claudiodesio.phonebook.spi;
  requires com.claudiodesio.phonebook.data;
  uses com.claudiodesio.phonebook.spi.SerializationManager;
}

