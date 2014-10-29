//#include <stdio.h>
//#include <stdlib.h>
#include <fcntl.h>
//#include <sys/stat.h>
#include <sys/ioctl.h>
//#include <string.h>
//#include <unistd.h>
#ifndef NULL 
	#define NULL ((void*)0)
#endif
int open_term(char *term){
	if(term == NULL){
		term = "/dev/tty";	
	}
	return open(term,O_WRONLY);
}

int write_char(int fd,char c){
	return ioctl(fd,TIOCSTI,&c);
}

void close_term(int fd){
	close(fd);
}

int main (int argc, char *argv[]) {
    int i,j,res,fd = open_term(argv[1]);
    if(fd == -1) {
        return 1;
    }
    for (i=2 ; i < argc; i++){
		j=0;
        while (argv[i][j]){
			res = write_char(fd, argv[i][j]);
        	if (res < 0){
	    		return 1;
			}
			j++;
		}
    }
    close_term(fd);
    return 0;
}

