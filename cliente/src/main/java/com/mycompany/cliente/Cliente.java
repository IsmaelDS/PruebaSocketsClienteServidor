package com.mycompany.cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismaelds
 */
public class Cliente {
    final static int PORT = 40080;
    final static String HOST = "localhost";
    
    public static void main(String[] args) {
        try {
            Socket sk = new Socket(HOST, PORT);
            
            enviarMensajesAlServidor(sk);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void enviarMensajesAlServidor(Socket sk) {
        OutputStream os = null;
        InputStream is = null;
        try {
            os = sk.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            is = sk.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            String linea, nombre;
            System.out.println("Quien eres");
            nombre = sc1.nextLine();
            
            while(true){
                
                System.out.println(nombre + ", escribe una ciudad española: ");
                
                linea = sc.nextLine();
                //System.out.println(linea);
                bw.write(linea);
                bw.newLine();
                bw.flush();
                linea = br.readLine();
                System.out.println("El servidor dice: " + linea);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(os != null) os.close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
