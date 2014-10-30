NAME=tty_inject
JAVA_EXE = $(shell readlink -f `which java`)
JAVA_HOME = $(JAVA_EXE:/jre/bin/java=)
CC=gcc
CFLAGS=-shared -fPIC -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux

LIBNAME=lib$(NAME).so
SOURCENAME=$(NAME).c

all: lib 

lib: src/$(SOURCENAME)
	mkdir -p lib
	$(CC) $(CFLAGS) $< -o lib/$(LIBNAME)

clean:
	rm -rf lib
