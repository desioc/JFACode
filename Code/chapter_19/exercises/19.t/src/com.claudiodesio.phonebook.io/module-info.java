module com.claudiodesio.phonebook.io {
  //exports com.claudiodesio.phonebook.io;
  provides com.claudiodesio.phonebook.spi.SerializationManager with com.claudiodesio.phonebook.io.FileManager;
  requires com.claudiodesio.phonebook.data;
  requires com.claudiodesio.phonebook.exceptions;
  requires com.claudiodesio.phonebook.spi;
  requires com.claudiodesio.phonebook.util;
}