/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 *
 * @author Katzenbach
 */
public class Tratamiento {
       
     public int Matriz[][];
             
    public BufferedImage getGris(BufferedImage imagen) throws IOException {
        int mediaPixel, colorSRGB;
        Color colorAux;
        int Matriz [][] = new int [imagen.getWidth()][imagen.getHeight()];
        for (int i = 0; i < imagen.getWidth(); i++) {
            for (int j = 0; j < imagen.getHeight(); j++) {
                
                colorAux = new Color(imagen.getRGB(i, j));
                mediaPixel = (int) ((colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3);
                
                Matriz [i][j] = mediaPixel;
                System.out.print("" + Matriz [i][j]); 
                
                System.out.println("MediaPixel "+mediaPixel);
                colorSRGB=(mediaPixel << 16)|(mediaPixel << 8)|mediaPixel;
                System.out.println("(mediaPixel ) = "+colorSRGB );  
                imagen.setRGB(i, j, colorSRGB);
                System.out.println("");
                
                
//                System.out.println("__________________________");
          
            }
            System.out.println("");
        }          
        return imagen;
    }//Get Gris
    
    public BufferedImage getBinariza(BufferedImage imagen, int umbral_min, int umbral_max) throws IOException {
        int aux;  
        for (int i = 0; i < imagen.getHeight(); i++) {
            for (int j = 0; j < imagen.getWidth(); j++) {
                aux = imagen.getRGB(j, i) & 0xFF;
                if (aux >= umbral_min && aux <= umbral_max) {
                    imagen.setRGB(j, i, 0);// negro
                } else {
                    imagen.setRGB(j, i, -1);// blanco
                }
            }
        }
        return imagen;
    }
    
    
}
