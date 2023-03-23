import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Sunucu soketi oluştur
        ServerSocket serverSocket = new ServerSocket(8080);

        // Bağlantıyı bekleyin
        System.out.println("Sunucu çalışıyor...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Bağlantı alındı: " + clientSocket);

        // İstemciden gelen mesajları okuyun ve ekrana yazdırın
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        // İstemciye mesaj göndermek için PrintWriter kullanın
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // İstemciden gelen mesajları okuyun ve ekrana yazdırın
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("İstemciden gelen mesaj: " + line);
            // İstemciye cevap gönderin
            out.println("Sunucudan gelen cevap: " + line);
        }

        // Kaynakları serbest bırakın
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}