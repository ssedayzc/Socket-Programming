import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // İstemci soketi oluştur ve sunucuya bağlan
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Bağlandı: " + socket);

        // Sunucuya mesaj göndermek için PrintWriter kullanın
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Sunucudan gelen mesajları okumak için BufferedReader kullanın
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Kullanıcıdan girdi alın ve sunucuya gönderin
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
            // Sunucudan gelen cevabı okuyun ve ekrana yazdırın
            System.out.println("Sunucudan gelen cevap: " + in.readLine());
        }

        // Kaynakları serbest bırakın
        out.close();
        in.close();
        br.close();
        socket.close();
    }
}
