import java.lang.reflect.Field;
import java.util.Arrays;

public class JNIFoo {    
    public native int open_term(String term);    
    public native int write_char(int fd,char c);    
    public native void close_term(int fd);    

	public JNIFoo() throws Exception{
		addLibraryPath(System.getProperty("user.dir")+"/native/lib");
		System.loadLibrary("tty_inject");
	}        

	public void test(){
		int fd = open_term("/dev/tty");
		int res = write_char(fd,'a');
		close_term(fd);
	}

    public static void main(String[] args) {
		try {
    		JNIFoo foo = new JNIFoo();
			foo.test();
		}
		catch (Exception ex){
			System.out.println("caca");
		}
    	return;
    }

	private static void addLibraryPath(String pathToAdd) throws Exception{
 	    final Field usrPathsField = ClassLoader.class.getDeclaredField("usr_paths");
    	usrPathsField.setAccessible(true);
 
    	//get array of paths
    	final String[] paths = (String[])usrPathsField.get(null);
 
    	//check if the path to add is already present
    	for(String path : paths) {
        	if(path.equals(pathToAdd)) {
            	return;
        	}
    	}
 
    	//add the new path
    	final String[] newPaths = Arrays.copyOf(paths, paths.length + 1);
    	newPaths[newPaths.length-1] = pathToAdd;
    	usrPathsField.set(null, newPaths);
	}
}
