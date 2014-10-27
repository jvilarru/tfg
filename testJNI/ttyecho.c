#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/ioctl.h>
#include <string.h>
#include <unistd.h>

int main (int argc, char *argv[]) {
	int i,fd = open(argv[1],O_RDWR);
    if(fd == -1) {
        perror("open DEVICE");
        exit(1);
    }
	for (i=0 ; i < argc; i++){
	    ioctl (fd, TIOCSTI, &(argv[i][0]));
	}
    close(fd);
    exit (0);
}

