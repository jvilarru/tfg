NAME=tty_inject
JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64/include
CC=gcc
CFLAGS=-shared -fPIC -I$(JAVA_HOME) -I$(JAVA_HOME)/linux

LIBNAME=lib$(NAME).so
SOURCENAME=$(NAME).c

all: lib 

lib: src/$(SOURCENAME)
	mkdir -p lib
	$(CC) $(CFLAGS) $< -o lib/$(LIBNAME)

clean:
	rm -rf lib

