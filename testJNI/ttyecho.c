#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/ioctl.h>
#include <string.h>
#include <unistd.h>

int main (int argc, char *argv[]) {
    char *nl = "\n";
	int fd = open(argv[1],O_RDWR);
    if(fd == -1) {
        perror("open DEVICE");
        exit(1);
    }
//	usleep(225000);
    ioctl (fd, TIOCSTI, &(argv[2][0]));
    ioctl (fd, TIOCSTI, &(argv[2][1]));
    ioctl (fd, TIOCSTI, nl);
//    ioctl (fd, TIOCSTI, 0);
    close(fd);
    exit (0);
}

