import java.net.*;
import java.io.*;
public class ClienteOperacion{
public static void main(String []x){
ServerSocket ss = null;
try{

ss = new ServerSocket(5052);

System.out.println("escriba los numeros para enviarlos con el servidor");

BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

String cad1,cad2;


cad1=bf.readLine();

    Socket sc1 = new Socket("localhost",5051);
    OutputStream os1 = sc1.getOutputStream();
    DataOutputStream dos1 = new DataOutputStream(os1);
    dos1.writeUTF(cad1);

cad2 = bf.readLine();    
    
    Socket sc2 = new Socket("localhost",5051);
    OutputStream os2 = sc2.getOutputStream();
    DataOutputStream dos2 = new DataOutputStream(os2);
    dos2.writeUTF(cad2);

    Socket s1 = ss.accept();
    InputStream is = s1.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    System.out.println(dis.readUTF());

    dis.close();
    s1.close(); 
    sc1.close();
    dos1.close();
    sc2.close();
    dos2.close();
}

catch(IOException e){
    System.out.println("Error: no hay servidor");
}

}
}