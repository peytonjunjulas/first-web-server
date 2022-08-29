import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class WebServer {

    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        System.out.println("start server...");

        ServerSocket ss = null;

        try{
            ss = new ServerSocket(80);

            while (true) {
                // accept connection to client
                // cs = client socket 
                Socket cs = ss.accept();
                // get some kind of obj to write
                PrintWriter pw = new PrintWriter( cs.getOutputStream() );
                // write web page to obj
                pw.println("<h1>Hello from my first web server</h1>");
                // close resources when finished 
                pw.close();
                cs.close();
            }
        } catch (IOException e) {
            System.err.println("Port already in use");
        } finally {
            ss.close();
        }
    }
}