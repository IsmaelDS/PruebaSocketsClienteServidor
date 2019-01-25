/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismaelds
 */
public class HiloParaAtenderUnCliente extends Thread{
    Socket sk;
    public HiloParaAtenderUnCliente(Socket sk){
        this.sk = sk;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = sk.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            os = sk.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            Inet4Address ip = (Inet4Address) sk.getInetAddress();
            String laIP = ip.getHostAddress();
            
            while(true){
                System.out.println("Esperando algo");
                String linea = br.readLine();
                System.out.println(laIP +": " + linea);
                /*
                while ((linea = br.readLine()) != null) {
                    bw.write(linea);
                    bw.newLine();
                    System.out.println(linea);
                }
                */
                bw.write("Este es el tiempo en " + linea +":");
                bw.write(Weather.doHttpGet(linea));
                bw.newLine();
                bw.flush();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HiloParaAtenderUnCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(is != null) is.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloParaAtenderUnCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
