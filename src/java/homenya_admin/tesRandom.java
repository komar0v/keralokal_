/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homenya_admin;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class tesRandom {

    public static void main(String[] args) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        System.out.println(String.format("%06d", number));
        
        String SALTCHARS = "ABCDEFGHIJKL1234567890MNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println(saltStr);
    }
}
