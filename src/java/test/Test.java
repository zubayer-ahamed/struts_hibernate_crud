/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ProductDAO;

/**
 *
 * @author cyclingbd007
 */
public class Test {
    public static void main(String[] args) {
        
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getProduct(66));
        
        
    }
}
