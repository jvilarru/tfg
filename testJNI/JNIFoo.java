public class JNIFoo {    
    public native String nativeFoo();    
    public native int open_term(char[] term);    
    public native int write_char(int fd,char c);    
    public native void close_term(int fd);    

    static {
        System.loadLibrary("foo");
    }        

    public void print () {
    	nativeFoo();
    }
    
    public static void main(String[] args) {
    	new JNIFoo().print();
    	return;
    }
}
