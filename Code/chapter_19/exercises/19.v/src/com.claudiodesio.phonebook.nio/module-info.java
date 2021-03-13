module com.claudiodesio.phonebook.nio {
  //exports com.claudiodesio.phonebook.nio;
  provides com.claudiodesio.phonebook.spi.SerializationManager with com.claudiodesio.phonebook.nio.FileManagerNIO2;
  requires com.claudiodesio.phonebook.data;
  requires com.claudiodesio.phonebook.exceptions;
  requires com.claudiodesio.phonebook.spi;
  requires com.claudiodesio.phonebook.util;
}